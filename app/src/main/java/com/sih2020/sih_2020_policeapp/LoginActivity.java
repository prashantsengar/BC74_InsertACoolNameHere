package com.sih2020.sih_2020_policeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Collections;

public class LoginActivity extends AppCompatActivity {
    String MY_PREFS_NAME = "SIH2020";
    EditText e1,e2;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intialize();

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString("email", "");
        if(!name.equals(""))
        {
            startActivity(new Intent(this,MainActivity2.class));
        }

    }

    private void intialize() {
        e1 = (EditText)findViewById(R.id.email);
        e2 = (EditText)findViewById(R.id.password);
    }

    public void login(View view) {
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
         editor.putString("email", e1.getText().toString());
         editor.apply();
        if(e2.getText().toString().equals("sih2020"))
        {
            startActivity(new Intent(this,MainActivity2.class));
        }

    }
}