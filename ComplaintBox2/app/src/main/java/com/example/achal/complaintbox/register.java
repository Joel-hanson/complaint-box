package com.example.achal.complaintbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class register extends AppCompatActivity {
    Firebase myFirebaseRef;
    EditText password,repassword;
    String uid; Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://complaintbox1.firebaseio.com/");

        intent = getIntent() ;
        password = (EditText)findViewById(R.id.editText11);
        repassword=(EditText)findViewById(R.id.editText10);
        uid = intent.getStringExtra(adharcard.UID);


    }
    public void register2(View view)
    {

        user scanned_user = new user(intent.getStringExtra(adharcard.UID),password.getText().toString(),intent.getStringExtra(adharcard.NAME),intent.getStringExtra(adharcard.YOB),intent.getStringExtra(adharcard.HOUSE),intent.getStringExtra(adharcard.STATE),intent.getStringExtra(adharcard.DIST),intent.getStringExtra(adharcard.PC));


        if(password.getText().length() < 6 )
        {
            password.setError("Minimum 6 chara");
        }
        else if( password.getText().length() > 8 )
        {
            password.setError("Max 8 chara");
        }
        else {

            if (password.getText().toString().compareTo(repassword.getText().toString()) == 0) {

                myFirebaseRef.child(uid).setValue(scanned_user);
                Toast.makeText(this, "welcome to our family", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, " Passwod missmatch", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
