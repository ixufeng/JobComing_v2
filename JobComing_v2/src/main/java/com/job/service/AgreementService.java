package com.job.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Agreement;

public interface AgreementService {
	public boolean insert(Agreement agreement);
	/**
	 * ͨ��Э����ɾ����¼
	 * @param agreementId
	 */
	public boolean delete(int agreementId);
	/**
	 * ͨ��Э���Ÿ���Э��״̬
	 * @param agreementId
	 * @param status
	 */
	public boolean update(@Param("agreementId")int agreementId,@Param("status")int status);
	/**
	 * ͨ��Э���ŷ���һ��Э�����
	 * @param agreementId
	 */
	public Agreement getAgreementById(int agreementId);
	/**
	 * ͨ���û�id��������Э���¼
	 * @param userId
	 * @return
	 */
	public List<Agreement> getAgreeListByUser(int userId);
	
}
