package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.job.service.TestService;

@Controller
@RequestMapping("/hello")
public class TestController {
	
	@Autowired
	private TestService service;
	
	@RequestMapping("/hello")
	public String hello(){
		
		service.hello();
		
		return "hello";
	}
}
