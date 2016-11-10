package com.job.service;

import com.job.bean.User;

public interface RegisterService {
	/**
	 * 通过用户名返回对象
	 * @param userName
	 * @return
	 */
	public User getUserByName(String userName);
	/**
	 * 通过email返回用户对象
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);
	/**
	 * 通过phone返回用户对象
	 * @param phone
	 * @return
	 */
	public User getUserByPhone(long phone);
}
