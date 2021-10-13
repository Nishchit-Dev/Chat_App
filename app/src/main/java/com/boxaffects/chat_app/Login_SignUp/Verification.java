package com.boxaffects.chat_app.Login_SignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boxaffects.chat_app.R;
import com.boxaffects.chat_app.UserDetails.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Verification extends AppCompatActivity {
    private EditText Otp;
    private Button verify;
    private String phn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        Otp = findViewById(R.id.phnno);
        verify = findViewById(R.id.verify);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify_otp();
            }
        });
    }
    public void verify_otp(){
        Bundle b = getIntent().getExtras();
        String vID = b.getString("verificationID");
        phn = b.getString("Phone");

        String code = Otp.getText().toString();
        PhoneAuthCredential cred = PhoneAuthProvider.getCredential(vID,code);
        FirebaseAuth.getInstance().signInWithCredential(cred)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference dbref = database.getReference();
                            Toast.makeText(getApplicationContext(),"verified Successfully",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), UserData.class);
                            i.putExtra("phone",phn);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(),"verification failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}