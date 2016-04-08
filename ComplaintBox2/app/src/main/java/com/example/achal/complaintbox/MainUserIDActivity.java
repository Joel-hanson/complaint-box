package com.example.achal.complaintbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class MainUserIDActivity extends AppCompatActivity {
    public final static String NAME1 = "com.mycompany.myfirstapp.NAME1";
    public final static String UID1 = "com.mycompany.myfirstapp.UID1";
    public final static String YOB1 = "com.mycompany.myfirstapp.YOB1";
    public final static String HOUSE1 = "com.mycompany.myfirstapp.HOUSE1";
    public final static String DIST1 = "com.mycompany.myfirstapp.DIST1";
    public final static String STATE1= "com.mycompany.myfirstapp.STATE1";
    public final static String PC1 = "com.mycompany.myfirstapp.PC1";
    EditText pass_word;
    String user_id;
    private Button button_2;
    Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://complaintbox1.firebaseio.com/");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_id);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       Log.e("joel", "1");


    }

   public void signin(View v)
   {
        button_2= (Button)findViewById(R.id.button3);
        pass_word =(EditText)findViewById(R.id.editText2);
        user_id =((EditText)findViewById(R.id.editText1)).getText().toString();
        Toast.makeText(getApplicationContext(), user_id, Toast.LENGTH_SHORT).show();
        Log.e("joel","2");

                myFirebaseRef.child(user_id).addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Log.e("joel", user_id);
                        if (snapshot.getValue() != null) {
                            Log.e("joel", "3");
                            user user1 = snapshot.getValue(user.class);
                            Log.e("joel", "4");
                            String passcheck = ((EditText) findViewById(R.id.editText2)).getText().toString();
                            Log.e("joel", "5");

                            if (user1.getPassword().compareTo(passcheck) == 0) {
                                Log.e("joel", "6");


                                Intent inte = new Intent(getApplicationContext(), MainCategoryActivity.class);
                                inte.putExtra(UID1, user1.getUid());
                                inte.putExtra(NAME1, user1.getName());
                                inte.putExtra(YOB1, user1.getYob());
                                inte.putExtra(HOUSE1, user1.getHouse());
                                inte.putExtra(DIST1, user1.getDistrict());
                                inte.putExtra(STATE1, user1.getState());
                                inte.putExtra(PC1, user1.getPc());


                                startActivity(inte);

                            } else {
                                Toast.makeText(getApplicationContext(), "Pass wrng", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        //System.out.println("The read failed: " + firebaseError.getMessage());
                    }

                });

            }





}
