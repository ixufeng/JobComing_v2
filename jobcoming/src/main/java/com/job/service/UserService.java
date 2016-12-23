package com.job.service;


import com.job.bean.User;

public interface UserService {

	/**
	 * 用户登录
	 * @return
	 */
	public User login(User u);
	/**
	 * 用户注册
	 * @param u
	 * @return
	 */
	public boolean register(User u);
	
	public boolean updateUserAvatar(int userId,String userAvatar);
	
	public User getUserByActiveCode(String activeCode);
	public String activeUser(String code);
}
