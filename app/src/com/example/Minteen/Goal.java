package com.example.Minteen;

public class Goal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	int goalId;
	int categoryId;
	int activityId;
	double amountSaved;
	boolean isDone;
	
	public int getGoalId() {
		return goalId;
	}
	
	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getActivityId() {
		return activityId;
	}
	
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
	public double getAmountSaved() {
		return amountSaved;
	}
	
	public void setAmountSaved(double amountSaved) {
		this.amountSaved = amountSaved;
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(boolean isDone) {
		this.isDone = isDone; 
	}
	
}
