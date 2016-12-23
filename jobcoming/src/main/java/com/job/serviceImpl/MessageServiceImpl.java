package com.job.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.BulletMessage;
import com.job.bean.Chat;
import com.job.dao.ChatDao;
import com.job.service.MessageService;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;


/**
 * message服务
 * @author xufeng
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
	

	private final String goEasyKey = "93468357-b450-4c4b-a011-ce2dd9e9b59a"; //超级key,可以接收，可以发送，只保留在服务器端
	private final String bulletChannel = "bulletMessage";
	
	@Autowired
	private ChatDao chatDao;
	
	/**
	 * 发送弹幕
	 * @param content
	 */
	@Override
	public boolean pushBulletMessage(BulletMessage bullet){
		
		String content = bullet.toString();
		
		GoEasy goEasy = new GoEasy(this.goEasyKey);
		goEasy.publish(bulletChannel, content, new PublishListener(){
			
			@Override
			public void onSuccess() {
	
			}
			
			@Override
			public void onFailed(GoEasyError error) {
			
			}
			
		});
		
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean addChatMessage(Chat chat) {
		
		if(chat.getChatContent()!=null&&!chat.getChatContent().trim().equals("")&&chat.getUserRecieveId()>0&&chat.getUserRecieveId()>0){
			chat.setChatTime(new Date());
			chatDao.insert(chat);
			return true;
		}
		
		return false;
	}
	/**
	 * 获取聊天记录并删除
	 */
	@Override
	public List<Chat> getChatMessage(int userId) {
		List<Chat> list = new ArrayList<Chat>();
		if(userId>0){
			list = chatDao.getChatListByUserId(userId);
			List<Integer> tempList = new ArrayList<>();
			if(list.size()>0){
				
				for(Chat chat:list){
					tempList.add(chat.getChatId());
				}
			}
			chatDao.delete(tempList);
		}
		
		
		return list;
	}
	
}
