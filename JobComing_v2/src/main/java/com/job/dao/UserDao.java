package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.User;

public interface UserDao {
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId);

	/**
	 * 
	 * @param userName
	 */
	public User getUserByUserName(@Param("userName")String userName);
	
	/**
	 * 
	 * @param avatar
	 */
	public void updateUserAvatar(@Param("userId")int userId,@Param("userAvatar") String userAvatar);
	
	/**
	 * 
	 * @param score
	 */
	public void updateUserScore(int score);
	
	/**
	 * 
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 
	 * @param user
	 */
	
	public boolean addUser(User user);
	
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<User> getAttentionUser(@Param("userId") int userId);  
	
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<User> getFancyUser(@Param("userId") int userId);
	
	
	
}
