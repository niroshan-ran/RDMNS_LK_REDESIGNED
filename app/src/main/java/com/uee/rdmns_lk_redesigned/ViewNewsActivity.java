package com.uee.rdmns_lk_redesigned;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ViewNewsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewTopic, textViewDes;

    NewsFeedModel newsFeedModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);

    imageView = findViewById(R.id.newsImageView);
    textViewTopic = findViewById(R.id.newsTopicName);
    textViewDes = findViewById(R.id.newsDesText);

    final Intent intent = getIntent();

        if(intent.getExtras() != null){
            newsFeedModel = (NewsFeedModel)intent.getSerializableExtra("news");

            imageView.setImageResource(newsFeedModel.getImage());
            textViewTopic.setText(newsFeedModel.getTopic());
            textViewDes.setText(newsFeedModel.getDesc());

        }

        FloatingActionButton floatingActionButton = findViewById(R.id.imageShareFab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetWorldReadable")
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewNewsActivity.this,"start", Toast.LENGTH_SHORT).show();
                Drawable myDrawable = imageView.getDrawable();
                Bitmap bitmap = ((BitmapDrawable)myDrawable).getBitmap();

                try {
                    File file = new File(ViewNewsActivity.this.getExternalCacheDir(), "myImage.png");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG,80,fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true,false);

                    Intent intent1 = new Intent(Intent.ACTION_SEND);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent1.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                    intent1.setType("image/png");
                    startActivity(Intent.createChooser(intent1,"Share Image Via"));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(ViewNewsActivity.this,"File not found", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}