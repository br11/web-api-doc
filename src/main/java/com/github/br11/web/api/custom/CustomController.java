package com.github.br11.web.api.custom;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CustomController {

	private static long ID_FACTORY = 1;
	private static final Map<Long, CustomBean> data = new HashMap<>();

	@ApiOperation("Saves a new custom bean")
	@RequestMapping(value = "/custom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomBean insert(CustomBean bean) {
		long id = ID_FACTORY++;
		data.put(id, bean.setId(id));
		return get(id);
	}

	@ApiOperation("Retrives a custom bean data")
	@RequestMapping(value = "/custom/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomBean get(Long id) {
		return data.get(id);
	}

}