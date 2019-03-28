package com.example.rt.pl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cv_input extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_input);
        getvalues();
        setValues();

    }

    public void getvalues()
    {
        e1 = (EditText) findViewById(R.id.sal);
        e2 = (EditText) findViewById(R.id.rn);
        e3 = (EditText) findViewById(R.id.fn3);
        e4 = (EditText) findViewById(R.id.bn2);
        e5 = (EditText) findViewById(R.id.st2);
        e6 = (EditText) findViewById(R.id.loc2);
        e7 = (EditText) findViewById(R.id.city2);
        e8 = (EditText) findViewById(R.id.pin2);
        e9 = (EditText) findViewById(R.id.state2);
    }

    public void setValues()
    {
        b1 = (Button) findViewById(R.id.button100);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.equals(null) || e2.equals(null) || e4.equals(null) || e5.equals(null) || e6.equals(null) || e7.equals(null) || e8.equals(null) || e9.equals(null))
                {
                    Toast.makeText(cv_input.this,"Incomplete Fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    //Intent intent1 = new Intent(getApplicationContext(),fl_page3.class);
                    //startActivity(intent1);
                }
            }
        });
    }
}
