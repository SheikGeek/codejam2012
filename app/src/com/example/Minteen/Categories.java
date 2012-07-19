package com.example.Minteen;

public class Categories {

	String name; 	//name of category
	int activityID1; //id of activity 1
	int activityID2; //id of activity 2
	int activityID3; //id of activity 3
	int categoryID;  //id of category
	
	//accessor and mutator methods for instance variables
	public int getActivityID1(){
		return activityID1;
	}
	public void setActivityID1(int activityID1){
		this.activityID1 = activityID1;
	}
	
	public int getActivityID2(){
		return activityID2;
	}
	public void setActivityID2(int activityID2){
		this.activityID2 = activityID2;
	}
	
	public int getActivityID3(){
		return activityID3;
	}
	public void setActivityID3(int activityID3){
		this.activityID3 = activityID3;
	}
	
	public int getCategoryID(){
		return categoryID;
	}
	public void setCategoryID(int categoryID){
		this.categoryID = categoryID;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
