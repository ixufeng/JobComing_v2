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
import com.job.bean.User;
import com.job.service.AgreementService;
import com.job.service.JobService;
import com.job.serviceImpl.MailServiceImpl;
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
	
	private static Map<Integer,Job>jobMap = new HashMap<>();  
	
	/**
	 *将工作放入map中进行维护
	 */
	static{
		
	}
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private HttpSession session;
	@Autowired
	private AgreementService agreeService;
	
	@RequestMapping("/jobs")
	public ModelAndView mainPage(@RequestParam(value="pageIndex",required=false)Integer pageIndex,SearchMap searchMap){
		
		ModelAndView mv = new ModelAndView();
		
		//閸忓牐骞忛崣鏉漞ssion娑擃厺绻氱�涙娈憇earchkey
		@SuppressWarnings("unchecked")
		Map<String,Object>sessionMap = (Map<String, Object>) this.session.getAttribute("sessionMap");
		
		//url娑擃厺绱堕弶銉ф畱map
		Map<String,Object> map = searchMap.getMap();
		
		if(pageIndex!=null){
			
			map.put("pageIndex", pageIndex);
		}
		//娴狀櫥rl娑擃厾娈憁ap娑撹桨绱崗锟�
		if(sessionMap!=null){
			sessionMap.putAll(map);
		}else{
			sessionMap = new HashMap<String,Object>();
			sessionMap.putAll(map);
		}
		
		//濞ｈ濮為崗鑹颁捍缁夊秶琚�
		List<JobKind> list = new ArrayList<JobKind>();
		list = jobService.getJobKinds();
		mv.addObject("jobKinds", list);
		
		
		mv.setViewName("main");
		mv.addObject("jobs", jobService.getJobs(sessionMap));
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
	/**
	 *发送求职邮件
	 * @param jobId
	 * @return
	 */
	@RequestMapping("ajax_jobMail")
	public @ResponseBody String jobMail(@RequestParam int jobId){
		User u = session.getAttribute("loginUser")==null?null:(User)session.getAttribute("loginUser");
		if(u!=null){
			Job job = this.jobService.getJobById(jobId);
			
			if(job!=null){
				if(job.getSendUser().getUserId()==u.getUserId()){
					
					return "selfJob";
				}else{
					if(agreeService.getAgreementByUserIdAndJId(u.getUserId(), jobId)!=null){
						return "hasJob";
					}
					//鍙戦�侀偖浠�
					boolean bol = MailServiceImpl.applyForJobMail(job.getSendUser().getEmail(), u, job);
					//澧炲姞鍗忚
					agreeService.update(u.getUserId(), jobId, 1);
					if(bol)return "success";
				}
				
			}else{
				return "invalidJob";
			}
		}else{
			
			return "unlogin";
		}
		return "faliure";
	}
	
	/**
	 * 异步获取用户信息
	 * @return
	 */
	@RequestMapping("ajax_isLogin")
	public @ResponseBody User isLogin(){
		
		Object obj = this.session.getAttribute("loginUser");
		
		return obj==null?null:(User)obj;
	} 
	

}
