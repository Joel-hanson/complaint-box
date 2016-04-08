package com.example.achal.complaintbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class MainReadActivity extends AppCompatActivity {
    Intent intent;
    String uid;
    Firebase myFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Firebase.setAndroidContext(this);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        intent = getIntent();
        uid = intent.getStringExtra("uid");
        myFirebaseRef = new Firebase("https://complaintbox1.firebaseio.com/complaint");
        myFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> ar = new ArrayList<String>();
                if (dataSnapshot.getValue() != null) {


                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        ar.add(snapshot.getValue().toString() + "\n" + snapshot.getKey().toString());

                    }


                }

                String[] a = ar.toArray(new String[0]);

                ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listitem, a);

                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }




}
