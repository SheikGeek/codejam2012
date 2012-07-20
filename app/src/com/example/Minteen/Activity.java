package com.example.Minteen;

public class Activity{

/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub

}
    int activityId;
String activityName; 
double activityPrice;
public Activity(int activityId, String activityName, double activityPrice){
this.activityId = activityId;
this.activityName = activityName;
this.activityPrice = activityPrice;
}
public String getActivityName() {
return activityName;
}
public void setAcitivityName(String activityName) {
this.activityName = activityName;
}
public double getActivityId() {
return activityId;
}
public void setActivityId(int activityId) {
this.activityId = activityId;
}
public double getActivityPrice() {
return activityPrice;
}
public void setActivityPrice(double activityPrice) {
this.activityPrice = activityPrice;
}
}