package com.example.Minteen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {
	public static final String TABLE_ACTIVITIES = "activities";
	public static final String COLUMN_AID = "_aid";
	public static final String COLUMN_ANAME = "name";
	public static final String COLUMN_PRICE = "price";
	
	public static final String TABLE_CATEGORIES = "categories";
	public static final String COLUMN_CID = "_cid";
	public static final String COLUMN_CNAME = "name";
	public static final String COLUMN_ACTID1 = "activity1id";
	public static final String COLUMN_ACTID2 = "activity2id";
	public static final String COLUMN_ACTID3 = "activity3id";
	
	public static final String TABLE_GOALS = "goals";
	public static final String COLUMN_GID = "_gid";
	public static final String COLUMN_CATID = "_gcategoryid";
	public static final String COLUMN_ACTID = "_gactivityid";
	public static final String COLUMN_AMTSAVED = "amounttsaved";
	public static final String COLUMN_AMTTOTAL = "amounttotal";
	public static final String COLUMN_ISDONE = "isdone";
	
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
			COLUMN_AMTSAVED +"double not null" +
			COLUMN_AMTTOTAL + " double not null, " +
			COLUMN_ISDONE + " int not null, " +
			"FOREIGN KEY (" + COLUMN_CATID + ") REFERENCES " + TABLE_GOALS + "(" + COLUMN_GID + ")" +
			"FOREIGN KEY (" + COLUMN_ACTID + ") REFERENCES " + TABLE_ACTIVITIES + "(" + COLUMN_AID + ") );" +
			
			"CREATE TABLE " + TABLE_RECURRING + "(" +
			COLUMN_RID + " integer primary key autoincrement, " + 
			COLUMN_RNAME + " text not null, " +
			COLUMN_AMOUNT + " double not null, " +
			COLUMN_FREQUENCY + " integer not null, " +
			COLUMN_STARTDATE + " timestamp not null, " +
			COLUMN_NEXTDATE + " timestamp not null );";
	
 private SQLiteHelper sqLiteHelper;
 private SQLiteDatabase sqLiteDatabase;

 private Context context;
 
 public SQLiteAdapter(Context c){
  context = c;
 }
 
 public SQLiteAdapter openToRead() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context);
  sqLiteDatabase = sqLiteHelper.getReadableDatabase();
  return this; 
 }
 
 public SQLiteAdapter openToWrite() throws android.database.SQLException {
  sqLiteHelper = new SQLiteHelper(context);
  sqLiteDatabase = sqLiteHelper.getWritableDatabase();
  return this; 
 }
 
 public void close(){
  sqLiteHelper.close();
 }
 
// public long insert(String content){
//  
//  ContentValues contentValues = new ContentValues();
//  contentValues.put(KEY_CONTENT, content);
//  return sqLiteDatabase.insert(DATABASE_TABLE, null, contentValues);
// }
// 
// public int deleteAll(){
//  return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
// }
// 
// public String queueAll(){
//  String[] columns = new String[]{KEY_CONTENT};
//  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
//    null, null, null, null, null);
//  String result = "";
//  
//  int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
//  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
//   result = result + cursor.getString(index_CONTENT) + "\n";
//  }
// 
//  return result;
// }
 
 public class SQLiteHelper extends SQLiteOpenHelper {

  public SQLiteHelper(Context context) {
   super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
   // TODO Auto-generated method stub
   db.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   // TODO Auto-generated method stub

  }

 }
 
}
