package com.job.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	/**
	 * 鑾峰彇褰撳墠绮剧‘鐨勬椂闂存埑,绮剧‘鍒扮
	 */
	public static long getCTimeStamp(){
		
		 return System.currentTimeMillis()/1000;  		 
	}
	
	/**
	 * 鏃堕棿鎴宠浆鎹负鍏蜂綋鏃堕棿鏍煎紡
	 * @param seconds
	 * @param format
	 * @return
	 */
	 public static String timeStampDate(long seconds,String format) {  
         
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        
        return sdf.format(new Date(seconds*1000));  
	 } 
	
	 /**
	  * 鏍规嵁String鐨勬椂闂存潵杩斿洖榫欏瀷
	  * @return
	  */
	 public static long timeStampLong(String time,String format){
		 
		try {
			Date dd = new SimpleDateFormat(format).parse(time);
			
			return dd.getTime()/1000;
		} catch (ParseException e) {
			
			return -1;
		}
	 }
	 
	 public static long getTodayBeginTime(){
		 
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.HOUR, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND,0);
		 cal.set(Calendar.MILLISECOND, 0);
		 Date date= cal.getTime();
		 
		 String time = timeStampDate(date.getTime()/1000,"yyyy-MM-dd");
		 
		 long time1 = TimeUtils.timeStampLong(time, "yyyy-MM-dd");
		 return time1;
	 }
	 /**
	  *鑾峰彇褰撴棩鍑屾櫒鏃堕棿
	  * @return
	  */
	 public static  Date getTodayBeginDateTime(){
		 
		 return new Date(getTodayBeginTime()*1000);
	
	 }
	 /**
	  * 鑾峰彇浠婂ぉ缁撴潫鏃堕棿
	  * @return
	  */
	 public static Date getTodayEndDateTime(){
		 
		 return new Date(getTadayEndTime()*1000);
	 }
	/**
	 * 浠婂ぉ缁撴潫鏃堕棿
	 * @return
	 */
	 public static long getTadayEndTime(){
		 
		 return getTodayBeginTime() + 24*3600;
	 }
	 
	 /**
	  * 鏍煎紡鍖栨椂闂�
	  * @return
	  */
	 public  static String formatDate(Date d,String format){
		 
		 if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
		 SimpleDateFormat sdf = new SimpleDateFormat(format); 
		 return sdf.format(d);
		
	 }
	/**
	 * string 杩斿洖date鍨�
	 * @param time
	 * @return
	 */
	public static Date formatDate(String time){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 鏃堕棿
	 * @param messageDate
	 * @return
	 */
	public static String getTimeBefore(Date messageDate){
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = "";
		long before = messageDate.getTime();
		long now = nowDate.getTime();
		//宸�� 绉�
		long sub = (now - before)/1000;
		//绉�
		if(sub/60<1){
			dateString = "1 minute ago";
		}
		//鍒嗛挓 
		else if(sub/60<60){
			dateString = sub/60+" minute ago";
		}
		//灏忔椂
		else if(sub/3600<24){
			dateString = sub/3600+" hour ago";
		}
		//澶�
		else if(sub/3600/24<4){
			dateString = sub/3600/24+" day ago";
		}
		//鏈韩鏃堕棿
		else{
			dateString = sdf.format(messageDate);
		}
		return dateString;
	}
	
}
