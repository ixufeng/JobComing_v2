package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.Agreement;

public interface AgreementDao {
	/**
	 * ͨ��Э��������Э���
	 * @param agreement
	 */
	public void insert(Agreement agreement);
	/**
	 * ͨ��Э����ɾ����¼
	 * @param agreementId
	 */
	public void delete(int agreementId);
	/**
	 * ͨ��Э���Ÿ���Э��״̬
	 * @param agreementId
	 * @param status
	 */
	public void update(@Param("agreementId")int agreementId,@Param("status")int status);
	/**
	 * ͨ��Э���ŷ���һ��Э�����
	 * @param agreementId
	 * @return 
	 */
	public Agreement getAgreementById(int agreementId);
	/**
	 * ͨ���û�id��������Э���¼
	 * @param userId
	 * @return
	 */
	public List<Agreement> getAgreeListByUserId(int userId);
	
	/**
	 * 通过用户的id来工作的id来唯一确定某个协议
	 * @return
	 */
	public Agreement getAgreeByUserIdAndJId(@Param("userId") int userId,@Param("jobId") int jobId);
}
