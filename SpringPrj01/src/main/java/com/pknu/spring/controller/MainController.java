package com.pknu.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/first")
	public String first() {
		return "first";
	}
	@RequestMapping("/second")
	public String second() {
		return "first";
	}
}
