package com.example.rt.pl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {

    Button b;
    EditText e0,e1,e2,e3,e4,e5,e6,e7,e8,e9;
    String s0,s1,s2,s3,s4,s5,s6,s7,s8,s9;

    DatabaseHelper1 db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        e0 = (EditText)findViewById(R.id.fn);
        e1 = (EditText)findViewById(R.id.ln);
        e2 = (EditText)findViewById(R.id.fn1);
        e3 = (EditText)findViewById(R.id.bn);
        e4 = (EditText)findViewById(R.id.st);
        e5 = (EditText)findViewById(R.id.loc);
        e6 = (EditText)findViewById(R.id.city);
        e7 = (EditText)findViewById(R.id.pin);
        e8 = (EditText)findViewById(R.id.state);
        e9 = (EditText)findViewById(R.id.mn);





        db = new DatabaseHelper1(Main8Activity.this);

        //getValues();
        onCLicker();




    }


    void onCLicker(){

        b = (Button)findViewById(R.id.nextpage);
        b.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String s0 = e0.getText().toString().trim();
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString().trim();
                String s3 = e3.getText().toString().trim();
                String s4 = e4.getText().toString().trim();
                String s5 = e5.getText().toString().trim();
                String s6 = e6.getText().toString().trim();
                String s7 = e7.getText().toString().trim();
                String s8 = e8.getText().toString().trim();
                String s9 = e9.getText().toString().trim();


                if(TextUtils.isEmpty(s0) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3) || TextUtils.isEmpty(s4) || TextUtils.isEmpty(s5) || TextUtils.isEmpty(s6) || TextUtils.isEmpty(s7) || TextUtils.isEmpty(s8) || TextUtils.isEmpty(s9) )
                {
                    Toast.makeText(Main8Activity.this, s0+" "+s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7+" "+s8+" "+s9, Toast.LENGTH_LONG).show();
                }
                else{
                    Boolean isInserted = db.insertData1(s0,s1,s2,s3,s4,s5,s6,s7,s8,s9);
                    if (isInserted == true)
                    {
                        String idval = "0";

                        Toast.makeText(Main8Activity.this, "data inserted", Toast.LENGTH_LONG).show();
                        boolean isUpdated = db.updateData(idval,s0,s1,s2,s3,s4,s5,s6,s7,s8,s9);
                        if (isUpdated == true) {


                            Intent intent = new Intent(getApplicationContext(), Main9Activity.class);
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(Main8Activity.this, "Data not inserted", Toast.LENGTH_LONG).show();
                    }

                }





            }
        });

    }


}
