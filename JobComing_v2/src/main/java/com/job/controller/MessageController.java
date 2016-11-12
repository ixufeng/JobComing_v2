package com.job.controller;



import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.bean.BulletMessage;
import com.job.bean.Chat;
import com.job.bean.User;
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
	
	@Autowired
	private HttpSession session;
	
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
	
	/**
	 * 发送聊天记录
	 */
	@RequestMapping("/ajax_sendchat")	
	public @ResponseBody String sendChatMessage(Chat chat){
		
		Object obj = this.session.getAttribute("loginUser");
		User u = obj==null?null:(User)obj;
		System.out.println(chat==null);
		System.out.println("11");
		if(chat!=null){
			System.out.println(chat.getChatContent());
			System.out.println(chat.getUserRecieveId());
		}
		if(u!=null){
			chat.setUserSendId(u.getUserId());
			if(this.messageService.addChatMessage(chat)){
				return "success";
			}
		
		}
		return "error";
	}
	/**
	 * 接受消息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/ajax_getchat")
	public @ResponseBody List<Chat> getChatMessage(int userId){
		List<Chat> list = new ArrayList<Chat>();
		list = messageService.getChatMessage(userId);
		return list;
	}
}
