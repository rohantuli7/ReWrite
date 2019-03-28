package com.example.rt.pl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper3 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "userDetails.db";
    public static final String TABLE_NAME = "education_details";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "Course";
    public static final String COL_3 = "Year";
    public static final String COL_4 = "Specialization";
    public static final String COL_5 = "University";
    public static final String COL_6 = "CGPA";
    public static final String COL_7 = "tenth_Board";
    public static final String COL_8 = "tenth_Marks";
    public static final String COL_9 = "twelth_Board";
    public static final String COL_10 = "twelth_Marks";
    public static final String COL_11 = "Language_1";
    public static final String COL_12 = "Language_2";
    public static final String COL_13 = "Language_3";
    public static final String COL_14 = "Language_4";
    public static final String COL_15 = "Language_5";


    SQLiteDatabase db;


    public DatabaseHelper3(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Course TEXT, Year TEXT, Specialization TEXT, University TEXT, CGPA TEXT, tenth_Board TEXT, tenth_Marks TEXT, twelth_Board TEXT,  twelth_Marks TEXT, Language_1 TEXT, Language_2 TEXT, Language_3 TEXT, Language_4 TEXT, Language_5 TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String c, String y, String s, String u, String cgpa, String tenb, String tenm, String twelveb, String twelvem, String c1, String c2, String c3, String c4, String c5){

        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,c);
        contentValues.put(COL_3,y);
        contentValues.put(COL_4,s);
        contentValues.put(COL_5,u);
        contentValues.put(COL_6,cgpa);
        contentValues.put(COL_7,tenb);
        contentValues.put(COL_8,tenm);
        contentValues.put(COL_9,twelveb);
        contentValues.put(COL_10,twelvem);
        contentValues.put(COL_11,c1);
        contentValues.put(COL_12,c2);
        contentValues.put(COL_13,c3);
        contentValues.put(COL_14,c4);
        contentValues.put(COL_15,c5);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1 ){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String c, String y, String s, String u, String cgpa, String tenb, String tenm, String twelveb, String twelvem, String c1, String c2, String c3, String c4, String c5){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,c);
        contentValues.put(COL_3,y);
        contentValues.put(COL_4,s);
        contentValues.put(COL_5,u);
        contentValues.put(COL_6,cgpa);
        contentValues.put(COL_7,tenb);
        contentValues.put(COL_8,tenm);
        contentValues.put(COL_9,twelveb);
        contentValues.put(COL_10,twelvem);
        contentValues.put(COL_11,c1);
        contentValues.put(COL_12,c2);
        contentValues.put(COL_13,c3);
        contentValues.put(COL_14,c4);
        contentValues.put(COL_15,c5);
        db.update(TABLE_NAME, contentValues,"ID = ?", new String[] {id} );
        return true;
    }


}
