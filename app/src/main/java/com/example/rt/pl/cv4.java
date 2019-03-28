package com.example.rt.pl;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class cv4 extends AppCompatActivity {

    DatabaseHelper1 db;
    DatabaseHelper3 db1;
    DatabaseHelper2 db2;
    Button b;
    Button b1;
    String cv;

    String fname, lname, fno, bno, street, locality, city, pcode,state,mno;
    String course, year, specialization, uni, cgpa, tenb,tenm,twelveb,twelvem,c1,c2,c3,c4,c5;
    String s1,s2,s3,s4,s5,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,p1,p2,p3;

    TextView t;

    private static final int Storage_code =1000 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv4);

        db = new DatabaseHelper1(cv4.this);
        db1 = new DatabaseHelper3(cv4.this);
        db2 = new DatabaseHelper2(cv4.this);
        viewAllData();
        t = (TextView)findViewById(R.id.tv);

        b1 = (Button)findViewById(R.id.save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED)
                    {
                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permissions, Storage_code);

                    }
                    else{
                        savepdf();
                    }
                }
                else
                {
                    savepdf();
                }
            }
        });



    }

    public void viewAllData(){
        b = (Button)findViewById(R.id.convert);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res0 = db.getAllData();
                Cursor res1 = db1.getAllData();
                Cursor res2 = db2.getAllData();
                if(res0.getCount() == 0 || res1.getCount() == 0 || res2.getCount() == 0)
                {
                    Toast.makeText(cv4.this, "NO DATA", Toast.LENGTH_LONG).show();
                    //showMessage("Error", "Nothing Found");
                }
                else{
                    StringBuffer buffer1 = new StringBuffer();
                    StringBuffer buffer2 = new StringBuffer();
                    StringBuffer buffer3 = new StringBuffer();
                    StringBuffer buffer4 = new StringBuffer();
                    StringBuffer buffer5 = new StringBuffer();
                    StringBuffer buffer6 = new StringBuffer();
                    StringBuffer buffer7 = new StringBuffer();
                    StringBuffer buffer8 = new StringBuffer();
                    StringBuffer buffer9 = new StringBuffer();
                    StringBuffer buffer10 = new StringBuffer();
                    res0.moveToPosition(0);

                    fname = buffer1.append(""+res0.getString(1)).toString();
                    lname = buffer2.append(""+res0.getString(2)).toString();
                    fno = buffer3.append(""+res0.getString(3)).toString();
                    bno = buffer4.append(""+res0.getString(4)).toString();
                    street = buffer5.append(""+res0.getString(5)).toString();
                    locality = buffer6.append(""+res0.getString(6)).toString();
                    city = buffer7.append(""+res0.getString(7)).toString();
                    pcode = buffer8.append(""+res0.getString(8)).toString();
                    state = buffer9.append(""+res0.getString(9)).toString();
                    mno = buffer10.append(""+res0.getString(10)).toString();

                    res1.moveToPosition(0);
                    StringBuffer buffer11 = new StringBuffer();
                    StringBuffer buffer12 = new StringBuffer();
                    StringBuffer buffer13 = new StringBuffer();
                    StringBuffer buffer14 = new StringBuffer();
                    StringBuffer buffer15 = new StringBuffer();
                    StringBuffer buffer16 = new StringBuffer();
                    StringBuffer buffer17 = new StringBuffer();
                    StringBuffer buffer18 = new StringBuffer();
                    StringBuffer buffer19 = new StringBuffer();
                    StringBuffer buffer20 = new StringBuffer();
                    StringBuffer buffer21 = new StringBuffer();
                    StringBuffer buffer22 = new StringBuffer();
                    StringBuffer buffer23 = new StringBuffer();
                    StringBuffer buffer24 = new StringBuffer();

                    course = buffer11.append(""+res1.getString(1)).toString();
                    year = buffer12.append(""+res1.getString(2)).toString();
                    specialization = buffer13.append(""+res1.getString(3)).toString();
                    uni = buffer14.append(""+res1.getString(4)).toString();
                    cgpa = buffer15.append(""+res1.getString(5)).toString();
                    tenb = buffer16.append(""+res1.getString(6)).toString();
                    tenm = buffer17.append(""+res1.getString(7)).toString();
                    twelveb = buffer18.append(""+res1.getString(8)).toString();
                    twelvem = buffer19.append(""+res1.getString(9)).toString();
                    c1 = buffer20.append(""+res1.getString(10)).toString();
                    c2 = buffer21.append(""+res1.getString(11)).toString();
                    c3 = buffer22.append(""+res1.getString(12)).toString();
                    c4 = buffer23.append(""+res1.getString(13)).toString();
                    c5 = buffer24.append(""+res1.getString(14)).toString();

                    res2.moveToPosition(0);
                    StringBuffer buffer25 = new StringBuffer();
                    StringBuffer buffer26 = new StringBuffer();
                    StringBuffer buffer27 = new StringBuffer();
                    StringBuffer buffer28 = new StringBuffer();
                    StringBuffer buffer29 = new StringBuffer();
                    StringBuffer buffer30 = new StringBuffer();
                    StringBuffer buffer31 = new StringBuffer();
                    StringBuffer buffer32 = new StringBuffer();
                    StringBuffer buffer33 = new StringBuffer();
                    StringBuffer buffer34 = new StringBuffer();
                    StringBuffer buffer35 = new StringBuffer();
                    StringBuffer buffer36 = new StringBuffer();
                    StringBuffer buffer37 = new StringBuffer();
                    StringBuffer buffer38 = new StringBuffer();
                    StringBuffer buffer39 = new StringBuffer();
                    StringBuffer buffer40 = new StringBuffer();
                    StringBuffer buffer41 = new StringBuffer();
                    StringBuffer buffer42 = new StringBuffer();

                    s1 = buffer25.append(""+res2.getString(1)).toString();
                    s2 = buffer26.append(""+res2.getString(2)).toString();
                    s3 = buffer27.append(""+res2.getString(3)).toString();
                    s4 = buffer28.append(""+res2.getString(4)).toString();
                    s5 = buffer29.append(""+res2.getString(5)).toString();
                    h1 = buffer30.append(""+res2.getString(6)).toString();
                    h2 = buffer31.append(""+res2.getString(7)).toString();
                    h3 = buffer32.append(""+res2.getString(8)).toString();
                    h4 = buffer33.append(""+res2.getString(9)).toString();
                    h5 = buffer34.append(""+res2.getString(10)).toString();
                    h6 = buffer35.append(""+res2.getString(11)).toString();
                    h7 = buffer36.append(""+res2.getString(12)).toString();
                    h8 = buffer37.append(""+res2.getString(13)).toString();
                    h9 = buffer38.append(""+res2.getString(14)).toString();
                    h10 = buffer39.append(""+res2.getString(15)).toString();
                    p1 = buffer40.append(""+res2.getString(16)).toString();
                    p2 = buffer41.append(""+res2.getString(17)).toString();
                    p3 = buffer42.append(""+res2.getString(18)).toString();



                     cv =   "\n" +
                            fname+" "+lname+"\n" +
                            "\n" +
                            "CONTACT:\n"+
                            fno+", "+bno+"\n" +
                            street+" \n"+
                            locality+"\n"+
                            city+" - "+pcode+"\n"+
                            state+"\n"+
                            "phone:"+mno+"\n" +
                            "\n" +
                            "\n" +
                            "'Motivated young professionals with an exemplary academic record to progress with the "+specialization+" industry'"+
                            "\n"+
                            "\n"+
                            "Personal Profile:\n"+
                            "I am a "+year+" year "+course+" "+specialization+"student at "+uni+". I have developed excellent analytical and leadership skills \n"+
                            "through my degree. I am passionate and committed to giving something back to the community using the knowledge skills \n"+
                            "and experience gathered over the course of life so far. "+
                            "\n"+
                            "\n"+
                            "EDUCATION:\t\n"+
                            "\n"+
                            "Tenth grade Board : "+tenb+". Percentage : "+tenm+"\n"+
                            "Twelth grade Board : "+twelveb+". Percentage :"+twelvem+"\n"+
                            "Degree Course : "+course+". Year : "+year+". CGPA : "+cgpa+"\n"+
                            "Coding Languages known:"+c1+", "+c2+", "+c3+", "+c4+
                            "\n"+
                            "\n"+
                            "SKILLS:\n"+
                            "1. "+s1+"\n"+
                            "2. "+s2+"\n"+
                            "3. "+s3+"\n"+
                            "4. "+s4+"\n"+
                            "5. "+s5+"\n"+
                            "\n"+
                            "\n"+
                            "Interests/Hobbies\n"+
                            "1. "+h1+"\n"+
                            "2. "+h2+"\n"+
                            "3. "+h3+"\n"+
                            "4. "+h4+"\n"+
                            "5. "+h5+"\n"+
                            "\n"+
                            "\n"+
                            "Projects worked on\n"+
                            "1. "+p1+"\n"+
                            "1. "+p2+"\n"+
                            "1. "+p3+"\n";


                    SpannableStringBuilder builder = new SpannableStringBuilder();

                    String red = cv;
                    SpannableString redSpannable= new SpannableString(red);
                    redSpannable.setSpan(new ForegroundColorSpan(Color.WHITE), 0, red.length(), 0);
                    builder.append(redSpannable);

                    t.setText(builder, TextView.BufferType.SPANNABLE);



                            //t.setText(""+cv);






                }
            }
        });
    }

    private void savepdf() {
        Document doc = new Document();
        String filename = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
        String filepath = Environment.getExternalStorageDirectory() + "/" + filename + ".pdf";
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(filepath));
            doc.open();
            doc.add(new Paragraph(cv));
            doc.close();
            Toast.makeText(this,filename+".pdf\n is saved at "+ filepath,Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case Storage_code: {
                if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {
                    savepdf();
                }
                else
                {
                    Toast.makeText(this,    "permission denied!!!!!!",Toast.LENGTH_SHORT).show();

                }
            }
        }
    }



}
