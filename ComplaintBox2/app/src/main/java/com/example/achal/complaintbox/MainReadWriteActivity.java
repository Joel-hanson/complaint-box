package com.example.achal.complaintbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainReadWriteActivity extends AppCompatActivity {
    private Button button_5;
    private Button button_6;


String name,uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read_write);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent=getIntent();
        name = intent.getStringExtra(MainUserIDActivity.NAME1);
        uid = intent.getStringExtra(MainUserIDActivity.UID1);
        Toast.makeText(getApplicationContext(), "Welcome " + name+uid, Toast.LENGTH_SHORT).show();

    }

    public void read(View v) {


        Intent intent = new Intent(MainReadWriteActivity.this,MainReadActivity.class);
        intent.putExtra("uid",uid);
        startActivity(intent);



    }






    public void wirte (View v)
    {


                Intent intent = new Intent(MainReadWriteActivity.this,MainWriteActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("uid",uid);
        SharedPreferences sharedpreferences = getSharedPreferences("shit", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("uid", uid);
        editor.commit();

        startActivity(intent);

    }


    }


