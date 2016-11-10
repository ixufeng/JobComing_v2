package com.job.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.Job;
import com.job.service.JobService;
import com.job.utils.DateEditor;
@Controller
@RequestMapping("/jobPublish")
public class JobPublishController {
	@Autowired
	private JobService jService;
	/**
	 * 宸ヤ綔鍙戝竷
	 * @param job
	 * @return
	 */
	@RequestMapping(value="/submitJob",method=RequestMethod.POST)
	public ModelAndView jobPublish( Job job){
		if(jService.addJob(job)){
			return new ModelAndView("main");
		}else{
			return new ModelAndView("/jobPublish/submitJob");
		}
		
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
