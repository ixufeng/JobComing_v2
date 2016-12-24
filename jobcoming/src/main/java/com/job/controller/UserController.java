package com.job.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.job.bean.Job;
import com.job.bean.User;
import com.job.service.JobService;
import com.job.service.UserService;
import com.job.serviceImpl.MailServiceImpl;
import com.job.utils.DateEditor;
@Controller
@SessionAttributes("loginUser")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private JobService jobService;
	@Autowired
	private HttpSession session;
	/**
	 * 登录
	 * @param u
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(User u){
		User user=uService.login(u);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		if(user!=null){
			String identifyCode = user.getIdentifyCode();
			if(identifyCode!=null&&identifyCode.length()>9&&identifyCode.substring(0, 9).equalsIgnoreCase("jobcoming")){
				mv.setViewName("redirect:../jobs");
				mv.addObject("loginUser", user);
			}else{
				
				mv.addObject("tip", "identify not active");
			}
		}
		return mv;
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(User user){
		String code=UUID.randomUUID().toString();
		user.setIdentifyCode(code);
		
		if(uService.register(user)){
			
			MailServiceImpl.sendActiveMail(user.getEmail(),code);
			return new ModelAndView("registerSuccess");
		}
		return new ModelAndView("register");
	}
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Date.class, "birthday",new DateEditor());;
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
		ModelAndView mv=new ModelAndView();
		int age=Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
		User user=(User) session.getAttribute("loginUser");
		
		if(user!=null){
			Date birth=user.getBirthday();
			if(birth!=null){
				mv.setViewName("info1");
				age-=Integer.parseInt(new SimpleDateFormat("yyyy").format(birth));
				mv.addObject("age", age);
			}else{
				mv.setViewName("redirect:../jobs");
			}
		}else{
			mv.setViewName("redirect:../jobs");
		}
		return mv;
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
	
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(){
		this.session.setAttribute("loginUser", null);
		return new ModelAndView("redirect:login");
	}
}
