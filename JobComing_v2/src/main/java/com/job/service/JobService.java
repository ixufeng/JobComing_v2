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
	/**
	 * 通过工作id查找工作
	 * @param jobId
	 * @return
	 */
	public Job getJobById(int jobId);
	/**
	 * 添加工作
	 * @param job
	 * @return
	 */
	public boolean addJob(Job job);
	
	public Job getJobById(int id); 
}
