package com.example.rt.pl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    Button b1;
    Button b2;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getValues();
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.signin);

        final SpannableStringBuilder span = new SpannableStringBuilder("Not a Member yet? Sign Up");
        final StyleSpan spanbss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        final StyleSpan spaniss = new StyleSpan(android.graphics.Typeface.ITALIC); //Span to make text italic
        span.setSpan(spanbss, 18, 25, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first 4 characters Bold
        span.setSpan(spaniss, 18, 25, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 2 characters Italic
        b2.setText(span);




        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null)
                {
                    Intent intent = new Intent(getApplicationContext(),Main6Activity.class);
                    startActivity(intent);
                    ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Loading");
                    progressDialog.setMessage("Signing in");
                    progressDialog.show();
                    //startActivity(new Intent(MainActivity.this,Main6Activity.class));
                }
            }
        };
        onclicker();


        //Check();







    }

    private void onclicker() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed1.getText().toString();
                String password = ed2.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
                }
                else {
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Sign in Error", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent1);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    public void getValues()
    {


        //tv = (TextView)findViewById(R.id.textView);
    }

    /*public void nextPage()
    {
        String email = ed1.getText().toString();
        String password = ed2.getText().toString();
        if(email.equals("rohann.tulii@gmail.com") && password.equals("123456"))
        {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),Main6Activity.class);
                    startActivity(intent);

                }
            });
        }
    }*/



    /*public void Check()
    {
        final String s1 = ed1.getText().toString().trim();
        final String s2 = ed2.getText().toString().trim();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
                {

                }
                else
                {
                    mAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this,"Wrong Credentials/Not Registered",Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }


                if( !TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) ){
                    Toast.makeText(MainActivity.this,"Username & Password are correct"+ed1.getText().toString(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Main6Activity.class);
                    startActivity(intent);
                }
                else if(ed1 == null || ed2 == null)
                {
                    Toast.makeText(MainActivity.this, "Fields are incomplete" , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Username & Password are incorrect",Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent1);
            }
        });


    }*/

    /*@Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }*/
}
