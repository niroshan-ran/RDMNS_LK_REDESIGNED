package com.uee.rdmns_lk_redesigned;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uee.rdmns_lk_redesigned.stationContactsDatabase.StationDetails;
import com.uee.rdmns_lk_redesigned.stationContactsDatabase.StationDetailsDBHelper;
import com.uee.rdmns_lk_redesigned.stationContactsDatabase.StationModel;

import java.util.ArrayList;
import java.util.List;

public class Contact_Stations extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    Spinner stationList;

    String[] stationListNames;

    List<StationModel> stationObjects;

    EditText stationPhoneNumber;

    TextView stationSinhala, station, firstClass, secondClass, thirdClass;

    ImageButton callStation, shareStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__stations);

        stationList = findViewById(R.id.stationList);
        stationSinhala = findViewById(R.id.textViewStationSinhala);
        station = findViewById(R.id.textViewStation);
        firstClass = findViewById(R.id.textViewFirstClassPrice);
        secondClass = findViewById(R.id.textViewSecondClassPrice);
        thirdClass = findViewById(R.id.textViewThirdClassPrice);

        callStation = findViewById(R.id.callStation);
        shareStation = findViewById(R.id.shareStationNumber);

        stationPhoneNumber = findViewById(R.id.stationPhoneNumber);

        stationList.setOnItemSelectedListener(this);

        StationDetailsDBHelper helper = new StationDetailsDBHelper(this);

        insertData(helper);

        stationObjects = loadData(helper);

        stationListNames = new String[stationObjects.size() + 1];

        stationListNames[0] = "[Select Station]";

        int i = 1;

        for (StationModel obj : stationObjects) {

            stationListNames[i] = obj.getStationName().concat(" - ").concat(obj.getStationNameSinhala());

            i++;
        }


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, stationListNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        stationList.setAdapter(aa);

        callStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = stationPhoneNumber.getText().toString();

                if (!phone.equals("")) {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                } else {
                    Toast.makeText(Contact_Stations.this, "Please Select a Railway Station", Toast.LENGTH_LONG).show();
                }


            }
        });

        shareStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String shareBody = stationPhoneNumber.getText().toString();

                if (!shareBody.equals("")) {
                    /*Create an ACTION_SEND Intent*/
                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    /*This will be the actual content you wish you share.*/
                    /*The type of the content is text, obviously.*/
                    intent.setType("text/plain");
                    /*Applying information Subject and Body.*/
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    /*Fire!*/
                    startActivity(Intent.createChooser(intent, "Share Phone Number"));
                } else {
                    Toast.makeText(Contact_Stations.this, "Please Select a Railway Station", Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position > 0) {

            StationModel obj = stationObjects.get(position - 1);

            stationPhoneNumber.setText(obj.getPhoneNumber());
            stationSinhala.setText(obj.getStationNameSinhala().concat(" දුම්රිය ස්ථානය"));
            station.setText(obj.getStationName().concat(" Railway Station"));
            firstClass.setText(String.valueOf(obj.getFirstClassPrice()));
            secondClass.setText(String.valueOf(obj.getSecondClassPrice()));
            thirdClass.setText(String.valueOf(obj.getThirdClassPrice()));
        } else {
            stationPhoneNumber.setText("");
            stationSinhala.setText("");
            station.setText("");
            firstClass.setText("0.00");
            secondClass.setText("0.00");
            thirdClass.setText("0.00");
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);

    }

    public void insertData(StationDetailsDBHelper helper) {

        SQLiteDatabase db = helper.getWritableDatabase();

        helper.insertData(db);
    }


    public List<StationModel> loadData(StationDetailsDBHelper helper) {

        SQLiteDatabase db = helper.getReadableDatabase();

        String sortOrder =
                StationDetails.COLUMN_NAME_STATION;

        Cursor cursor = db.query(
                StationDetails.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List<StationModel> stationObjects = new ArrayList<>();

        while (cursor.moveToNext()) {

            StationModel obj = new StationModel();

            obj.setStationName(cursor.getString(cursor.getColumnIndexOrThrow(StationDetails.COLUMN_NAME_STATION)));
            obj.setStationNameSinhala(cursor.getString(cursor.getColumnIndexOrThrow(StationDetails.COLUMN_NAME_STATION_SINHALA)));
            obj.setPhoneNumber(cursor.getString(cursor.getColumnIndexOrThrow(StationDetails.COLUMN_NAME_PHONE_NUMBER)));
            obj.setFirstClassPrice(cursor.getDouble(cursor.getColumnIndexOrThrow(StationDetails.COLUMN_NAME_FIRST_CLASS_PRICE)));
            obj.setSecondClassPrice(cursor.getDouble(cursor.getColumnIndexOrThrow(StationDetails.COLUMN_NAME_SECOND_CLASS_PRICE)));
            obj.setThirdClassPrice(cursor.getDouble(cursor.getColumnIndexOrThrow(StationDetails.COLUMN_NAME_THIRD_CLASS_PRICE)));

            stationObjects.add(obj);
        }
        cursor.close();

        return stationObjects;
    }
}