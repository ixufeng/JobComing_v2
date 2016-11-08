package com.job.dao;

import java.util.List;

import com.job.bean.Evaluate;

public interface EvaluateDao {
	/**
	 * 根据评价对象插入表
	 * @param evaluate
	 */
	public void insert(Evaluate evaluate);
	/**
	 * 根据评价编号删除评价
	 * @param evaluateId
	 */
	public void delete(int evaluateId);
	/**
	 * 通过用户id返回所有的评价
	 * @param userId
	 * @return
	 */
	public List<Evaluate> getEvaluateByUserId(int userId);
	/**
	 * 通过发布工作人的id返回所有对他的评价
	 * @param userId
	 * @return
	 */
	public List<Evaluate>getEvaluateByJobUserId(int userId);
}
