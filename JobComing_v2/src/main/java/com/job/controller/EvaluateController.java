package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.job.dao.EvaluateDao;
@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
	@Autowired
	private EvaluateDao eva;
	//@RequestMapping("/do")
	//public ModelAndView Evaluate(com.job.bean.Evaluate evaluate ){
		
	//}
}
