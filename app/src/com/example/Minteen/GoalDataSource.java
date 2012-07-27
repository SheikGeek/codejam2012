package com.example.Minteen;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class GoalDataSource {
	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	private String[] allColumns = { MySQLiteHelper.COLUMN_GID,
			MySQLiteHelper.COLUMN_CATID, MySQLiteHelper.COLUMN_ACTID,
			MySQLiteHelper.COLUMN_AMTSAVED, MySQLiteHelper.COLUMN_AMTTOTAL,
			MySQLiteHelper.COLUMN_ISDONE};

	public GoalDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	

	public Goal createGoal(int cid, int aid, double amtSaved, double amtTotal, int isDone) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_CATID, cid);
		values.put(MySQLiteHelper.COLUMN_ACTID, aid);
		values.put(MySQLiteHelper.COLUMN_AMTSAVED, amtSaved);
		values.put(MySQLiteHelper.COLUMN_AMTTOTAL, amtTotal);
		values.put(MySQLiteHelper.COLUMN_ISDONE, isDone);
		long insertId = database.insert(MySQLiteHelper.TABLE_GOALS, null,
				values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_GOALS,
				allColumns, MySQLiteHelper.COLUMN_GID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Goal newGoal = cursorToGoal(cursor);
		cursor.close();
		return newGoal;
	}
	
	public void updateGoal(int gid, int cid, int aid, double amtSaved, double amtTotal, int isDone) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_CATID, cid);
		values.put(MySQLiteHelper.COLUMN_ACTID, aid);
		values.put(MySQLiteHelper.COLUMN_AMTSAVED, amtSaved);
		values.put(MySQLiteHelper.COLUMN_AMTTOTAL, amtTotal);
		values.put(MySQLiteHelper.COLUMN_ISDONE, isDone);
		database.rawQuery("UPDATE " + MySQLiteHelper.TABLE_GOALS + " SET " +
				MySQLiteHelper.COLUMN_CATID + "=" + cid + ", " +
				MySQLiteHelper.COLUMN_ACTID + "=" + aid + ", " +
				MySQLiteHelper.COLUMN_AMTSAVED + "=" + amtSaved + ", " +
				MySQLiteHelper.COLUMN_AMTTOTAL + "=" + amtTotal + ", " +
				MySQLiteHelper.COLUMN_ISDONE + "=" + isDone +
				" WHERE " + MySQLiteHelper.COLUMN_GID + " = " + gid, null);
	}
	
	public void deleteGoal(Goal goal) {
		int id = goal.getGoalId();
		System.out.println("Goal deleted with id: " + id);
		database.delete(MySQLiteHelper.TABLE_GOALS, MySQLiteHelper.COLUMN_GID
				+ " = " + id, null);
	}
	
	public List<Goal> RetrieveAllGoals() {
		List<Goal> goals = new ArrayList<Goal>();
		
		String q = "SELECT * FROM " + MySQLiteHelper.TABLE_GOALS;
		
		Cursor cursor = database.rawQuery(q, null); 
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Goal goal = cursorToGoal(cursor);
			goals.add(goal);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return goals;
	}
	
	public Goal RetrieveOneGoal(int gid){
		String q = "SELECT * FROM " + MySQLiteHelper.TABLE_GOALS + " WHERE " + MySQLiteHelper.COLUMN_GID +" = " + gid ;
		Cursor cursor = database.rawQuery(q,  null);
		Goal goal = cursorToGoal(cursor);
		
		return goal;
	}

	private Goal cursorToGoal(Cursor cursor) {
		Goal goal = new Goal();
		goal.setGoalId(cursor.getInt(0));
		goal.setCategoryId(cursor.getInt(1));
		goal.setActivityId(cursor.getInt(2));
		goal.setAmountSaved(cursor.getDouble(0));
		goal.setAmountTotal(cursor.getDouble(1));
		goal.setIsDone(cursor.getInt(3));
		return goal;
	}
	
	
}
