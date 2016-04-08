package com.example.achal.complaintbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class adharcard extends AppCompatActivity {
    public final static String NAME = "com.mycompany.myfirstapp.NANE";
    public final static String UID = "com.mycompany.myfirstapp.UID";
    public final static String YOB = "com.mycompany.myfirstapp.YOB";
    public final static String HOUSE = "com.mycompany.myfirstapp.HOUSE";
    public final static String DIST = "com.mycompany.myfirstapp.DIST";
    public final static String STATE= "com.mycompany.myfirstapp.STATE";
    public final static String PC = "com.mycompany.myfirstapp.PC";
    String name;
    String uid;
    String yob;
    String house;
    String dist;
    String state;
    String pc;

    public void register1(View view)
    {
        Intent intent=new Intent(getApplicationContext(),register.class);
        intent.putExtra(NAME,name);
        intent.putExtra(UID,uid);
        intent.putExtra(YOB,yob);
        intent.putExtra(HOUSE,house);
        intent.putExtra(DIST,dist);
        intent.putExtra(STATE,state);
        intent.putExtra(PC,pc);


        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adharcard);


        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.NAME);
        uid = intent.getStringExtra(MainActivity.UID);
        yob = intent.getStringExtra(MainActivity.YOB);
        house = intent.getStringExtra(MainActivity.HOUSE);
        dist = intent.getStringExtra(MainActivity.DIST);
        state = intent.getStringExtra(MainActivity.STATE);
        pc = intent.getStringExtra(MainActivity.PC);
        TextView obj1 = (TextView) findViewById(R.id.editText9);
        TextView obj2 = (TextView) findViewById(R.id.editText8);
        TextView obj3 = (TextView) findViewById(R.id.editText7);
        TextView obj4 = (TextView) findViewById(R.id.editText6);

        obj1.setText("name :" + name);
        obj2.setText("adhar number:" + uid);
        obj3.setText("year of birth:" + yob);
        obj4.setText("The adress is : \n house: " + house + "\n district :" + dist + "\n state :" + state + "\n pin :" + pc);

    }


}
