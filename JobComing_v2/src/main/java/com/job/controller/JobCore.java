package com.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页核心控制
 * @author xufeng
 *
 */

@Controller
@RequestMapping("/test")
public class JobCore {
	
	@RequestMapping("/jobs")
	public ModelAndView mainPage(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	
	@RequestMapping("/hello")
	public String test(){
		
		return "hello";
	}
	
	
}
