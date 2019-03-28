package com.example.rt.pl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper1 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "userAddress.db";
    public static final String TABLE_NAME = "user_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "first_name";
    public static final String COL_3 = "last_name";
    public static final String COL_4 = "flat_no";
    public static final String COL_5 = "building_name";
    public static final String COL_6 = "street";
    public static final String COL_7 = "locality";
    public static final String COL_8 = "city";
    public static final String COL_9 = "pincode";
    public static final String COL_10 = "state";
    public static final String COL_11 = "mobile_no";

//    public static final String COL_12 = "Course";
//    public static final String COL_13 = "Year";
//    public static final String COL_14 = "Specialization";
//    public static final String COL_15 = "University";
//    public static final String COL_16 = "CGPA";
//    public static final String COL_17 = "tenth_Board";
//    public static final String COL_18 = "tenth_Marks";
//    public static final String COL_19 = "twelth_Board";
//    public static final String COL_20 = "twelth_Marks";
//    public static final String COL_21 = "Language_1";
//    public static final String COL_22 = "Language_2";
//    public static final String COL_23 = "Language_3";
//    public static final String COL_24 = "Language_4";
//    public static final String COL_25 = "Language_5";
//
//
//
//    public static final String COL_26 = "Skill_1";
//    public static final String COL_27 = "Skill_2";
//    public static final String COL_28 = "Skill_3";
//    public static final String COL_29 = "Skill_4";
//    public static final String COL_30 = "Skill_5";
//    public static final String COL_31 = "Hobby_1";
//    public static final String COL_32 = "Hobby_2";
//    public static final String COL_33 = "Hobby_3";
//    public static final String COL_34 = "Hobby_4";
//    public static final String COL_35 = "Hobby_5";
//    public static final String COL_36 = "Hobby_6";
//    public static final String COL_37 = "Hobby_7";
//    public static final String COL_38 = "Hobby_8";
//    public static final String COL_39 = "Hobby_9";
//    public static final String COL_40 = "Hobby_10";
//    public static final String COL_41 = "Project_1";
//    public static final String COL_42 = "Project_2";
//    public static final String COL_43 = "Project_3";

    //public static String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35,s36,s37,s38,s39,s40,s41,s42,s43;

    SQLiteDatabase db;









    public DatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, first_name TEXT, last_name TEXT, flat_no INTEGER, building_name TEXT, street TEXT, locality TEXT, city TEXT, pincode INTERGER, state TEXT, mobile_no INTEGER)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData1(String fname, String lname, String fno, String bn, String st, String loc, String c, String pcode, String s, String mno){
        //db.execSQL("delete from "+ TABLE_NAME);
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,fname);
        contentValues.put(COL_3,lname);
        contentValues.put(COL_4,fno);
        contentValues.put(COL_5,bn);
        contentValues.put(COL_6,st);
        contentValues.put(COL_7,loc);
        contentValues.put(COL_8,c);
        contentValues.put(COL_9,pcode);
        contentValues.put(COL_10,s);
        contentValues.put(COL_11,mno);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if (result == -1 )
            return false;
        else
            return true;

    }



//    public void insertData2(String c, String y, String s, String u, String cgpa, String tenb, String tenm, String twelveb, String twelvem, String c1, String c2, String c3, String c4, String c5){
//        s11 = c;
//        s12 = y;
//        s13 = s;
//        s14 = u;
//        s15 = cgpa;
//        s16 = tenb;
//        s17 = tenm;
//        s18 = twelveb;
//        s19 = twelvem;
//        s20 = c1;
//        s21 = c2;
//        s22 = c3;
//        s23 = c4;
//        s24 = c5;
//
//
//
//        db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_12,c);
//        contentValues.put(COL_13,y);
//        contentValues.put(COL_14,s);
//        contentValues.put(COL_15,u);
//        contentValues.put(COL_16,cgpa);
//        contentValues.put(COL_17,tenb);
//        contentValues.put(COL_18,tenm);
//        contentValues.put(COL_19,twelveb);
//        contentValues.put(COL_20,twelvem);
//        contentValues.put(COL_21,c1);
//        contentValues.put(COL_22,c2);
//        contentValues.put(COL_23,c3);
//        contentValues.put(COL_24,c4);
//        contentValues.put(COL_25,c5);
//        long result = db.insert(TABLE_NAME,null, contentValues);
//        if (result == -1 )
//            return false;
//        else
//            return true;
//
//    }
//
//    public boolean insertFinalData(){
//        db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2,s1);
//        contentValues.put(COL_3,s2);
//        contentValues.put(COL_4,s3);
//        contentValues.put(COL_5,s4);
//        contentValues.put(COL_6,s5);
//        contentValues.put(COL_7,s6);
//        contentValues.put(COL_8,s7);
//        contentValues.put(COL_9,s8);
//        contentValues.put(COL_10,s9);
//        contentValues.put(COL_11,s10);
//        contentValues.put(COL_12,s11);
//        contentValues.put(COL_13,s12);
//        contentValues.put(COL_14,s13);
//        contentValues.put(COL_15,s14);
//        contentValues.put(COL_16,s15);
//        contentValues.put(COL_17,s16);
//        contentValues.put(COL_18,s17);
//        contentValues.put(COL_19,s18);
//        contentValues.put(COL_20,s19);
//        contentValues.put(COL_21,s20);
//        contentValues.put(COL_22,s21);
//        contentValues.put(COL_23,s22);
//        contentValues.put(COL_24,s23);
//        contentValues.put(COL_25,s24);
//
//        long result = db.insert(TABLE_NAME,null, contentValues);
//        if (result == -1 )
//            return false;
//        else
//            return true;
//
//    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }


    public boolean updateData(String id, String fname, String lname, String fno, String bn, String st, String loc, String c, String pcode, String s, String mno){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,fname);
        contentValues.put(COL_3,lname);
        contentValues.put(COL_4,fno);
        contentValues.put(COL_5,bn);
        contentValues.put(COL_6,st);
        contentValues.put(COL_7,loc);
        contentValues.put(COL_8,c);
        contentValues.put(COL_9,pcode);
        contentValues.put(COL_10,s);
        contentValues.put(COL_11,mno);
        //long result = db.insert(TABLE_NAME,null, contentValues);
        db.update(TABLE_NAME, contentValues,"ID = ?", new String[] {id} );
        return true;

    }



}
