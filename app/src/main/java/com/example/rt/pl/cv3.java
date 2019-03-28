package com.example.rt.pl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cv3 extends AppCompatActivity {
    Button b;
    DatabaseHelper2 db;
    EditText e0,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv3);

        e0 = (EditText)findViewById(R.id.s1);
        e1 = (EditText)findViewById(R.id.s2);
        e2 = (EditText)findViewById(R.id.s3);
        e3 = (EditText)findViewById(R.id.s4);
        e4 = (EditText)findViewById(R.id.s5);
        e5 = (EditText)findViewById(R.id.h1);
        e6 = (EditText)findViewById(R.id.h2);
        e7 = (EditText)findViewById(R.id.h3);
        e8 = (EditText)findViewById(R.id.h4);
        e9 = (EditText)findViewById(R.id.h5);
        e10 = (EditText)findViewById(R.id.h6);
        e11 = (EditText)findViewById(R.id.h7);
        e12 = (EditText)findViewById(R.id.h8);
        e13 = (EditText)findViewById(R.id.h9);
        e14 = (EditText)findViewById(R.id.h10);
        e15 = (EditText)findViewById(R.id.p1);
        e16 = (EditText)findViewById(R.id.p2);
        e17 = (EditText)findViewById(R.id.p3);


        db = new DatabaseHelper2(cv3.this);

        onClicker();


    }


    public void onClicker(){
        b = (Button)findViewById(R.id.button1);
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
                String s10 = e10.getText().toString().trim();
                String s11 = e11.getText().toString().trim();
                String s12 = e12.getText().toString().trim();
                String s13 = e13.getText().toString().trim();
                String s14 = e14.getText().toString().trim();
                String s15 = e15.getText().toString().trim();
                String s16 = e16.getText().toString().trim();
                String s17 = e17.getText().toString().trim();

                if(TextUtils.isEmpty(s0) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3) || TextUtils.isEmpty(s4) || TextUtils.isEmpty(s5) || TextUtils.isEmpty(s6) || TextUtils.isEmpty(s7) || TextUtils.isEmpty(s8) || TextUtils.isEmpty(s9) || TextUtils.isEmpty(s10) || TextUtils.isEmpty(s11) || TextUtils.isEmpty(s12) || TextUtils.isEmpty(s13) || TextUtils.isEmpty(s14) || TextUtils.isEmpty(s15) || TextUtils.isEmpty(s16) || TextUtils.isEmpty(s17) )
                {
                    Toast.makeText(cv3.this, "Fields incomplete", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean isInserted = db.insertData(s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17);
                    if (isInserted == true)
                    {
                        String idval = "0";

                        Toast.makeText(cv3.this, "data inserted", Toast.LENGTH_LONG).show();
                        boolean isUpdated = db.updateData(idval,s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17);
                        if (isUpdated == true) {
                            Toast.makeText(cv3.this, "Data updated", Toast.LENGTH_LONG).show();


                            Intent intent = new Intent(getApplicationContext(), cv4.class);
                            startActivity(intent);
                        }

                    }
                    else{
                        Toast.makeText(cv3.this, "Data not inserted", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }
}
