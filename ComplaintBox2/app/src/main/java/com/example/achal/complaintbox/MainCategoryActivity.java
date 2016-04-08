package com.example.achal.complaintbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainCategoryActivity extends AppCompatActivity {

    public final static String SPIN1 = "com.mycompany.myfirstapp.SPIN1";
    public final static String SPIN2 = "com.mycompany.myfirstapp.SPIN2";
    public final static String NAME1 = "com.mycompany.myfirstapp.NAME1";
    public final static String UID1 = "com.mycompany.myfirstapp.UID1";
    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter,adapter2;
    private Button button_4;
    String spin1,name,uid;
    String spin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListner();

        spinner1=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.category_names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);


        spinner2=(Spinner)findViewById(R.id.spinner2);
        adapter2=ArrayAdapter.createFromResource(this,R.array.area_names,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        Intent intent=getIntent();
        name = intent.getStringExtra(MainUserIDActivity.NAME1);
        uid = intent.getStringExtra(MainUserIDActivity.UID1);

        Toast.makeText(getApplicationContext(), "Welcome 2" + name, Toast.LENGTH_SHORT).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void OnClickButtonListner(){
        button_4= (Button)findViewById(R.id.button4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainCategoryActivity.this,MainReadWriteActivity.class);
                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                spin1 = spinner.getSelectedItem().toString();
                Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
                spin2 = spinner1.getSelectedItem().toString();

                intent.putExtra(SPIN1,spin1);
                intent.putExtra(SPIN2,spin2);
                intent.putExtra(NAME1,name);
                intent.putExtra(UID1,uid);

                startActivity(intent);
            }
        });

    }



}
