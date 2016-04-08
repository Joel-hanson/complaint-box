package com.example.achal.complaintbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    public final static String NAME = "com.mycompany.myfirstapp.NANE";
    public final static String UID = "com.mycompany.myfirstapp.UID";
    public final static String YOB = "com.mycompany.myfirstapp.YOB";
    public final static String HOUSE = "com.mycompany.myfirstapp.HOUSE";
    public final static String DIST = "com.mycompany.myfirstapp.DIST";
    public final static String STATE= "com.mycompany.myfirstapp.STATE";
    public final static String PC = "com.mycompany.myfirstapp.PC";
    private Button button_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListner();

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
        button_1= (Button)findViewById(R.id.button1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MainUserIDActivity.class);
                startActivity(intent);
            }
        });

    }
    public void adhaarcard(View v) {
        new IntentIntegrator(this).initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                if (intentResult != null) {
                    String contents = intentResult.getContents();

                    try {
                        XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
                        XmlPullParser myparser = xmlFactoryObject.newPullParser();
                        InputStream stream = new ByteArrayInputStream(contents.getBytes(StandardCharsets.UTF_8));
                        myparser.setInput(stream,null);
                        int event = myparser.getEventType();
                        while (event != XmlPullParser.END_DOCUMENT)
                        {
                            switch (event){
                                case XmlPullParser.START_TAG:
                                    break;

                                case XmlPullParser.END_TAG:

                                    String uid = myparser.getAttributeValue(null,"uid");
                                    String name = myparser.getAttributeValue(null,"name");
                                    String yob = myparser.getAttributeValue(null,"yob");
                                    String house = myparser.getAttributeValue(null,"house");
                                    String dist = myparser.getAttributeValue(null,"dist");
                                    String state = myparser.getAttributeValue(null,"state");
                                    String pc = myparser.getAttributeValue(null,"pc");

                                        Intent intent;
                                        intent = new Intent(this, adharcard.class);
                                        intent.putExtra(NAME,name);
                                        intent.putExtra(UID,uid);
                                        intent.putExtra(YOB,yob);
                                        intent.putExtra(HOUSE,house);
                                        intent.putExtra(DIST,dist);
                                        intent.putExtra(STATE,state);
                                        intent.putExtra(PC,pc);

                                        startActivity(intent);


                            }

                            event = myparser.next();
                        }
                    } catch(Exception e){}





                } else {
                    Log.e("SEARCH_EAN", "IntentResult je NULL!");
                }

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
