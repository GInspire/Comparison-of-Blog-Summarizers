package com.example.anubha.minorproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    EditText e1,e3;
    TextView e2;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView tv= (TextView) findViewById(R.id.textView);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                               "a.otf");
        tv.setTypeface(tf1);
        Typeface tf2 = Typeface.createFromAsset(getAssets(),
                "font2.ttf");

        e1= (EditText) findViewById(R.id.edittext);
        e2= (TextView) findViewById(R.id.EditText);
        e3= (EditText) findViewById(R.id.edittext2);
        e1.setText(R.string.main_summary);
        e1.setTypeface(tf2);
        e2.setText("LSA");
        e2.setTypeface(tf1);
        e3.setText(R.string.LSA);
        e3.setTypeface(tf2);
    }

    public void next(View v)
    {

        ++counter;
        switch(counter)
        {
            case 1:e2.setText("KLSUM");
                   e3.setText(R.string.KLSUM);
                   break;
            case 2:e2.setText("TEXTRANK");
                e3.setText(R.string.TEXTRANK);
                break;
            case 3:e2.setText("LEXRANK");
                e3.setText(R.string.LEXRANK);
                break;
            case 4:e2.setText("LUHN");
                e3.setText(R.string.LUHN);
                break;
            default:startActivity(new Intent(this,Main5Activity.class));
        }
    }
}
