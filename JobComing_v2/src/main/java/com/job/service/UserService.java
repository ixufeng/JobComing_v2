package com.job.service;

import com.job.bean.User;

public interface UserService {

	/**
	 * 用户登录
	 * @return
	 */
	public boolean login(User u);
	
	public boolean register(User u);
	
	
}