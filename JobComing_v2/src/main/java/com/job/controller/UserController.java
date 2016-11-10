package com.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.Job;
import com.job.bean.User;
import com.job.service.JobService;
import com.job.service.UserService;
@Controller
@SessionAttributes("loginUser")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private JobService jobService;
	/**
	 * 登录
	 * @param u
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(User u){
		if(uService.login(u)){
			return new ModelAndView("redirect:../jobs","loginUser",u);
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
	@RequestMapping("/goLogin")
	public ModelAndView gologin(){
		return new ModelAndView("login");
	}
	@RequestMapping("/goRegister")
	public ModelAndView goRegister(){
		return new ModelAndView("register");
	}
	@RequestMapping("/goUser")
	public ModelAndView goInfo1(){
		return new ModelAndView("info1");
	}
	@RequestMapping("/goJobPublish")
	public ModelAndView goJobPublish(){
		return new ModelAndView("jobpublish");
	}
	@RequestMapping("/goTogether")
	public ModelAndView goInfo2(){
		return new ModelAndView("info2");
	}
	@RequestMapping("/goPublish")
	public ModelAndView goInfo3(){
		return new ModelAndView("info3");
	}
	@RequestMapping("/goMain")
	public ModelAndView goMain(){
		return new ModelAndView("main");
	}
	@RequestMapping("ajax_jobs")
	public @ResponseBody List<Job>getJobs(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("jobKindName", "清洁");
		return this.jobService.getJobs(map);
	}
}
