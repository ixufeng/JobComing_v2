package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.User;
import com.job.dao.UserDao;

@Service
public class TestService {

	@Autowired
	private UserDao userDao;
	
	
	public void hello(){
		User u = new User();
		u.setUserName("admin");
		u.setPassword("admin");
		userDao.addUser(u);
		System.out.println("≤Â»Î≥…π¶");
		
	}
}
