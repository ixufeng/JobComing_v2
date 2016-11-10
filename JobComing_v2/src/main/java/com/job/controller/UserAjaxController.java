package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.bean.User;
import com.job.service.RegisterService;
@Controller
@RequestMapping("/UserAjax")
public class UserAjaxController {
	@Autowired 
	private RegisterService rs;
	/**
	 * 验证用户是否重名
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userIsExist")
	public String userIsExist(@RequestParam("username")String userName){
		User user=rs.getUserByName(userName);
		if(user!=null){
			return "用户名已存在";
		}
		return null;
	}
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/emailIsExist")
	public String emailIsExit(@RequestParam("email") String email){
		User user=rs.getUserByEmail(email);
		if(user!=null){
			return "邮箱已经存在";
		}
		return null;
	}
	@ResponseBody
	@RequestMapping("/phoneIsExist")
	public String phoneIsExist(@RequestParam("phone") long phone){
		User user=rs.getUserByPhone(phone);
		if(user!=null){
			return "手机已经存在";
		}
		return null;
	}
}
