package com.job.dao;

import java.util.List;

import com.job.bean.JobKind;

public interface JobKindDao {
	/**
	 * 返回所有的工作种类
	 * @return
	 */
	public List<JobKind> getAllJobKind();
}
