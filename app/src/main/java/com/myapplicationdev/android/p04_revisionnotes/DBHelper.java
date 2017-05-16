package com.myapplicationdev.android.p04_revisionnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

	//TODO Define the Database properties
	private static final String DATABASE_NAME = "notes.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NOTE = "note_table";
	public static final String COL_1 = "ID";
	public static final String COL_2 = "NOTECONTENT";
	public static final String COL_3 = "STARS";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//.execSQL() executes whatever query u pass inside the method arg.
		//prepare create table query
		db.execSQL("CREATE TABLE " + TABLE_NOTE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOTECONTENT TEXT, STARS INTEGER);");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
		onCreate(db);
	}

	public void insertNote(String noteContent, int stars) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(COL_2, noteContent);
		contentValues.put(COL_3, stars);
		long result = db.insert(TABLE_NOTE, null, contentValues);
	}

	public ArrayList<Note> getAllNotes() {
		ArrayList<Note> notes = new ArrayList<>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from note_table", null);
		// moveToFirst() moves to first row
		if (cursor.moveToFirst()) {
			// Loop while moveToNext() points to next row
			//  and returns true; moveToNext() returns false
			//  when no more next row to move to
			do {
				Integer id = Integer.parseInt(cursor.getString(0));
				String noteContent = cursor.getString(1);
				Integer star = Integer.parseInt(cursor.getString(2));
				notes.add(new Note(id, noteContent, star));
			} while (cursor.moveToNext());
		}
		// Close connection
		cursor.close();
		db.close();

		return notes;

	}

    public ArrayList<String> getNoteContent() {
        //TODO return records in Strings

		// Create an ArrayList that holds String objects
        ArrayList<String> notes = new ArrayList<String>();
        // Select all the notes' content
        String selectQuery = "";

        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);
        // moveToFirst() moves to first row
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row and returns true;
            // moveToNext() returns false when no more next row to move to
            do {


            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return notes;
    }
}
