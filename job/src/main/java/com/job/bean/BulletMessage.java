package com.job.bean;

/**
 * 
 * @author xufeng
 *
 */
public class BulletMessage {


	
	private String info; //
	//private String img;
	private boolean close = true;
	private String color = "#3f8";
	private String old_ie_color="#000";
	
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public boolean isClose() {
		return close;
	}
	public void setClose(boolean close) {
		this.close = close;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOld_ie_color() {
		return old_ie_color;
	}
	public void setOld_ie_color(String old_ie_color) {
		this.old_ie_color = old_ie_color;
	}
	@Override
	public String toString() {
		return "{info:'" + info + "', close:'" + close + "', color:'" + color
				+ "', old_ie_color:'" + old_ie_color + "'}";
	}
	
	
}
