package com.uee.rdmns_lk_redesigned;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        btnSubmitNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtSubject.getText().toString().trim().equals("") && !txtDescription.getText().toString().trim().equals("")) {
                    txtSubject.setText("");
                    txtDescription.setText("");
                    Toast.makeText(SubmitNews.this, "News Successfully Submitted", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(SubmitNews.this, "Please Enter all the Required Fields", Toast.LENGTH_SHORT).show();


            }
        });

        btnClearValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSubject.setText("");
                txtDescription.setText("");
            }
        });
    }


}