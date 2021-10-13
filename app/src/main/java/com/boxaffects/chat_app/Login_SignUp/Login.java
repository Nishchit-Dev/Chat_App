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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {
    private EditText Phone ;
    private  String phn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button send = findViewById(R.id.send_Otp);
        Phone = findViewById(R.id.edPhone);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendOtp();
            }
        });

    }
    public void SendOtp(){
        System.out.println("hello" );
            phn = "+91"+Phone.getText().toString().trim();
        System.out.println(phn );

        // we are using the phone no authenticating
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                .setPhoneNumber(phn)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(Login.this)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        Toast.makeText(getApplicationContext(), "Verifed Successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(), "invalid no", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference dbref = database.getReference("UsersID");


                        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(phn)){
                                    Toast.makeText(getApplicationContext(),"User already exist",Toast.LENGTH_SHORT).show();
                                }else{
                                    String key = dbref.push().getKey();
                                    dbref.child(phn).setValue(key);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
//                        Toast.makeText(getApplicationContext(),"code sent Successfully",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),Verification.class);
                        i.putExtra("verificationID",s);
                        i.putExtra("Phone",phn);
                        startActivity(i);
                    }
                }).build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}