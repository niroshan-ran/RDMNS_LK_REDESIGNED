package com.uee.rdmns_lk_redesigned;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu_new extends AppCompatActivity {

    private Button btnMenuComplaint,btnSecurity,btnAboutUs;


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


        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);
        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_new.this,AboutUs.class);
                startActivity(intent);
            }
        });



    }
}