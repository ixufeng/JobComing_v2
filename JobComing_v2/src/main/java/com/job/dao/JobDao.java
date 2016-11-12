package com.job.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Job;

public interface JobDao {
	/**
	 * 通过jobid来查询工作
	 * @param jobId
	 * @return
	 */
	public Job getJobByJobId(@Param("jobId") int jobId);
	
	/**
	 * 通过用户的id来查找兼职
	 * @param userId
	 * @return
	 */
	public List<Job> getJobsByUserId(@Param("userId") int userId,@Param("beginIndex")int beginIndex,@Param("endIndex")int endIndex);
	
	/**
	 * 综合查找兼职  工作地点 , 发布人姓名 ，工作种类
	 * @param map
	 * @return
	 */
	public List<Job> searchJobs(Map<String,Object> map);
	
	/**
	 * 新增兼职
	 * @param job
	 */
	public void addJob(Job job);
	
	/**
	 * 删除兼职
	 * @param jobId
	 */
	public void delJob(@Param("jobId") int jobId);
	
	
}
