package com.uee.rdmns_lk_redesigned;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonTrainSchedule = (Button) findViewById(R.id.trainSchedules);
        final Button buttonNewsFeed = (Button) findViewById(R.id.main_news_feed);

        buttonTrainSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TrainSchedule.class);
                startActivity(i);
            }
        });

        buttonNewsFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainNewsFeed.class);
                startActivity(i);
            }
        });
    }


}