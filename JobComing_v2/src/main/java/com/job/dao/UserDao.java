package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	public User getUserByUserName(@Param("userName")String userName);
	
	/**
	 * 更新用户头像
	 * @param avatar
	 */
	public void updateUserAvatar(@Param("userId")int userId,@Param("userAvatar") String userAvatar);
	
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
	
	/**
	 * 添加一个用户
	 * @param user
	 */
	
	public boolean addUser(User user);
	
	
	/**
	 * 查找用户关注的人
	 * @param userId
	 * @return
	 */
	public List<User> getAttentionUser(@Param("userId") int userId);  
	
	
	/**
	 * 查找关注自己的人
	 * @param userId
	 * @return
	 */
	public List<User> getFancyUser(@Param("userId") int userId);
	
	
	
}
