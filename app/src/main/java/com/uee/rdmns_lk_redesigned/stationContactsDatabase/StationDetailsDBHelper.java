package com.uee.rdmns_lk_redesigned.stationContactsDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StationDetailsDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "newStationDB.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StationDetails.TABLE_NAME + " (" +
                    StationDetails.COLUMN_NAME_STATION + " TEXT PRIMARY KEY," +
                    StationDetails.COLUMN_NAME_STATION_SINHALA + " TEXT," +
                    StationDetails.COLUMN_NAME_PHONE_NUMBER + " TEXT," +
                    StationDetails.COLUMN_NAME_FIRST_CLASS_PRICE + " REAL," +
                    StationDetails.COLUMN_NAME_SECOND_CLASS_PRICE + " REAL," +
                    StationDetails.COLUMN_NAME_THIRD_CLASS_PRICE + " REAL);";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + StationDetails.TABLE_NAME + ";";

    public StationDetailsDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(StationDetails.COLUMN_NAME_STATION, "Colombo Fort");
        values.put(StationDetails.COLUMN_NAME_STATION_SINHALA, "කොළඹ කොටුව");
        values.put(StationDetails.COLUMN_NAME_PHONE_NUMBER, "+94 112 421 281");
        values.put(StationDetails.COLUMN_NAME_FIRST_CLASS_PRICE, 0.0);
        values.put(StationDetails.COLUMN_NAME_SECOND_CLASS_PRICE, 0.0);
        values.put(StationDetails.COLUMN_NAME_THIRD_CLASS_PRICE, 0.0);

        db.insert(StationDetails.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(StationDetails.COLUMN_NAME_STATION, "Galle");
        values.put(StationDetails.COLUMN_NAME_STATION_SINHALA, "ගාල්ල");
        values.put(StationDetails.COLUMN_NAME_PHONE_NUMBER, "+94 912 234 945");
        values.put(StationDetails.COLUMN_NAME_FIRST_CLASS_PRICE, 420.00);
        values.put(StationDetails.COLUMN_NAME_SECOND_CLASS_PRICE, 240.00);
        values.put(StationDetails.COLUMN_NAME_THIRD_CLASS_PRICE, 135.00);

        db.insert(StationDetails.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(StationDetails.COLUMN_NAME_STATION, "Kandy");
        values.put(StationDetails.COLUMN_NAME_STATION_SINHALA, "මහනුවර");
        values.put(StationDetails.COLUMN_NAME_PHONE_NUMBER, "+94 812 222 271");
        values.put(StationDetails.COLUMN_NAME_FIRST_CLASS_PRICE, 440.00);
        values.put(StationDetails.COLUMN_NAME_SECOND_CLASS_PRICE, 250.00);
        values.put(StationDetails.COLUMN_NAME_THIRD_CLASS_PRICE, 140.00);

        db.insert(StationDetails.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(StationDetails.COLUMN_NAME_STATION, "Anuradhapura");
        values.put(StationDetails.COLUMN_NAME_STATION_SINHALA, "අනුරාධපුරය");
        values.put(StationDetails.COLUMN_NAME_PHONE_NUMBER, "+94 252 222 271");
        values.put(StationDetails.COLUMN_NAME_FIRST_CLASS_PRICE, 660.00);
        values.put(StationDetails.COLUMN_NAME_SECOND_CLASS_PRICE, 380.00);
        values.put(StationDetails.COLUMN_NAME_THIRD_CLASS_PRICE, 215.00);

        db.insert(StationDetails.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(StationDetails.COLUMN_NAME_STATION, "Badulla");
        values.put(StationDetails.COLUMN_NAME_STATION_SINHALA, "බදුල්ල");
        values.put(StationDetails.COLUMN_NAME_PHONE_NUMBER, "+94 552 222 271");
        values.put(StationDetails.COLUMN_NAME_FIRST_CLASS_PRICE, 860.00);
        values.put(StationDetails.COLUMN_NAME_SECOND_CLASS_PRICE, 490.00);
        values.put(StationDetails.COLUMN_NAME_THIRD_CLASS_PRICE, 275.00);

        db.insert(StationDetails.TABLE_NAME, null, values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
