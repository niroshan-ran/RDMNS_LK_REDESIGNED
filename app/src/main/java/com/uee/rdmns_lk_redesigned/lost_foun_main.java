package com.uee.rdmns_lk_redesigned;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class lost_foun_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_foun_main);

        BottomNavigationView bottomNav = findViewById(R.id.nav_bottom);
        bottomNav.setOnNavigationItemSelectedListener(navListner);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_lost:
                                selectedFragment = new LostFragment();
                                break;
                        case R.id.nav_found:
                                selectedFragment = new FoundFragment();
                                break;
                        case R.id.nav_instruction:
                                selectedFragment = new InstructionFragment();
                                break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,selectedFragment).commit();

                    return true;
                }
            };
}