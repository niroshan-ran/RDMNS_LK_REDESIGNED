package com.uee.rdmns_lk_redesigned;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class SubmitNews extends AppCompatActivity {

    ImageButton btnSubmitNews, btnClearValues;
    EditText txtSubject, txtDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.titleSubmitNews));
        setContentView(R.layout.activity_submit_news);

        txtSubject = findViewById(R.id.editTextNewsSubject);
        txtDescription = findViewById(R.id.editTextDescription);

        btnSubmitNews = findViewById(R.id.btnSubmitNews);
        btnClearValues = findViewById(R.id.btnClearValues);
    }
}