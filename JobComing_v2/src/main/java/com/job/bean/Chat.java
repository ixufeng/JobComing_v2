package com.job.bean;

import java.util.Date;

public class Chat {

	private int chatId;
	private int  userSendId;
	private int userRecievedId;
	private String charContent;
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
	public int getUserRecievedId() {
		return userRecievedId;
	}
	public void setUserRecievedId(int userRecievedId) {
		this.userRecievedId = userRecievedId;
	}
	public String getCharContent() {
		return charContent;
	}
	public void setCharContent(String charContent) {
		this.charContent = charContent;
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
