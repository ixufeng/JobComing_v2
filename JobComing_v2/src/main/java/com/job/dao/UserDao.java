package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.User;

public interface UserDao {
	/**
	 * 
	 * �����û�id����ѯһ���򵥵�userId
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId);

	/**
	 * 
	 * �����û���������һ���򵥵��û�
	 * @param userName
	 */
	public User getUserByUserName(@Param("userName")String userName);
	
	/**
	 * 
	 * �����û�ͷ��
	 * @param avatar
	 */
	public void updateUserAvatar(@Param("userId")int userId,@Param("userAvatar") String userAvatar);
	
	/**
	 * 
	 * �����û�����
	 * @param score
	 */
	public void updateUserScore(int score);
	
	/**
	 * 
	 * �����û�����
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 
	 * ���һ���û�
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
	 * ���ҹ�ע�Լ�����
	 * @param userId
	 * @return
	 */
	public List<User> getFancyUser(@Param("userId") int userId);
	/**
	 * 通过邮箱查找用户
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);
	/**
	 * 通过电话查找用户
	 * @param phone
	 * @return
	 */
	public User getUserByPhone(long phone);
	
}
