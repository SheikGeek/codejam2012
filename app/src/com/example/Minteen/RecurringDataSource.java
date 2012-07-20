package com.example.Minteen;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RecurringDataSource {
	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_RID ,
			MySQLiteHelper.COLUMN_RNAME, MySQLiteHelper.COLUMN_AMOUNT,
			MySQLiteHelper.COLUMN_FREQUENCY, MySQLiteHelper.COLUMN_STARTDATE,
			MySQLiteHelper.COLUMN_NEXTDATE };

	public RecurringDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
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

}
