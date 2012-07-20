package com.example.Minteen;

public class Recurring {

	 int recurrId;  //ID of recurring deposit
	 String name;	//name of recurring deposit
	 double amount;	//amount of recurring deposit
	 int frequency; //how frequent deposit is made
	 long  startDate;
	 long nextDate;
	 
	 
	/**
	 * @param args
	 */
	 //overloaded constructor
	 public Recurring(int recurrId, String name, int amount, int frequency,
			 long startDate, long nextDate)
	 {
		 this.recurrId = recurrId;
		 this.name = name;
		 this.amount = amount;
		 this.frequency = frequency;
		 this.startDate = startDate;
		 this.nextDate = nextDate;
	 }
	 //accessor and mutator methods for 
     //instance variables
	 public int getrecurrId(){
		 return recurrId;
	 }
	 
	 public void setrecurrId(int recurrId){
		 this.recurrId = recurrId;
	 }
	 
	 public String getName(){
		 return name;
	 }
	 
	 public void setName(String name){
		 this.name = name;
	 }
	 
	 public double getAmount(){
		 return amount;
	 }
	 
	 public void setAmount(double amount){
		 this.amount = amount;
	 }
	 
	 public int getFrequency(){
		 return frequency;
	 }
	 
	 public void setFrequency(int frequency){
		 this.frequency = frequency;
	 }
	 
	 public long getStartDate(){
		 return startDate;
	 }
	 
	 public void setStartDate(long startDate){
		 this.startDate = startDate;
	 }
	 
	 public long getNextDate(){
		 return startDate;
	 }
	 
	 public void setNextDate(long nextDate){
		 this.nextDate = startDate;
	 }
	 
	 private void calculateNextDepositDate(){
		
     }

	 private boolean checkCurrDate() {
		return false;
	 }
	
	 private void createRecurringIncome() {
		
	 }
	
	 private double retrieveRecurringIncome() {
		return 0;
	 }
	 
	 private double[] retrieveRecurringIncomes() {
		double[] recurringIncomes = null;
		return recurringIncomes;
	 }
	
	 private void deleteRecurringIncome() {
		
	 }

	 public static void main(String[] args) {
		
	 }

}
