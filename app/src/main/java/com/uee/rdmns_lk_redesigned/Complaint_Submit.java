package com.uee.rdmns_lk_redesigned;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Complaint_Submit extends AppCompatActivity {

    private EditText emailAddress, emailSubject, emailComplaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint__submit);

        emailAddress = findViewById(R.id.emailAddress);
        emailSubject = findViewById(R.id.emailSubject);
        emailComplaint = findViewById(R.id.emailComplaint);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void sendMail(){
        String senderAddress = emailAddress.getText().toString();
        String[] emailAddresses = senderAddress.split(",");

        String subject = emailSubject.getText().toString();
        String message = emailComplaint.getText().toString();

        Intent intent  = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));
    }
}