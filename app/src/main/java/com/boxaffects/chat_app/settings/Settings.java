package com.boxaffects.chat_app.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.boxaffects.chat_app.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RecyclerView rv = findViewById(R.id.Rv_settings);
        LinearLayoutManager lvm = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        setting_adapter adapter = new setting_adapter();

        rv.setLayoutManager(lvm);
        rv.setAdapter(adapter);
    }
    public void back(View view){
        finish();
    }
}