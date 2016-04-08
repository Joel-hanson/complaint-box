package com.example.achal.complaintbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainWriteActivity extends AppCompatActivity {
    private Button button_7;
    Intent intent;
    String uid,name;
    Firebase myFirebaseRef;
    String complaint,subject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_write);
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


        intent= getIntent();
        uid = intent.getStringExtra("uid");
        name = intent.getStringExtra("name");
        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        TextView obj1 = (TextView) findViewById(R.id.textview3);
        obj1.setText("name :" + name+uid);


    }


   public void submit(View v)
   {

       subject=((EditText)findViewById(R.id.editText4)).getText().toString();
       complaint=((EditText)findViewById(R.id.editText5)).getText().toString();

       myFirebaseRef = new Firebase("https://complaintbox1.firebaseio.com/");


       myFirebaseRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {


          @Override
          public void onDataChange (DataSnapshot snapshot){


          if (snapshot.getValue() != null) {
              user user1 = snapshot.getValue(user.class);
              myFirebaseRef = new Firebase("https://complaintbox1.firebaseio.com");
              SharedPreferences sharedpreferences = getSharedPreferences("shit", Context.MODE_PRIVATE);
              DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
              Date today = Calendar.getInstance().getTime();
              myFirebaseRef.child("complaint").child(sharedpreferences.getString("uid", "error")).setValue(subject +"\n"+complaint +"\n" +df.format(today)+"\n" + user1.getName() + "\n" + user1.getDistrict() + "\n" + user1.getPc());
              Intent inte = new Intent(getApplicationContext(), MainReadWriteActivity.class);
              startActivity(inte);

          } else {
              Toast.makeText(getApplicationContext(), "User not founf", Toast.LENGTH_LONG).show();
          }

      }

          @Override
          public void onCancelled (FirebaseError firebaseError){

      }

      }

      );

      Toast.makeText(

              getApplicationContext(),

              "complaint registered", Toast.LENGTH_LONG).

      show();


  }


   }





