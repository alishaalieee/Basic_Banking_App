package com.example.bankingapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(9264909932,'Alisha',7000.00,'alisha25@gamil.com','XXXXXXXXXXXX6421','SBP08876543')");
        db.execSQL("insert into user_table values(8542136521,'Prisha',7000.00,'guggu@gmail.com','XXXXXXXXXXXX6528','SBI98765432')");
        db.execSQL("insert into user_table values(7452301259,'Vidi kono',7000.00,'akono@gmail.com','XXXXXXXXXXXX7451','SBP87654321')");
        db.execSQL("insert into user_table values(9471203215,'Kavita dara',7000.00,'dara@gmail.com','XXXXXXXXXXXX5201','PIB76543210')");
        db.execSQL("insert into user_table values(7854120214,'Amit sinha ',7000.00,'amit@gmail.com','XXXXXXXXXXXX7433','BOI65432109')");
        db.execSQL("insert into user_table values(9784514747,'Suchi Tulika',7000.00,'suchi@gmail.com','XXXXXXXXXXXX5214','UBOI54321098')");
        db.execSQL("insert into user_table values(6301547854,'Ashmit singh',7000.00,'ashley@gmail.com','XXXXXXXXXXXX3021','SIB43210987')");
        db.execSQL("insert into user_table values(8520147963,'Kumar Aryan ',7000.00,'laddu@gmail.com','XXXXXXXXXXXX5734','ICIC32909876')");
        db.execSQL("insert into user_table values(9517538246,'Sarthak Dubey',7000.00,'harsh@gmail.com','XXXXXXXXXXXX3496','CORP21298765')");
        db.execSQL("insert into user_table values(7458967430,'saurav kumar',7000.00,'siddu@gmail.com','XXXXXXXXXXXX4593','IND10997654')");
        db.execSQL("insert into user_table values(7438967430,'Henal keshwani',7000.00,'henal@gmail.com','XXXXXXXXXXXX4893','CITI10797654')");
        db.execSQL("insert into user_table values(7458167430,'Adarsh Nishen',7000.00,'nishen@gmail.com','XXXXXXXXXXXX4533','BOB10897654')");
        db.execSQL("insert into user_table values(7458997430,'Reyansh Kumar',7000.00,'reyo@gmail.com','XXXXXXXXXXXX1593','ISR10697654')");
        db.execSQL("insert into user_table values(7458967480,'Rajesh Sharma',7000.00,'rajesh@gmail.com','XXXXXXXXXXXX4693','USA10297654')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
