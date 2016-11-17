package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.User;
import com.job.dao.UserDao;
import com.job.service.UserService;

/**
 * 鐢ㄦ埛鏈嶅姟绫�
 * @author xufeng
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(User u) {
		
		if(u==null||u.getUserName()==null||u.getPassword()==null)
			return null;
		
		User user = userDao.getUserByUserName(u.getUserName());
		if(user!=null){
			if(user.getPassword().equals(u.getPassword())){
				return user;
			}
		}
		
	
		return null;
	}

	@Override
	public boolean register(User u) {
		if(u!=null){
			if(userDao.addUser(u)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public boolean updateUserAvatar(int userId, String userAvatar) {
		if(userId!=0&&userAvatar!=null){
			userDao.updateUserAvatar(userId, userAvatar);
			return true;
		}
		return false;
	}
}
