package com.job.bean;

import java.util.Date;

public class Chat {

	private int chatId;
	private int  userSendId;
	private int userRecieveId;
	private String chatContent;
	private Date chatTime;
	private int status;
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public int getUserSendId() {
		return userSendId;
	}
	public void setUserSendId(int userSendId) {
		this.userSendId = userSendId;
	}
	public int getUserRecieveId() {
		return userRecieveId;
	}
	public void setUserRecieveId(int userRecieveId) {
		this.userRecieveId = userRecieveId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
