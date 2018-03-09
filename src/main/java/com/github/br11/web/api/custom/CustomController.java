package com.github.br11.web.api.custom;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CustomController {

	private static long ID_FACTORY = 1;
	private static final Map<Long, CustomBean> data = new HashMap<>();

	@ApiOperation(value = "Saves a new custom bean", consumes = "the new custom bean data", produces = "the persisted custom bean data with an id")
	@RequestMapping(value = "/custom", method = RequestMethod.POST)
	public CustomBean insert(CustomBean bean) {
		long id = ID_FACTORY++;
		data.put(id, bean.setId(id));
		return get(id);
	}

	@ApiOperation(value = "Retrives a custom bean data", consumes = "the id of the custom bean to retrieve", produces = "the custom bean data with for the id")
	@RequestMapping(value = "/custom/{id}", method = RequestMethod.GET)
	public CustomBean get(Long id) {
		return data.get(id);
	}

}