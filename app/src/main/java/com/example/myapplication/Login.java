package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    private EditText edName, edSecName;
    private DatabaseReference mDataBase;
    private String USER_KEY = "Target";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    public void init()
    {
        edName = findViewById(R.id.edName);
        edSecName = findViewById(R.id.edSecName);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);


    }


    public void onClickSave(View view){
        String id = mDataBase.getKey();
        String name = edName.getText().toString();
        String sec_name = edSecName.getText().toString();
        Target newUser = new Target(id,name,sec_name);
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sec_name) ) {

            mDataBase.push().setValue(newUser);
        }
        else
        {
            Toast.makeText(this,"Пустое поле",Toast.LENGTH_SHORT).show();
        }


    }

    public void onClickRead(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }
}