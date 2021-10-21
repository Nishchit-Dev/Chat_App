package com.boxaffects.chat_app.MainActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boxaffects.chat_app.R;

import java.util.ArrayList;

public class call_history_adapter extends RecyclerView.Adapter<call_history_adapter.ViewHolder> {
    private ArrayList<String> Username = new ArrayList<>(), time_ago= new ArrayList<>() ;
    private ArrayList<Integer> userProfile = new ArrayList<>();
    public call_history_adapter(){
        Username.add("Joy");
        Username.add("Albert");
        Username.add("Charli");
        Username.add("Tom");

        time_ago.add("November 12,12:01 pm");
        time_ago.add("November 03,7:31 am");
        time_ago.add("October 09,9:21 am");
        time_ago.add("September 31,2:51 pm");

        userProfile.add(R.drawable.avatar08);
        userProfile.add(R.drawable.avatar10);
        userProfile.add(R.drawable.avatar21);
        userProfile.add(R.drawable.avatar17);

    }
    @NonNull
    @Override
    public call_history_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_call_history,parent,false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull call_history_adapter.ViewHolder holder, int position) {
        holder.Username.setText(Username.get(position));
        holder.UserCallTime.setText(time_ago.get(position));

        if(position%2 == 0 ){
            holder.call.setImageResource(R.drawable.video);
            holder.call_mode.setImageResource(R.drawable.arrow_right_up);
        }else{
            holder.call_mode.setImageResource(R.drawable.arrow_left_down);
            holder.call.setImageResource(R.drawable.call);
        }
        holder.user_pro.setImageResource(userProfile.get(position));
    }

    @Override
    public int getItemCount() {
        return Username.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView user_pro,call_mode , call ;
        TextView Username , UserCallTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_pro = itemView.findViewById(R.id.USer_Profile_call);
            call_mode = itemView.findViewById(R.id.coming_call);
            call = itemView.findViewById(R.id.Meida_call);
            Username = itemView.findViewById(R.id.USername_);
            UserCallTime = itemView.findViewById(R.id.USer_call_time);
        }
    }
}
