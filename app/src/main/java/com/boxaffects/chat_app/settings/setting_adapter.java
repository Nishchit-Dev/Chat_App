package com.boxaffects.chat_app.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boxaffects.chat_app.R;

import java.util.ArrayList;

public class setting_adapter extends RecyclerView.Adapter<setting_adapter.ViewHolder>{
    private ArrayList<String> Settings = new ArrayList<>();
    ArrayList<Integer> icon_ = new ArrayList<>();

    public setting_adapter(){
        Settings.add("Account");
        Settings.add("Notification");
        Settings.add("Help");
        Settings.add("Invite Friend");
        Settings.add("Rate our App");

        icon_.add(R.drawable.user_circle);
        icon_.add(R.drawable.notification_outline_dot);
        icon_.add(R.drawable.help_circle_outline);
        icon_.add(R.drawable.group);
        icon_.add(R.drawable.heart_fill);

    }
    @NonNull
    @Override
    public setting_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_settings,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull setting_adapter.ViewHolder holder, int position) {
        holder.settings_name.setText(Settings.get(position));
        holder.img.setImageResource(icon_.get(position));
    }

    @Override
    public int getItemCount() {
        return Settings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView settings_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.settings_icons);
            settings_name = itemView.findViewById(R.id.settings_uid);
        }
    }
}
