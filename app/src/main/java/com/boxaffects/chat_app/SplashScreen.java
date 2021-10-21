package com.boxaffects.chat_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.boxaffects.chat_app.Login_SignUp.Log_In;
import com.boxaffects.chat_app.Login_SignUp.Login;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // checking if the user is already logged in or not

    }
    public void Login(View view){
        Intent i = new Intent(this, Log_In.class);
        startActivity(i);
    }
    public void signup(View view){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
    public boolean Check_4_logged(){
        SharedPreferences log = getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor logEdit = log.edit();

        if(log.getBoolean("login",false)){
            // login false the user is not login
            Intent i = new Intent(this, Login.class);
            startActivity(i);
            return false ;
        }else{
            // user is logged in
            return true;
        }

    }
}