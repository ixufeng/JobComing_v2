package com.job.dao;

import com.job.bean.User;

public interface UserDao {
	/**
	 * 根据用户id来查询一个简单的userId
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId);

	/**
	 * 根据用户名来返回一个简单的用户
	 * @param userName
	 */
	public User getUserByUserName(String userName);
	
	/**
	 * 更新用户头像
	 * @param avatar
	 */
	public void updateUserAvatar(String avatar);
	
	/**
	 * 更新用户积分
	 * @param score
	 */
	public void updateUserScore(int score);
	
	/**
	 * 更新用户参数
	 * @param user
	 */
	public void updateUser(User user);
}
