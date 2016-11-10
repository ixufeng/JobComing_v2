package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.User;
import com.job.dao.UserDao;
import com.job.service.UserService;

/**
 * 用户服务类
 * @author xufeng
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean login(User u) {
		
		if(u==null||u.getUserName()==null||u.getPassword()==null)
			return false;
		
		User user = userDao.getUserByUserName(u.getUserName());
		if(user!=null){
			if(user.getPassword().equals(u.getPassword())){
				return true;
			}
		}
		
		
		return false;
	}

	@Override
	public boolean register(User u) {
		if(userDao.addUser(u)){
			return true;
		}
		return false;
	}
}
