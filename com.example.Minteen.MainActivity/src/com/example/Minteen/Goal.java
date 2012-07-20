package com.example.Minteen;
//package com.example.Minteen.Activity; 

public class Goal extends Activity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	 public int goalId;
	 public int categoryId;
	 public int activityId;
	 public double amountSaved;
	 public boolean isDone;

	public Goal(int goalId, int categoryId, double amountSaved, boolean isDone, String activityName, double activityPrice, int activityId){
		super(activityId, activityName, activityPrice);
		this.goalId = goalId;
		this.categoryId = categoryId;
		//this.activityId = activityId;
		this.amountSaved = amountSaved;
		this.isDone = isDone;
	}
	
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
	
//	public int getActivityId() {
//		return activityId;
//	}
//	
//	public void setActivityId(int activityId) {
//		this.activityId = activityId;
//	}
	
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
