package com.boxaffects.chat_app.MainActivity;


import android.graphics.drawable.Drawable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boxaffects.chat_app.R;


import java.util.ArrayList;

public class recycler_Adapter extends RecyclerView.Adapter<recycler_Adapter.ViewHolder> {
    private ArrayList<String> Username = new ArrayList<>();
    private ArrayList<String> Users_messages = new ArrayList<>();
    private ArrayList<Integer> Users_profile = new ArrayList<>();
    private ArrayList<String> User_time_ago = new ArrayList<>();
    public recycler_Adapter(){
        Username.add("james");
        Username.add("tony");
        Username.add("Charli");
        Username.add("Robert");
        Username.add("Bruce");
        Username.add("Son-Kun");

        Username.add("Tintin");
        Username.add("Paul Walker");
        Username.add("Vin diesel");
        Username.add("jacky");
        Username.add("Steve Jobs");
        Username.add("Vegeta");

        Users_messages.add("Hey!");
        Users_messages.add("Where have u been whole day. i was waiting for u at the station");
        Users_messages.add("Yeah got it");
        Users_messages.add("i will make some changes in ui, gotcha");
        Users_messages.add("i forgot to ping u when the server is up");
        Users_messages.add("its sunday today whats the plan");

        Users_messages.add("Hello!");
        Users_messages.add("waiting for season 6 to release");
        Users_messages.add("yup! yup!");
        Users_messages.add("ohh god why didn't you tell me");
        Users_messages.add("currently learning node js");
        Users_messages.add("being data Scientist is hard stuff");

        Users_profile.add(R.drawable.avatar21);
        Users_profile.add(R.drawable.avatar01);
        Users_profile.add(R.drawable.avatar18);
        Users_profile.add(R.drawable.avatar09);
        Users_profile.add(R.drawable.avatar05);
        Users_profile.add(R.drawable.avatar13);

        Users_profile.add(R.drawable.avatar20);
        Users_profile.add(R.drawable.avatar04);
        Users_profile.add(R.drawable.avatar11);
        Users_profile.add(R.drawable.avatar06);
        Users_profile.add(R.drawable.avatar03);
        Users_profile.add(R.drawable.avatar16);

        User_time_ago.add("1 min");
        User_time_ago.add("3 min");
        User_time_ago.add("6 min");
        User_time_ago.add("10 min");
        User_time_ago.add("15 min");
        User_time_ago.add("20 min");

        User_time_ago.add("21 min");
        User_time_ago.add("28 min");
        User_time_ago.add("35 min");
        User_time_ago.add("38 min");
        User_time_ago.add("41 min");
        User_time_ago.add("49 min");

    }
    @NonNull
    @Override
    public recycler_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chats,parent,false);
        recycler_Adapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_Adapter.ViewHolder holder, int position) {
        holder.Username.setText(Username.get(position));
        holder.UserMsg.setText(Users_messages.get(position));
        holder.UserProfile.setImageResource(Users_profile.get(position));
        holder.Time_Ago.setText(User_time_ago.get(position));
    }

    @Override
    public int getItemCount() {
        return Username.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Username ,UserMsg ,Time_Ago;
        ImageView UserProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Time_Ago = itemView.findViewById(R.id.time_ago);
            Username = itemView.findViewById(R.id.USername);
            UserMsg = itemView.findViewById(R.id.USermessages);
            UserProfile = itemView.findViewById(R.id.USerprofile);
        }

    }
}
