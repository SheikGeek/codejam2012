package com.example.Minteen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	public static final String TABLE_ACTIVITIES = "activities";
	public static final String COLUMN_AID = "_aid";
	public static final String COLUMN_ANAME = "name";
	public static final String COLUMN_PRICE = "price";
	
	public static final String TABLE_CATEGORIES = "categories";
	public static final String COLUMN_CID = "_cid";
	public static final String COLUMN_CNAME = "name";
	public static final String COLUMN_ACTID1 = "act1id";
	public static final String COLUMN_ACTID2 = "act2id";
	public static final String COLUMN_ACTID3 = "act3id";
	
	public static final String TABLE_GOALS = "goals";
	public static final String COLUMN_GID = "_gid";
	public static final String COLUMN_CATID = "_gcatid";
	public static final String COLUMN_ACTID = "_gactid";
	public static final String COLUMN_AMTSAVED = "amtsaved";
	public static final String COLUMN_AMTTOTAL = "amttotal";
	
	public static final String TABLE_RECURRING = "recurring";
	public static final String COLUMN_RID = "_rid";
	public static final String COLUMN_RNAME = "rname";
	public static final String COLUMN_AMOUNT = "amount";
	public static final String COLUMN_FREQUENCY = "frequency";
	public static final String COLUMN_STARTDATE = "startdate";
	public static final String COLUMN_NEXTDATE = "nextdate";

	private static final String DATABASE_NAME = "doughgo.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_ACTIVITIES + "(" +
			COLUMN_AID + " integer primary key autoincrement, " + 
			COLUMN_ANAME + " text not null, " +
			COLUMN_PRICE + " double not null );" +
			
			"CREATE TABLE " + TABLE_CATEGORIES + "(" +
			COLUMN_CID + " integer primary key autoincrement, " + 
			COLUMN_CNAME + " text not null, " +
			COLUMN_ACTID1 + " integer not null, " +
			COLUMN_ACTID2 + " integer not null, " +
			COLUMN_ACTID3 + " integer not null, " +
			"FOREIGN KEY (" + COLUMN_ACTID1 + ") REFERENCES " + TABLE_ACTIVITIES + "(" + COLUMN_AID + ")" +
			"FOREIGN KEY (" + COLUMN_ACTID2 + ") REFERENCES " + TABLE_ACTIVITIES + "(" + COLUMN_AID + ")" +
			"FOREIGN KEY (" + COLUMN_ACTID3 + ") REFERENCES " + TABLE_ACTIVITIES + "(" + COLUMN_AID + ") );" +
			
			"CREATE TABLE " + TABLE_GOALS + "(" +
			COLUMN_GID + " integer primary key autoincrement, " + 
			COLUMN_CATID + " integer not null, " +
			COLUMN_ACTID + " integer not null, " +
			COLUMN_AMTTOTAL + " double not null, " +
			"FOREIGN KEY (" + COLUMN_CATID + ") REFERENCES " + TABLE_GOALS + "(" + COLUMN_GID + ")" +
			"FOREIGN KEY (" + COLUMN_ACTID + ") REFERENCES " + TABLE_ACTIVITIES + "(" + COLUMN_AID + ") );" +
			
			"CREATE TABLE " + TABLE_RECURRING + "(" +
			COLUMN_RID + " integer primary key autoincrement, " + 
			COLUMN_RNAME + " text not null, " +
			COLUMN_AMOUNT + " double not null, " +
			COLUMN_FREQUENCY + " integer not null, " +
			COLUMN_STARTDATE + " timestamp not null, " +
			COLUMN_NEXTDATE + " timestamp not null );";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIVITIES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GOALS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECURRING);
		
		onCreate(db);
	}
}
