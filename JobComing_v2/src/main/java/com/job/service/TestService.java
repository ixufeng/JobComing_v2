package com.job.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.dao.JobDao;
import com.job.dao.UserDao;

@Service
public class TestService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private JobDao jobDao;
	
	
	public void hello(){
		
	/*Map<String,Object> map  = new HashMap<String,Object>();
	map.put("jobKindName", "清洁");
	map.put("userName","admin");
	map.put("cityName", "上海");*/
	
	
	System.out.println(jobDao.getJobByJobId(1).getCityName());
	
	}
}
