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
	 * 閫氳繃宸ヤ綔id鏌ユ壘宸ヤ綔
	 * @param jobId
	 * @return
	 */
	public Job getJobById(int jobId);
	/**
	 * 娣诲姞宸ヤ綔
	 * @param job
	 * @return
	 */
	public boolean addJob(Job job);
	/**
	 * 通过用户id返回发布集合
	 * @param userId
	 * @return
	 */
	public List<Job> getJobListByUserId(int userId);
}
