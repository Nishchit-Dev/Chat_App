package com.boxaffects.chat_app.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.boxaffects.chat_app.R;
import com.google.android.material.tabs.TabLayout;

public class Chats extends AppCompatActivity {
    private ViewPager ViewPAger ;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        ViewPAger = findViewById(R.id.VP);
        ViewPAger.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(ViewPAger);
    }

}