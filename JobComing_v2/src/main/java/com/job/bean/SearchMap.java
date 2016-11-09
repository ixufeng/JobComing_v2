package com.job.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class SearchMap {

	private String userName;
	private String cityName;
	private String weekTime;
	private String jobKindName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getWeekTime() {
		return weekTime;
	}
	public void setWeekTime(String weekTime) {
		this.weekTime = weekTime;
	}
	public String getKindName() {
		return this.jobKindName;
	}
	public void setKindName(String kindName) {
		this.jobKindName = kindName;
	}
	
	public Map<String,Object> getMap(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(this.userName!=null&&!this.userName.equals("")){
			map.put("userName", "%" + this.userName + "%");
		}else{
			map.put("userName", null);
		}
			
		
		if(this.cityName!=null&&!this.cityName.equals("")){
			map.put("cityName", "%" + this.cityName + "%");
		} 
		if("-1".equals(this.cityName)){
			map.put("cityName", null);
		}
			
		if(this.weekTime!=null&&!this.weekTime.equals("")){
			map.put("weekTime", this.weekTime);
		}
		if("-1".equals(this.weekTime)){
			map.put("weekTime", null);
		}
			
		if(this.jobKindName!=null&&!this.jobKindName.equals("")){
			map.put("kindName","%" + this.jobKindName + "%");
		}
		if("-1".equals(this.jobKindName)){
			map.put("kindName",null);
		}
			
		
		return map;	
	}
	
	
	
}
