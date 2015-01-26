package com.taxation.bureau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shops/shopsController")
public class ShopsController {
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		return "hello";
	}

}
