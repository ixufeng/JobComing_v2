package com.job.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Agreement;

public interface AgreementService {
	public boolean insert(Agreement agreement);
	/**
	 * 
	 * @param agreementId
	 */
	public boolean delete(int agreementId);
	/**
	 * 
	 * @param agreementId
	 * @param status
	 */
	public boolean update(int userId,int jobId,int status);
	/**
	 * 
	 * @param agreementId
	 */
	public Agreement getAgreementById(int agreementId);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<Agreement> getAgreeListByUser(int userId);
	

	public Agreement getAgreementByUserIdAndJId(int userId ,int jobId);
}
