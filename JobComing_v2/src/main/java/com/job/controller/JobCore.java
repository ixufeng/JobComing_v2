package com.job.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.Job;
import com.job.bean.JobKind;
import com.job.bean.SearchMap;
import com.job.service.JobService;
import com.job.utils.TimeUtils;

/**
 * 
 * @author xufeng
 *
 */
@SessionAttributes("sessionMap")
@Controller
@RequestMapping("/")
public class JobCore {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/jobs")
	public ModelAndView mainPage(@RequestParam(value="pageIndex",required=false)Integer pageIndex,SearchMap searchMap){
		
		ModelAndView mv = new ModelAndView();
		
		//鍏堣幏鍙杝ession涓繚瀛樼殑searchkey
		@SuppressWarnings("unchecked")
		Map<String,Object>sessionMap = (Map<String, Object>) this.session.getAttribute("sessionMap");
		
		//url涓紶鏉ョ殑map
		Map<String,Object> map = searchMap.getMap();
		
		if(pageIndex!=null){
			
			map.put("pageIndex", pageIndex);
		}
		//浠rl涓殑map涓轰紭鍏�
		if(sessionMap!=null){
			sessionMap.putAll(map);
		}else{
			sessionMap = new HashMap<String,Object>();
		}
		
		//娣诲姞鍏艰亴绉嶇被
		List<JobKind> list = new ArrayList<JobKind>();
		list = jobService.getJobKinds();
		mv.addObject("jobKinds", list);
		
		
		mv.setViewName("main");
		mv.addObject("jobs", jobService.getJobs(map));
		mv.addObject("sessionMap", sessionMap);

		return mv;
	}
	
	@RequestMapping("/ajax_searchKey")
	public @ResponseBody Map<String,Object>  getSearchMap(){
		
		@SuppressWarnings("unchecked")
		Map<String,Object> sessionMap = (Map<String, Object>) this.session.getAttribute("sessionMap");
		
		if(sessionMap!=null){
			return sessionMap;
		}
		return null;
	}
	
	@RequestMapping("ajax_todayJobs")
	public @ResponseBody List<Job>  getTodayJobs(){
		
		List<Job> list = new ArrayList<Job>();
		
		Map<String,Object> todayMap = new HashMap<String,Object>();
		todayMap.put("jobTime",TimeUtils.getTodayBeginDateTime());
		list = jobService.getJobs(todayMap);
		return list;
	}
	
	@RequestMapping("ajax_jobKinds")
	public @ResponseBody List<JobKind> getJobKinds(){
		List<JobKind> list = new ArrayList<JobKind>();
		
		list = jobService.getJobKinds();
		
		return list;
	}
	@RequestMapping("/jobInfo")
	public ModelAndView getJobInfo(@RequestParam("jobId") int jobId){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("job", jobService.getJobById(jobId));
		mv.setViewName("jobInfo");
		return mv;
	}
	

}
