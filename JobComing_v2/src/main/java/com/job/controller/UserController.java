package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.User;
import com.job.service.UserService;
@Controller
@SessionAttributes("loginUser")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uService;
	/**
	 * 登录
	 * @param u
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(User u){
		if(uService.login(u)){
			return new ModelAndView("main","loginUser",u);
		}
		return new ModelAndView("login");
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(User user){
		if(uService.register(user)){
			return new ModelAndView("login");
		}
		return new ModelAndView("register");
	}
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("jobpublish");
	}
}
