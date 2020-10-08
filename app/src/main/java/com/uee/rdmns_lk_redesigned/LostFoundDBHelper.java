package com.uee.rdmns_lk_redesigned;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class LostFoundDBHelper extends SQLiteOpenHelper {

    public LostFoundDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void queryData(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    //insert data of lost
    public void insertLost(String title,String details){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "INSERT INTO LOST VALUES(null,?, ?)";

        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,title);
        statement.bindString(2,details);

        statement.executeInsert();
    }

    public Cursor getLost(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    //insert data of found
    public void insertFound(String title,String details){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "INSERT INTO FOUND VALUES(null,?, ?)";

        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,title);
        statement.bindString(2,details);

        statement.executeInsert();
    }

    public Cursor getFound(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }
}
