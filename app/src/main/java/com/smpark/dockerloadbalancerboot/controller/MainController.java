package com.smpark.dockerloadbalancerboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

	@GetMapping(path = "/")
	public Map<String, Object> main() {
		Map<String, Object> ret = new HashMap<>();

		ret.put("root", "test");

		return ret;
	}

	@GetMapping(path = "/test.do")
	public Map<String, Object> test() {
		Map<String, Object> ret = new HashMap<>();

		ret.put("test", "test");

		return ret;
	}

}
