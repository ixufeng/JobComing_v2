package com.job.bean;

public class RelationShip {

	private int relationshipId;
	private int userIda;  //关注人
	private int userIdb;	//被关注人
	
	
	public int getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}
	public int getUserIda() {
		return userIda;
	}
	public void setUserIda(int userIda) {
		this.userIda = userIda;
	}
	public int getUserIdb() {
		return userIdb;
	}
	public void setUserIdb(int userIdb) {
		this.userIdb = userIdb;
	}
	
	
	
	
}
