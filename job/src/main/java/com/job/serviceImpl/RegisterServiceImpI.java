package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.User;
import com.job.dao.UserDao;
import com.job.service.RegisterService;
@Service
public class RegisterServiceImpI implements RegisterService {
	@Autowired
	private UserDao UserDao;
	@Override
	/**
	 * 根据用户名返回用户对象
	 * @param userName
	 * @return
	 */
	public User getUserByName(String userName) {
		User user=new User();
		user=UserDao.getUserByUserName(userName);
		return user;
	}

	@Override
	/**
	 * 根据邮箱返回用户对象
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email) {
		User user=new User();
		user=UserDao.getUserByEmail(email);
		return user;
	}

	@Override
	/**
	 * 根据手机返回用户对象
	 * @param phone
	 * @return
	 */
	public User getUserByPhone(long phone) {
		User user=new User();
		user=UserDao.getUserByPhone(phone);
		return user;
	}

}
