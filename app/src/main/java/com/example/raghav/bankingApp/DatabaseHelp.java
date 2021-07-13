package com.example.raghav.bankingApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelp extends SQLiteOpenHelper {
    private final String TABLE_NAME = "user_table";
    private final String TABLE_NAME1 = "transfers_table";

    public DatabaseHelp(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 + " (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(7531469857,'vikas',5902.21,'vikas12@gmail.com','XXXXXXXXXXXX5547','AAA63177825')");
        db.execSQL("insert into user_table values(4561759832,'khushi',2821.37,'khushi89@gmail.com','XXXXXXXXXXXX1320','LTE77774135')");
        db.execSQL("insert into user_table values(5789146378,'shruti',2511.45,'shruti00@gmail.com','XXXXXXXXXXXX8716','IOP58740361')");
        db.execSQL("insert into user_table values(8597428757,'rajat',5666.51,'rajat54@gmail.com','XXXXXXXXXXXX4597','LLN42879630')");
        db.execSQL("insert into user_table values(4781421482,'shivam',6457.50,'shivam99@gmail.com','XXXXXXXXXXXX2674','HAS17958403')");
        db.execSQL("insert into user_table values(4124448217,'priya',5698.62,'priya33@gmail.com','XXXXXXXXXXXX3719','PQD45712308')");
        db.execSQL("insert into user_table values(2354458722,'sagar',9874.23,'sagar76@gmail.com','XXXXXXXXXXXX7713','MXS24046491')");
        db.execSQL("insert into user_table values(6597427551,'shiv',6198.77,'shiv38@gmail.com','XXXXXXXXXXXX1508','NQA95962727')");
        db.execSQL("insert into user_table values(5028703572,'nancy',4987.38,'nancy66@gmail.com','XXXXXXXXXXXX4056','KSR27206539')");
        db.execSQL("insert into user_table values(2220147301,'sunil',7210.56,'sunil39@gmail.com','XXXXXXXXXXXX8679','FSC9815641')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " + phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " + phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " + phonenumber);
    }

    public Cursor readtransferdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date, String from_name, String to_name, String amount, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        return result != -1;
    }
}
