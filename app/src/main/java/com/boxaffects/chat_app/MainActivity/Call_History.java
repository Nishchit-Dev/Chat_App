package com.boxaffects.chat_app.MainActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boxaffects.chat_app.Chats.User_Chats;
import com.boxaffects.chat_app.R;

public class Call_History extends Fragment {

    private RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_friend__request, container, false);
        recyclerView = rootview.findViewById(R.id.Rv);

        call_history_adapter adapter = new call_history_adapter();
        LinearLayoutManager lvm = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(lvm);
        recyclerView.setAdapter(adapter);


        return rootview;
    }
}