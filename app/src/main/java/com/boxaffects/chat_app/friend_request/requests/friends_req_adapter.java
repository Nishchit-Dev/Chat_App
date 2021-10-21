package com.boxaffects.chat_app.friend_request.requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boxaffects.chat_app.R;

import java.util.ArrayList;

public class friends_req_adapter extends RecyclerView.Adapter<friends_req_adapter.ViewHolder> {
    private ArrayList<String> username = new ArrayList<>(), mutualUser = new ArrayList<>() ;
    private ArrayList<Integer> userPro = new ArrayList<>();

    public friends_req_adapter(){
        username.add("Nishchit");
        username.add("Venil");

        mutualUser.add("9+ mutual Friends");
        mutualUser.add("5+ mutual Friends");

        userPro.add(R.drawable.avatar21);
        userPro.add(R.drawable.avatar08);

    }
    @NonNull
    @Override
    public friends_req_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_request,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull friends_req_adapter.ViewHolder holder, int position) {
        holder.username.setText(username.get(position));
        holder.mutual_user.setText(mutualUser.get(position));
        holder.userpro.setImageResource(userPro.get(position));
    }

    @Override
    public int getItemCount() {
        return username.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView userpro , accept_req , decline_req ;
        private TextView username , mutual_user;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username_sugg);
            mutual_user = itemView.findViewById(R.id.mutual_users_sugg);

            userpro = itemView.findViewById(R.id.userProfile_sugg);
            accept_req = itemView.findViewById(R.id.accept_sugg);
            decline_req = itemView.findViewById(R.id.decilne_sugg);
        }
    }
}
