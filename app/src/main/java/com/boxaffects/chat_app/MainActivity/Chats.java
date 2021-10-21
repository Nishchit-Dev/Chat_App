package com.boxaffects.chat_app.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.boxaffects.chat_app.Chats.User_Chats;
import com.boxaffects.chat_app.R;
import com.boxaffects.chat_app.friend_request.Friends_Req;
import com.boxaffects.chat_app.settings.Settings;
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
//
//        tabLayout = findViewById(R.id.tab);
//        tabLayout.setupWithViewPager(ViewPAger);
    }
    public void load_settings(View view){
        Intent i = new Intent(getApplicationContext(), Settings.class);
        startActivity(i);
    }
    public void add_friend(View v){
        Intent i = new Intent(getApplicationContext(), Friends_Req.class);
        startActivity(i);
    }

    public void back(){
        finishAffinity();
    }
    public void msg(View v){
        Intent i = new Intent(getApplicationContext(), User_Chats.class);
        startActivity(i);
    }
}