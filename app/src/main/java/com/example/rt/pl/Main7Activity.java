package com.example.rt.pl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
    Button b1;
    TextView t1, t2;
    Spinner spinner;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    DatabaseHelper1 mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        getValuesOfUsers();
        setValues();

        mydb = new DatabaseHelper1(this);



    }

    public void getValuesOfUsers() {
        //t1 = (TextView) findViewById(R.id.pd);
        //t2 = (TextView) findViewById(R.id.ad);
        e1 = (EditText) findViewById(R.id.fn);
        e2 = (EditText) findViewById(R.id.sn);
        e3 = (EditText) findViewById(R.id.fn1);
        e4 = (EditText) findViewById(R.id.bn);
        e5 = (EditText) findViewById(R.id.st);
        e6 = (EditText) findViewById(R.id.loc);
        e7 = (EditText) findViewById(R.id.city);
        e8 = (EditText) findViewById(R.id.pin);
        e9 = (EditText) findViewById(R.id.state);
        e10 = (EditText) findViewById(R.id.mn);

        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();
        s5 = e5.getText().toString();
        s6 = e6.getText().toString();
        s7 = e7.getText().toString();
        s8 = e8.getText().toString();
        s9 = e9.getText().toString();
        s10 = e10.getText().toString();
        spinner = findViewById(R.id.spinner1);



    }

    public void spinner_listener() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Sal, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void setValues() {

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( e1.equals(null) || e2.equals(null) || e3.equals(null) || e4.equals(null) || e5.equals(null) || e6.equals(null) || e7.equals(null) || e8.equals(null)|| e9.equals(null) || e10.equals(null)) {
                    Toast.makeText(Main7Activity.this, "Fields are incomplete", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent1 = new Intent(getApplicationContext(), cv_input.class);
                    startActivity(intent1);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
