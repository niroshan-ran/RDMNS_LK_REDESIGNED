package com.uee.rdmns_lk_redesigned.stationContactsDatabase;

import android.provider.BaseColumns;

public class StationDetails implements BaseColumns {

    public static final String TABLE_NAME = "station";
    public static final String COLUMN_NAME_STATION = "station_name";
    public static final String COLUMN_NAME_STATION_SINHALA = "station_name_sinhala";
    public static final String COLUMN_NAME_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_NAME_FIRST_CLASS_PRICE = "first_class";
    public static final String COLUMN_NAME_SECOND_CLASS_PRICE = "second_class";
    public static final String COLUMN_NAME_THIRD_CLASS_PRICE = "third_class";

    private StationDetails() {
    }


}
