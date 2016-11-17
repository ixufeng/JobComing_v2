package com.job.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.Agreement;
import com.job.dao.AgreementDao;
import com.job.service.AgreementService;

@Service
public class AgreementServiceImpI implements AgreementService {
	@Autowired
	private AgreementDao agreementDao;
	public List<Agreement> getAgreeListByUser(int userId,int beginIndex,int endIndex){
		List<Agreement> list=new ArrayList<Agreement>();
		list=agreementDao.getAgreeListByUserId(userId,beginIndex,endIndex);
		return list;
	}
	@Override
	public boolean insert(Agreement agreement) {
		if(agreement!=null){
			agreementDao.insert(agreement);
			return true;
		}else{
			return false;
		}
		
	}
	@Override
	public boolean delete(int agreementId) {
		if(agreementId!=0){
			agreementDao.delete(agreementId);
			return true;
		}else{
			return false;
		}
		
	}
	@Override
	public boolean update(int userId, int jobId,int status) {
		Agreement agree = getAgreementByUserIdAndJId(userId,jobId);
		if(agree!=null){
			agreementDao.update(agree.getAgreementId(), status);
			return true;
		}else if(status==1){
			//添加这份协议
			Agreement ag = new Agreement();
			ag.setJobId(jobId);
			ag.setStatus(1);
			ag.setUserId(userId);
			insert(ag);
			return true;
		}
		
		return false;
		
	}
	@Override
	public Agreement getAgreementById(int agreementId) {
		if(agreementId!=0){
			Agreement agreement=new Agreement();
			agreement=agreementDao.getAgreementById(agreementId);
			return agreement;
		}else{
			return null;
		}
		
	}
	/**
	 * 查出用户对应某个工作的协议
	 */
	@Override
	public Agreement getAgreementByUserIdAndJId(int userId, int jobId) {
		if(userId<=0||jobId<=0){
			return null;
		}
		
		return  this.agreementDao.getAgreeByUserIdAndJId(userId, jobId);

	}
	
}
