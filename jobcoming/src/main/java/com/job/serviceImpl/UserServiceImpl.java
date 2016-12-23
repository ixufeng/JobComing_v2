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
	public synchronized boolean register(User u) {
		if(u!=null){
			if(userDao.addUser(u)){
				System.out.println("42" + u.getBirthday());
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


	@Override
	public User getUserByActiveCode(String activeCode) {
		if(activeCode==null||activeCode.length()<20){
			return null;
		}
		return userDao.getUserByActiveCode(activeCode);

	}

	@Override
	public String activeUser(String code) {
		User u = getUserByActiveCode(code);
		if(u!=null){
			if(code.equals(u.getIdentifyCode())){
				//验证成功
				u.setIdentifyCode("jobcoming_" + u.getUserName());
				userDao.updateUser(u);
				return "success";
			}
		}
		return "failed";
	}
}
