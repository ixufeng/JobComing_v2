package com.job.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.job.bean.Job;


public interface JobService {

	/**
	 * 
	 * @return
	 */
	public List<Job> getJobs(Map<String,Object> map);
	
	
}
