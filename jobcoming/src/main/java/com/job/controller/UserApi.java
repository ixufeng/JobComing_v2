package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.service.UserService;

@Controller
@RequestMapping("/api")
public class UserApi {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/active")
	public String acticeCount(@RequestParam("activeCode") String activeCode){
		if(userService.activeUser(activeCode).equals("success")){
			return "激活成功";
		}
		return "激活失败或者账户已经激活";
	}
}
