package com.boxaffects.chat_app.Login_SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.boxaffects.chat_app.MainActivity.Chats;
import com.boxaffects.chat_app.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void load_chats(View view){
        Intent i = new Intent(getApplicationContext(), Chats.class);
        startActivity(i);
    }
}