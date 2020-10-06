package com.uee.rdmns_lk_redesigned;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom_about);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner1);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_about_us,new AboutDeveloperFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner1 = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch(menuItem.getItemId()){
                case R.id.nav_about_app:
                    selectedFragment = new AboutAppFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_about_us,selectedFragment).commit();
                    break;
                case R.id.nav_about_developer:
                    selectedFragment = new AboutDeveloperFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_about_us,selectedFragment).commit();
                    break;
            }



            return true;
        }
    };
}