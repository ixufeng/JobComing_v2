package com.job.bean;

import java.util.Date;

public class Job {

	
	private int jobId;
	private int userId;
	private int jobKindId;
	private Date jobTime;
	private String addrNumber;
	private String detailAddr;
	private Date beginTime;
	private Date endTime;
	private String jobScribe;
	private int isValidate;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getJobKindId() {
		return jobKindId;
	}
	public void setJobKindId(int jobKindId) {
		this.jobKindId = jobKindId;
	}
	public Date getJobTime() {
		return jobTime;
	}
	public void setJobTime(Date jobTime) {
		this.jobTime = jobTime;
	}
	public String getAddrNumber() {
		return addrNumber;
	}
	public void setAddrNumber(String addrNumber) {
		this.addrNumber = addrNumber;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getJobScribe() {
		return jobScribe;
	}
	public void setJobScribe(String jobScribe) {
		this.jobScribe = jobScribe;
	}
	public int getIsValidate() {
		return isValidate;
	}
	public void setIsValidate(int isValidate) {
		this.isValidate = isValidate;
	}
	
	
	
	
	
}
