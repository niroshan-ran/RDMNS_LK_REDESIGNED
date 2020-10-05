package com.uee.rdmns_lk_redesigned;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Contact_Security extends AppCompatActivity {

    EditText phoneNo;
    ImageButton btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__security);

        phoneNo = findViewById(R.id.phoneNumber);
        btnCall = findViewById(R.id.phoneCall);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneNo.getText().toString();
                String s = "tel:"+ phone;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(s));
                startActivity(intent);

            }
        });
    }
}