package com.example.Minteen;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CategoriesDataSource {
	// Database fields
		private SQLiteDatabase database;
		private MySQLiteHelper dbHelper;
		private String[] allColumns = { MySQLiteHelper.COLUMN_CID,
				MySQLiteHelper.COLUMN_CNAME, MySQLiteHelper.COLUMN_ACTID1,
				MySQLiteHelper.COLUMN_ACTID2, MySQLiteHelper.COLUMN_ACTID3 };

		public CategoriesDataSource(Context context) {
			dbHelper = new MySQLiteHelper(context);
		}

		public void open() throws SQLException {
			database = dbHelper.getWritableDatabase();
		}

		public void close() {
			dbHelper.close();
		}
}
