package com.boxaffects.chat_app.MainActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boxaffects.chat_app.R;
import com.boxaffects.chat_app.friend_request.Friends_Req;

public class Chats_frag extends Fragment {
    private RecyclerView rv ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_chats_frag, container, false);
        rv = rootView.findViewById(R.id.Rv);
        recycler_Adapter adapter = new recycler_Adapter();
        LinearLayoutManager lvm = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(lvm);
        rv.setAdapter(adapter);
        return rootView;
    }

}