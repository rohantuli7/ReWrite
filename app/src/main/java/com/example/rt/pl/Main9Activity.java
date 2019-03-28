package com.example.rt.pl;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {
    Button b;
    DatabaseHelper3 db;
    EditText e0,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        e0 = (EditText)findViewById(R.id.course);
        e1 = (EditText)findViewById(R.id.year);
        e2 = (EditText)findViewById(R.id.specialization);
        e3 = (EditText)findViewById(R.id.uni);
        e4 = (EditText)findViewById(R.id.cgpa);
        e5 = (EditText)findViewById(R.id.tenb);
        e6 = (EditText)findViewById(R.id.tenm);
        e7 = (EditText)findViewById(R.id.twelveb);
        e8 = (EditText)findViewById(R.id.twelvem);
        e9 = (EditText)findViewById(R.id.c1);
        e10 = (EditText)findViewById(R.id.c2);
        e11 = (EditText)findViewById(R.id.c3);
        e12 = (EditText)findViewById(R.id.c4);
        e13 = (EditText)findViewById(R.id.c5);







        db = new DatabaseHelper3(Main9Activity.this);
        onClicker();




    }


    public void onClicker(){
        b = (Button)findViewById(R.id.next);
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


                if(TextUtils.isEmpty(s0) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3) || TextUtils.isEmpty(s4) || TextUtils.isEmpty(s5) || TextUtils.isEmpty(s6) || TextUtils.isEmpty(s7) || TextUtils.isEmpty(s8) || TextUtils.isEmpty(s9) || TextUtils.isEmpty(s10) || TextUtils.isEmpty(s11) || TextUtils.isEmpty(s12) || TextUtils.isEmpty(s13) )
                {
                    Toast.makeText(Main9Activity.this, "Fields incomplete", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean isInserted = db.insertData(s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13);
                    if (isInserted == true)
                    {
                        String idval = "0";

                        Toast.makeText(Main9Activity.this, "data inserted", Toast.LENGTH_LONG).show();
                        boolean isUpdated = db.updateData(idval,s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13);
                        if (isUpdated == true) {


                            Intent intent = new Intent(getApplicationContext(), cv3.class);
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(Main9Activity.this, "Data not inserted", Toast.LENGTH_LONG).show();
                    }

                }




            }
        });
    }

    /*public void viewData(){
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllData();
                if(res.getCount() == 0){
                    Toast.makeText(Main9Activity.this, "Data not there", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Main9Activity.this, "Data present", Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/
}
