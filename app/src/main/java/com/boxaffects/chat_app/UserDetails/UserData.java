package com.boxaffects.chat_app.UserDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boxaffects.chat_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UserData extends AppCompatActivity {
    private EditText username ;
    private Button next ;
    private String Uid = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        username = findViewById(R.id.user);
        next = findViewById(R.id.Save);
        Bundle b = getIntent().getExtras();
        String phn = b.getString("phone");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("UsersID/"+phn);
                String Uname = username.getText().toString().trim();
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Uid = snapshot.getValue(String.class);
                        System.out.println(Uid);
                        if(Uid != null){
                            HashMap<String,String> data = new HashMap<>();
                            data.put("Username",Uname);
                            data.put("id",Uid);
                            DatabaseReference dbref = database.getReference("Users").child(Uid);
                            dbref.setValue(data);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



                Toast.makeText(getApplicationContext(),username.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }


}