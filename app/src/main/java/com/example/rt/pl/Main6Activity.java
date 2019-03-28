package com.example.rt.pl;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main6Activity extends AppCompatActivity {

    private ViewPager mslideviewPager;
    private LinearLayout mdotlayout;

    private TextView[] mdots;

    private SliderAdapter sliderAdapter;
    private Button b;
    private int mCurrentPage;
    Button b2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        mslideviewPager = (ViewPager) findViewById(R.id.SlideViewPager);
        mdotlayout = (LinearLayout) findViewById(R.id.dotsLayout);
        b = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.button4) ;

        sliderAdapter = new SliderAdapter(this);
        mslideviewPager.setAdapter(sliderAdapter);

        adddotsindicator(0);

        mslideviewPager.addOnPageChangeListener(viewlistener);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();








    }

    public void adddotsindicator(int position){
        mdots = new TextView[3];
        mdotlayout.removeAllViews();

        for(int i = 0; i < mdots.length; i++)
        {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mdotlayout.addView(mdots[i]);
        }

        if (mdots.length > 0){
            mdots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }


    }

    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            adddotsindicator(i);
            mCurrentPage = i;
            int x;

            if (i == 0)
            {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Main8Activity.class);
                        startActivity(intent);

                    }
                });
            }
            else if (i == 1)
            {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Main7Activity.class);
                        startActivity(intent);

                    }
                });
            }
            else if (i == 2)
            {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),Main9Activity.class);
                        startActivity(intent);
                    }
                });
            }

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }
            });

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
