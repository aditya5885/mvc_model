package com.example.mvc_model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DMS";

    public CDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL("create table Tbdept(dno integer primary key autoincrement,dname text,dloc text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        arg0.execSQL("DROP TABLE IF EXISTS TbDept ");
        onCreate(arg0);

    }

    public void addDept(CDept d) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("dname", d.dname);
            cv.put("dloc", d.dloc);
            db.insert("TbDept", null, cv);
            db.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<CDept> getAllvalues() {
        List<CDept> reclist = new ArrayList<CDept>();
        //select all query

        String selectQuery = "Select * from TbDept";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        //looping through all rows and adding to list
        // here cdept creates a new record it is added to arraylist like one set of record is for socialworker,one for cse,one for library
        //it does not redeclare everytime as looping, but it is stored in memory location
        //example sw in 1000 memoryblock ,cse in 2000 and library in 3000

        if(cursor.moveToFirst()){
            do{
                CDept rec=new CDept();
                rec.id=Integer.parseInt(cursor.getString(0));
                rec.dname=cursor.getString(1);
                rec.dloc=cursor.getString(2);
                reclist.add(rec);
            }while(cursor.moveToNext());
        }
     return reclist;











    }

}








