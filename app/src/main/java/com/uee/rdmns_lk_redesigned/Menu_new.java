package com.uee.rdmns_lk_redesigned;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_new extends AppCompatActivity {

    private Button btnMenuComplaint,btnSecurity,btnStations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_new);

        btnMenuComplaint = (Button) findViewById(R.id.btnSubmitComplaints);
        btnMenuComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_new.this,Complaint_Submit.class);
                startActivity(intent);
            }
        });

        btnSecurity = (Button) findViewById(R.id.btnContactSecurity);
        btnSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_new.this,Contact_Security.class);
                startActivity(intent);
            }
        });

        btnStations = (Button) findViewById(R.id.btnContactsOfStations);
        btnStations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_new.this,Contact_Stations.class);
                startActivity(intent);
            }
        });




    }
}