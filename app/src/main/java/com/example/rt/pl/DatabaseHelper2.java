package com.example.rt.pl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "userInterests.db";
    public static final String TABLE_NAME = "user_Skills";


    public static final String COL_1 = "ID";
    public static final String COL_2 = "Skill_1";
    public static final String COL_3 = "Skill_2";
    public static final String COL_4 = "Skill_3";
    public static final String COL_5 = "Skill_4";
    public static final String COL_6 = "Skill_5";
    public static final String COL_7 = "Hobby_1";
    public static final String COL_8 = "Hobby_2";
    public static final String COL_9 = "Hobby_3";
    public static final String COL_10 = "Hobby_4";
    public static final String COL_11 = "Hobby_5";
    public static final String COL_12 = "Hobby_6";
    public static final String COL_13 = "Hobby_7";
    public static final String COL_14 = "Hobby_8";
    public static final String COL_15 = "Hobby_9";
    public static final String COL_16 = "Hobby_10";
    public static final String COL_17 = "Project_1";
    public static final String COL_18 = "Project_2";
    public static final String COL_19 = "Project_3";






    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Skill_1 TEXT, Skill_2 TEXT, Skill_3 TEXT, Skill_4 TEXT, Skill_5 TEXT, Hobby_1 TEXT, Hobby_2 TEXT, Hobby_3 TEXT,  Hobby_4 TEXT, Hobby_5 TEXT, Hobby_6 TEXT, Hobby_7 TEXT, Hobby_8 TEXT, Hobby_9 TEXT, Hobby_10 TEXT, Project_1 TEXT, Project_2 TEXT, Project_3 TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String s1, String s2, String s3, String s4, String s5, String h1, String h2, String h3, String h4, String h5, String h6, String h7, String h8, String h9, String h10, String p1, String p2, String p3){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,s1);
        contentValues.put(COL_3,s2);
        contentValues.put(COL_4,s3);
        contentValues.put(COL_5,s4);
        contentValues.put(COL_6,s5);
        contentValues.put(COL_7,h1);
        contentValues.put(COL_8,h2);
        contentValues.put(COL_9,h3);
        contentValues.put(COL_10,h4);
        contentValues.put(COL_11,h5);
        contentValues.put(COL_12,h6);
        contentValues.put(COL_13,h7);
        contentValues.put(COL_14,h8);
        contentValues.put(COL_15,h9);
        contentValues.put(COL_16,h10);
        contentValues.put(COL_17,p1);
        contentValues.put(COL_18,p2);
        contentValues.put(COL_19,p3);

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

    public boolean updateData(String id,String s1, String s2, String s3, String s4, String s5, String h1, String h2, String h3, String h4, String h5, String h6, String h7, String h8, String h9, String h10, String p1, String p2, String p3) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, s1);
        contentValues.put(COL_3, s2);
        contentValues.put(COL_4, s3);
        contentValues.put(COL_5, s4);
        contentValues.put(COL_6, s5);
        contentValues.put(COL_7, h1);
        contentValues.put(COL_8, h2);
        contentValues.put(COL_9, h3);
        contentValues.put(COL_10, h4);
        contentValues.put(COL_11, h5);
        contentValues.put(COL_12, h6);
        contentValues.put(COL_13, h7);
        contentValues.put(COL_14, h8);
        contentValues.put(COL_15, h9);
        contentValues.put(COL_16, h10);
        contentValues.put(COL_17, p1);
        contentValues.put(COL_18, p2);
        contentValues.put(COL_19, p3);

        db.update(TABLE_NAME, contentValues,"ID = ?", new String[] {id} );
        return true;

    }

}
