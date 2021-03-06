package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private EditText edEmail, edPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser != null){
            Toast.makeText(this,"User not null", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"User null", Toast.LENGTH_SHORT).show();
        }
    }

    private void init(){
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        mAuth = FirebaseAuth.getInstance();
    }
    public void OnClickSignUp(View view){
        if(!TextUtils.isEmpty(edEmail.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(edEmail.getText().toString(),edPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"User Sign Up", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"User not Sign Up", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else{
            Toast.makeText(getApplicationContext(),"Please write", Toast.LENGTH_SHORT).show();
        }
    }


}