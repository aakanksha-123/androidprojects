package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    TextView tv;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        rb=findViewById(R.id.ratingBar2);
        rb.setOnRatingBarChangeListener(this);
        rb.setNumStars(5);
        rb.setRating(4.5f);


    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        tv.setText(b+" "+v);
    }
}