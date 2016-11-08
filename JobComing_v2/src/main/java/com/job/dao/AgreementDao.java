package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Agreement;

public interface AgreementDao {
	/**
	 * 通过协议对象插入协议表
	 * @param agreement
	 */
	public void insert(Agreement agreement);
	/**
	 * 通过协议编号删除记录
	 * @param agreementId
	 */
	public void delete(int agreementId);
	/**
	 * 通过协议编号更改协议状态
	 * @param agreementId
	 * @param status
	 */
	public void update(@Param("agreementId")int agreementId,@Param("status")int status);
	/**
	 * 通过协议编号返回一个协议对象
	 * @param agreementId
	 */
	public void getAgreementById(int agreementId);
	/**
	 * 通过用户id返回所有协议记录
	 * @param userId
	 * @return
	 */
	public List<Agreement> getAgreeListByUserId(int userId);
}
