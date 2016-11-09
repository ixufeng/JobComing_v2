package com.job.serviceImpI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.User;
import com.job.dao.UserDao;
import com.job.service.UserService;
@Service
public class UserServiceImpI implements UserService {
	@Autowired
	private UserDao userdao;
	@Override
	/**
	 * 登录
	 */
	public boolean login(User u) {
		User user=userdao.getUserByUserName(u.getUserName());
		if(user!=null){
			if(user.getPassword().equals(u.getPassword())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	/**
	 * 注册
	 */
	@Override
	public boolean register(User u) {
		if(userdao.addUser(u)){
			return true;
		}
		return false;
	}

}
