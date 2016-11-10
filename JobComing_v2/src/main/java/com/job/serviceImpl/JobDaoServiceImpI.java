package com.job.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.Job;
import com.job.dao.JobDao;
import com.job.service.JobDaoService;
@Service
public class JobDaoServiceImpI implements JobDaoService {
	@Autowired
	private JobDao jobdao;
	@Override
	public boolean addJob(Job job) {
		if(job!=null){
		  job.setJobTime(new Date());
		  jobdao.addJob(job);
		  return true;
		}else{
			return false;
		}
	}

}
