package com.uee.rdmns_lk_redesigned;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.uee.rdmns_lk_redesigned.ui.liveUpdates.NewLiveUpdatesAndNotificationsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.app_name));
        setContentView(R.layout.activity_main);

        Button buttonLiveUpdates = findViewById(R.id.live_updates);
        buttonLiveUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NewLiveUpdatesAndNotificationsActivity.class);
                startActivity(i);
            }
        });

        Button buttonSubmitNews = findViewById(R.id.submit_news);
        buttonSubmitNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SubmitNews.class);
                startActivity(i);
            }
        });

        Button buttonTrainSchedule = findViewById(R.id.trainSchedules);
        buttonTrainSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TrainSchedule.class);
                startActivity(i);
            }
        });

        Button buttonNewsFeed = findViewById(R.id.main_news_feed);
        buttonNewsFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainNewsFeed.class);
                startActivity(i);
            }
        });

        Button btnLostFound = findViewById(R.id.btnLostFound);
        btnLostFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, lost_foun_main.class);
                startActivity(i);
            }
        });

        Button btnContactStations = findViewById(R.id.btnContactStations);
        btnContactStations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Contact_Stations.class);
                startActivity(intent);
            }
        });


        Button btnMenuComplaint = findViewById(R.id.btnComplaints);
        btnMenuComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Complaint_Submit.class);
                startActivity(intent);
            }
        });

        Button btnSecurity = findViewById(R.id.btnSecurity);
        btnSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Contact_Security.class);
                startActivity(intent);
            }
        });


        Button btnAboutUs = findViewById(R.id.btnAboutUs);
        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent);
            }
        });
    }


}