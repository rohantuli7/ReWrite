package com.example.rt.pl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    public int slide_images[] = {
            R.drawable.cv,
            R.drawable.letter_2,
            R.drawable.sop
    };

    public String slide_headings [] = {
            "Curriculum Vitae",
            "Inquiry Letter",
            "Statement of Purpose"

    };

    public String slide_descs[] = {
            "A curriculum vitae is a written overview of a person's experience and other qualifications for a job opportunity",
            "A job inquiry letter, also known as a prospecting letter or letter of interest, is sent to companies that may be hiring but haven't advertised job openings.",
            "An admissions or application essay, sometimes also called a personal statement or a statement of purpose, is an essay or other written statement written by an applicant, often a prospective student applying to some college or university."


    };





    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout)o;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideheading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideheading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);


    }
}
