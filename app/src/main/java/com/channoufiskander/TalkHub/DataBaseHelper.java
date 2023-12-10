package com.channoufiskander.TalkHub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String databaseName ="UsersDataBase.db";
    public DataBaseHelper(@Nullable Context context) {
        super(context,"UsersDataBase.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase myDataBase) {

        myDataBase.execSQL("create Table allUsers(email TEXT primary key,password TEXT,fullname TEXT,phoneNumber TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDataBase, int oldVersion, int newVersion) {
        myDataBase.execSQL("drop Table if exists allUsers");
    }
    public boolean insertData(String fullName, String email,String phoneNumber, String password){
        SQLiteDatabase myDataBase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("fullName",fullName);
        contentValues.put("email",email);
        contentValues.put("phoneNumber",phoneNumber);
        contentValues.put("password",password);
        long result = myDataBase.insert("allUsers",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public boolean checkEmail(String email){
        SQLiteDatabase myDataBase=this.getWritableDatabase();
        Cursor cursor= myDataBase.rawQuery("Select * from allUsers where email = ?",new String[]{email});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkEmailPassword(String email,String password){
        SQLiteDatabase myDataBase=this.getWritableDatabase();
        Cursor cursor= myDataBase.rawQuery("Select * from allUsers where email = ? and password = ?",new String[]{email, password});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}
