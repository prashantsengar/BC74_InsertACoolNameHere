package com.sih2020.InsertACoolNameHere;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //TODO: Change this to LoginOption fragment
        PhoneNumberFragment fragment = new PhoneNumberFragment();
       getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
