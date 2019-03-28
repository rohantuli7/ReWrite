package com.example.rt.pl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1;
    private FirebaseAuth mAuth;
    private static final String TAG = "RegisterActivity";


    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    private ProgressDialog progressDialog;

    String s1,s2, s3, s4, s5, s6, s7;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1 = (EditText)findViewById(R.id.firstname);
        e2 = (EditText)findViewById(R.id.lastname);
        e3 = (EditText)findViewById(R.id.username);
        e4 = (EditText)findViewById(R.id.phone);
        e5 = (EditText)findViewById(R.id.email);
        e6 = (EditText)findViewById(R.id.password);
        e7 = (EditText)findViewById(R.id.password1);
        b1 = (Button)findViewById(R.id.b);




        CheckValuesOfUser();
        mAuth = FirebaseAuth.getInstance();
    }

    /*boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }*/





    /*@Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }*/

    void CheckValuesOfUser()
    {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();
                s6 = e6.getText().toString();

                Boolean bool;
                //bool = isEmailValid(s1);
                int y = 0;
                int x = s2.length();
                int count = 0;
                /*if(e1 == null)
                {
                    count++;
                }
                if(e2 == null)
                {
                    count++;
                }
                if(bool == false)
                {
                    count++;
                }
                if(x!=10)
                {
                    count++;
                }*/
                //if (count == 0)
                //{
                    //progressDialog.setMessage("Registering user");
                    //progressDialog.show();
                   if(!TextUtils.isEmpty(s5) && !TextUtils.isEmpty(s6)){
                        mAuth.createUserWithEmailAndPassword(s5, s6).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    databaseReference = FirebaseDatabase.getInstance().getReference("users");
                                    user = mAuth.getCurrentUser();
                                    String id = user.getUid();
                                    DB db = new DB(id, s1, s2, s3, s4, s5, s6);
                                    databaseReference.child(id).setValue(db);
                                    mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                        }


                                });
                       nextActivity();


                                   }
                            else {
                                        String errormessage = task.getException().getMessage();
                                        Toast.makeText(Main2Activity.this, errormessage, Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }

                //}
                else
                {
                    Toast.makeText(Main2Activity.this,"Incomplete Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void nextActivity()
    {
        Toast.makeText(Main2Activity.this, "Success", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}