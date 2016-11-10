package com.job.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.bean.BulletMessage;
import com.job.service.MessageService;

/**
 * 
 * @author xufeng
 *
 */
@RequestMapping("/message")
@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	
	/**
	 * 发送弹幕
	 */
	@RequestMapping("/bullet")
	public @ResponseBody String bullet(BulletMessage bul){
		
		
		if(this.messageService.pushBulletMessage(bul)){
			return "success";
		}
		
		return "error";
		
	}
	
	
}
