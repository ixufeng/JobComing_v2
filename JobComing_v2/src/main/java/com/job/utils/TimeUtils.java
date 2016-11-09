package com.job.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	/**
	 * 获取当前精确的时间戳,精确到秒
	 */
	public static long getCTimeStamp(){
		
		 return System.currentTimeMillis()/1000;  		 
	}
	
	/**
	 * 时间戳转换为具体时间格式
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
	  * 根据String的时间来返回龙型
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
	  *获取当日凌晨时间
	  * @return
	  */
	 public static  Date getTodayBeginDateTime(){
		 
		 return new Date(getTodayBeginTime()*1000);
	
	 }
	 /**
	  * 获取今天结束时间
	  * @return
	  */
	 public static Date getTodayEndDateTime(){
		 
		 return new Date(getTadayEndTime()*1000);
	 }
	/**
	 * 今天结束时间
	 * @return
	 */
	 public static long getTadayEndTime(){
		 
		 return getTodayBeginTime() + 24*3600;
	 }
	 
	 /**
	  * 格式化时间
	  * @return
	  */
	 public  static String formatDate(Date d,String format){
		 
		 if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
		 SimpleDateFormat sdf = new SimpleDateFormat(format); 
		 return sdf.format(d);
		
	 }
	/**
	 * string 返回date型
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
	 * 时间
	 * @param messageDate
	 * @return
	 */
	public static String getTimeBefore(Date messageDate){
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = "";
		long before = messageDate.getTime();
		long now = nowDate.getTime();
		//差值 秒
		long sub = (now - before)/1000;
		//秒
		if(sub/60<1){
			dateString = "1分钟前";
		}
		//分钟 
		else if(sub/60<60){
			dateString = sub/60+"分钟前";
		}
		//小时
		else if(sub/3600<24){
			dateString = sub/3600+"小时前";
		}
		//天
		else if(sub/3600/24<4){
			dateString = sub/3600/24+"天前";
		}
		//本身时间
		else{
			dateString = sdf.format(messageDate);
		}
		return dateString;
	}
	
}
