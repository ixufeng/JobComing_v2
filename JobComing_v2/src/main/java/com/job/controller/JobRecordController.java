package com.job.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.Agreement;
import com.job.bean.Job;
import com.job.bean.User;
import com.job.service.AgreementService;
import com.job.service.JobService;

@Controller
@RequestMapping("/jobRecord")
public class JobRecordController {
	@Autowired
	private JobService js;
	@Autowired
	private AgreementService agree;
	@Autowired
	private HttpSession session;
	@RequestMapping("/jobPublish")
	public ModelAndView getJobPublish(){
		User user=(User) session.getAttribute("loginUser");
		if(user!=null){
			List<Job> list=js.getJobListByUserId(user.getUserId());
			return new ModelAndView("info3","jobPublishList",list);
		}
		return new ModelAndView("redirect:../jobs");
	}
	@RequestMapping("/together")
	public ModelAndView getTogether(){
		User user=(User) session.getAttribute("loginUser");
		if(user!=null){
			List<Agreement> list=agree.getAgreeListByUser(user.getUserId());
			return new ModelAndView("info2","jobTogetherList",list);
		}
		return new ModelAndView("redirect:../jobs");
	}
	
}
