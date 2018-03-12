package com.github.br11.web.api.custom;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.github.br11.web.api.App;

/**
 * @author Josh Long
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class CustomControllerTest {

	// private MediaType contentType = new
	// MediaType(MediaType.APPLICATION_JSON.getType(),
	// MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MediaType contentType = MediaType.APPLICATION_JSON_UTF8;

	private String userName = "bdussault";

	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testInsert() throws Exception {
		mockMvc.perform(post("/api/custom/") //
				.content(this.json(new CustomBean("Doe, John", new Date(), 1234.56))) //
				.contentType(contentType)) //
				.andExpect(status().isOk()) //
				//.andDo(print()) //
		;
	}

	@Test
	public void testGet() throws Exception {
		mockMvc.perform(post("/api/custom/") //
				.content(this.json(new CustomBean("Doe, John", new Date(), 1234.56))) //
				.contentType(contentType)) //
				.andExpect(status().isOk()) //
		;

		mockMvc.perform(get("/api/custom/1")) //
				.andExpect(status().isOk()) //
				.andDo(print()) //
		;
	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}