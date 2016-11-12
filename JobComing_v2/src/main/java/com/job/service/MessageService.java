package com.job.service;

import java.util.List;

import com.job.bean.BulletMessage;
import com.job.bean.Chat;

public interface MessageService {
	

	public boolean pushBulletMessage(BulletMessage bullet);
	public boolean addChatMessage(Chat chat);
	public List<Chat> getChatMessage(int userId);
	
}
