package com.boxaffects.chat_app.friend_request;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.boxaffects.chat_app.R;
import com.boxaffects.chat_app.friend_request.requests.friends_req_adapter;
import com.boxaffects.chat_app.friend_request.suggesition.friends_suggestion_adapter;

public class Friends_Req extends AppCompatActivity {
    private RecyclerView Rv_req , Rv_sugg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends__req);

        Rv_req = findViewById(R.id.RV_requested);
        Rv_sugg = findViewById(R.id.Rv_suggestion);

        friends_req_adapter req_adapter = new friends_req_adapter();
        friends_suggestion_adapter suggestion_adapter = new friends_suggestion_adapter();

        LinearLayoutManager lvm = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        LinearLayoutManager lvm1 = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);

        Rv_req.setAdapter(req_adapter);
        Rv_sugg.setAdapter(suggestion_adapter);

        Rv_req.setLayoutManager(lvm);
        Rv_sugg.setLayoutManager(lvm1);

    }
}