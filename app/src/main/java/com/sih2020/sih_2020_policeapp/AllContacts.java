package com.sih2020.sih_2020_policeapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllContacts extends AppCompatActivity {

    TextView cont;
    Button btn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    double lat, lon;
    String contact;
    private RecyclerView recyclerView;
    private List<ContactModel> contactModels;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        recyclerView = findViewById(R.id.contactRecylcer);
        contactModels = new ArrayList<>();
        preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
        editor = preferences.edit();
        final String no = preferences.getString("PHN", "");

        SharedPreferences prefs = getSharedPreferences("SIH2020", MODE_PRIVATE);
        String name = prefs.getString("email", "");
        name = name.replace('@','%');
        name = name.replace('.','%');
        DatabaseReference reference = FirebaseDatabase.getInstance("https://crime1.firebaseio.com/").getReference().child("sos_location").child(name).child("sos");
        Log.d("new_name",name);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    NotificationCompat.Builder mBuilder =
                            new NotificationCompat.Builder(AllContacts.this)
                                    .setSmallIcon(R.drawable.ic_launcher_background)
                                    .setContentTitle("SOS raised!")
                                    .setContentText("Someone raise sos nearby");
                    mBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                    contactModels.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Log.e("contact::",""+snapshot.getKey());
//                        for(DataSnapshot shot: snapshot.getChildren())  {
//                            Log.e("contact::",""+shot.getKey());
                            contactModels.add(new ContactModel(snapshot.child("phone").getValue().toString(),snapshot.child("lat").getValue().toString(),snapshot.child("long").getValue().toString(),snapshot.child("phone").getValue().toString(),snapshot.child("bloodgroup").getValue().toString()));
//                            contactModels.add(new ContactModel(""+dataSnapshot.child("9988776655").child(shot.getKey()).child("Name").getValue().toString(),""+shot.getKey(),dataSnapshot.child("9988776655").child(shot.getKey()).child("Latitude").getValue().toString(),dataSnapshot.child("9988776655").child(shot.getKey()).child("Longitude").getValue().toString()));
//                        }

                        //  Log.e("name",""+name);
                        //
                        //   contactModels.add(new ContactModel(dataSnapshot.child(no).child(contact).child("Name").getValue().toString(), contact));
                    }
//                    Log.e("path", "" + dataSnapshot.child("9988776655").child("9988776655").child("Latitude").getValue().toString());
                    //lat = Double.valueOf(dataSnapshot.child(contact).child("Latitude").getValue().toString());
                    // lon = Double.valueOf(dataSnapshot.child(contact).child("Longitude").getValue().toString());
                    //  GoToMap();

                    ContactAdapter adapter = new ContactAdapter(contactModels, AllContacts.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AllContacts.this));
                    recyclerView.setAdapter(adapter);

                } else {
                    Toast.makeText(AllContacts.this, "No user have shared location with you.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void GoToMap() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllContacts.this, MapsActivity.class);
                intent.putExtra("Latitude", lat);
                intent.putExtra("Longitude", lon);
                startActivity(intent);
            }
        });
    }
}