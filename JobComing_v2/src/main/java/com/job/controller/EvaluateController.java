package com.job.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.job.bean.Evaluate;
import com.job.bean.User;
import com.job.service.AgreementService;
import com.job.serviceImpl.EvaluateImpI;
@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
	@Autowired
	private EvaluateImpI eva;
	@Autowired
	private AgreementService agree;
	@Autowired
	HttpSession session;
	@RequestMapping("/do")
	public ModelAndView Evaluate(Evaluate evaluate,@RequestParam("jobId") int jobId){
		ModelAndView mv = new ModelAndView();
		User user=(User) session.getAttribute("loginUser");
		mv.setViewName("redirect:../jobRecord/together");
		if(user!=null){
			int userId=user.getUserId();
			evaluate.setJobId(jobId);
			evaluate.setUserId(userId);
			evaluate.setEvaluateTime(new Date());
			if(eva.insert(evaluate)){
				agree.update(userId, jobId, 5);
			}
		}
		return mv;
	}
}
