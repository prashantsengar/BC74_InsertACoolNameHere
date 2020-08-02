package com.sih2020.sih_2020_policeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    boolean flag = false;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void update_spot(View view) {
        Intent intent = new Intent(this, update_spot.class);
        startActivity(intent);
    }

    public void nearbySos(View view) {
        DatabaseReference reference = FirebaseDatabase.getInstance("https://crime1.firebaseio.com/").getReference().child("Location_Shared");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                /*
                if (dataSnapshot.hasChild(no)) {
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No user have shared location with you.", Toast.LENGTH_SHORT).show();
                }
                 */
                if (dataSnapshot.hasChild("9988776655")) {
                    Log.d("hitttt","yes");
                    flag = true;
                    Intent intent = new Intent(MainActivity2.this, AllContacts.class);
                    startActivity(intent);
                }
              /*
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.e("snapshot", "" + snapshot.getKey());
                }
               */
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        if (flag) {
//            Intent intent = new Intent(MainActivity2.this, AllContacts.class);
//            startActivity(intent);
//        }
//        Intent intent = new Intent(this, NearbySOS.class);
//        startActivity(intent);
    }

}