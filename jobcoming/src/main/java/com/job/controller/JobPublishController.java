package com.job.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.Job;
import com.job.bean.User;
import com.job.service.JobService;
import com.job.utils.DateEditor;
@Controller
@RequestMapping("/jobPublish")
public class JobPublishController {
	/**
	 * 
	 * @param job
	 * @return
	 */
	@Autowired
	private JobService jobService;
	@Autowired
	private HttpSession session;
	@RequestMapping(value="/submitJob",method=RequestMethod.POST)
	public ModelAndView jobPublish( Job job){
		ModelAndView mv = new ModelAndView();
		Object objUser = session.getAttribute("loginUser");
		if(objUser!=null){
			User u = (User) objUser;
			job.setJobTime(new Date());
			job.setUserId(u.getUserId());
			if(jobService.addJob(job)){
				mv.setViewName("redirect:../jobs");
			}else{
				mv.setViewName("jobpublish");
			}
			
		}else{
			mv.setViewName("jobpublish");
		}
		return mv;
	}
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Date.class, "beginTime",new DateEditor());;
	}
	@InitBinder
	public void initBinderTwo(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Date.class, "endTime",new DateEditor());;
	}
}
