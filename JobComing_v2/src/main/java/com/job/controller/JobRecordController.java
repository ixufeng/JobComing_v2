package com.job.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView getJobPublish(@RequestParam(value="index",required=false) Integer index){
		ModelAndView mv =new ModelAndView();
		if(null==index){
			index=1;
		}
		User user=(User) session.getAttribute("loginUser");
		if(user!=null){
			List<Job> list=js.getJobListByUserId(user.getUserId(),-1,-1);
			int allPage=0;
			if(list.size()%5==0){
				allPage=list.size()/5;
			}else{
				allPage=list.size()/5+1;
			}
			List<Job> list2=js.getJobListByUserId(user.getUserId(),5*(index-1),5*index);
			mv.setViewName("info3");
			mv.addObject("allpage", allPage);
			mv.addObject("index", index);
			mv.addObject("jobPublishList", list2);
		}else{
			mv.setViewName("redirect:../jobs");
		}
		return mv;
	}
	@RequestMapping("/together")
	public ModelAndView getTogether(@RequestParam(value="index",required=false) Integer index){
		ModelAndView mv =new ModelAndView();
		if(null==index){
			index=1;
		}
		User user=(User) session.getAttribute("loginUser");
		if(user!=null){
			List<Agreement> list=agree.getAgreeListByUser(user.getUserId(),-1,-1);
			int allPage=0;
			if(list.size()%5==0){
				allPage=list.size()/5;
			}else{
				allPage=list.size()/5+1;
			}
			List<Agreement> list2=agree.getAgreeListByUser(user.getUserId(),5*(index-1),5*index);
			mv.setViewName("info3");
			mv.addObject("allpage", allPage);
			mv.addObject("index", index);
			mv.setViewName("info2");
			mv.addObject("allpage", allPage);
			mv.addObject("index", index);
			mv.addObject("jobTogetherList", list2);
		}else{
			mv.setViewName("redirect:../jobs");
		}
		return mv;
	}
	
}
