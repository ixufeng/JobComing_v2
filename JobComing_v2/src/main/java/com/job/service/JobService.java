package com.job.service;

import java.util.List;
import java.util.Map;

import com.job.bean.Job;
import com.job.bean.JobKind;


public interface JobService {

	/**
	 * 
	 * @return
	 */
	public List<Job> getJobs(Map<String,Object> map);
	
	public List<JobKind> getJobKinds();
	
}
