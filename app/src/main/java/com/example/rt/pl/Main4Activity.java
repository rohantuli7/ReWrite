package com.example.rt.pl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
    Button b1;
    TextView t1, t2;
    Spinner spinner = findViewById(R.id.spinner1);
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getValuesOfUsers();
        spinner_listener();
        setValues();

    }

    public void spinner_listener() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Sal, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    public void getValuesOfUsers() {
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
        t1 = (TextView) findViewById(R.id.pd);
        t2 = (TextView) findViewById(R.id.ad);

        s1 = e1.getText().toString().trim();
        s2 = e2.getText().toString().trim();
        s3 = e3.getText().toString().trim();
        s4 = e4.getText().toString().trim();
        s5 = e5.getText().toString().trim();
        s6 = e6.getText().toString().trim();
        s7 = e7.getText().toString().trim();
        s8 = e8.getText().toString().trim();
        s9 = e9.getText().toString().trim();
        s10 = e10.getText().toString().trim();


    }

    public void setValues() {
        b1 = (Button) findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty() || s8.isEmpty() || s9.isEmpty() || s10.isEmpty()) {
                    Toast.makeText(Main4Activity.this, "Fields are incomplete", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Main7Activity.class);
                    startActivity(intent);
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




    /*public void getValues()
    {
        nm = (EditText)findViewById(R.id.editText7);
        surname = (EditText)findViewById(R.id.editText8);
        flt = (EditText)findViewById(R.id.editText9);
        street = (EditText)findViewById(R.id.editText10);
        locality = (EditText)findViewById(R.id.editText11);
        city = (EditText)findViewById(R.id.editText12);
        state = (EditText)findViewById(R.id.editText15);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView2);

        b1 =  (Button)findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nm == null || surname == null || flt == null || street == null || locality == null || city == null || state == null)
                {
                    Toast.makeText(Main4Activity.this, "Fields are incomplete", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),Main5Activity.class);
                    startActivity(intent);
                }
            }
        });


    }*/



