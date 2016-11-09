package com.job.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Job;

public interface JobDao {
	/**
	 * 返回唯一一个兼职
	 * @param jobId
	 * @return
	 */
	public Job getJobByJobId(@Param("jobId") int jobId);
	
	/**
	 * 返回某个人发布过的兼职
	 * @param userId
	 * @return
	 */
	public List<Job> getJobsByUserId(@Param("userId") int userId);
	
	/**
	 * 可以添加 cityName, jobKindName ,userName三个参数
	 * @param map
	 * @return
	 */
	public List<Job> searchJobs(Map<String,Object> map);
	
	/**
	 * 添加一个工作
	 * @param job
	 */
	public void addJob(Job job);
	
	/**
	 * 删除已经发布的兼职
	 * @param jobId
	 */
	public void delJob(@Param("jobId") int jobId);
	
	
}
