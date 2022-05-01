package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartQuize extends AppCompatActivity implements
        View.OnClickListener,RadioGroup.OnCheckedChangeListener {
    TextView tv,tv2;
    RadioGroup rg;

    RadioButton rb1,rb2,rb3,rb4;
    Button b1,b2;
    Question q;
    String ans="",ans1="";
    int count=0;
    int index=0;

 //   LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quize);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);

        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);

        rg=findViewById(R.id.rr);
        rg.setOnCheckedChangeListener(this);

        rg.clearCheck();
        b1=findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.button3);
        b2.setOnClickListener(this);

        TEST.ar=new ArrayList<>();
        retrieveData();

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button2:
                //retrieveData();
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        ans1="A";
                        //Toast.makeText(this, "Option A is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        ans1="B";
                        //Toast.makeText(this, "Option B is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        ans1="C";
                        //Toast.makeText(this, "Option C is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton4:
                        ans1="D";
                        //Toast.makeText(this, "Option D is selected", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (q.getOp5().equals(ans1)) {
                    count++;
                    tv2.setText("Score:" + count);
                }
                displayData();
                break;

            case R.id.button3:
                if(index==5){
                    count++;
                    tv2.setText("Score:" + count);
                }
                Intent it = new Intent(this, ResultDisplay.class);
                Toast.makeText(this, "Finish", Toast.LENGTH_SHORT).show();
                it.putExtra("count", count);
                //tv.setText("End test");
                startActivity(it);
                break;
        }

    }

    void retrieveData(){                 //select button

       // String id=e1.getText().toString();
        //Toast.makeText(StartQuize.this, "id="+id, Toast.LENGTH_LONG).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quizedatabase-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Question");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot sn : dataSnapshot.getChildren()) {

                    Question ob = sn.getValue(Question.class);
                    TEST.ar.add(ob);
                    //Toast.makeText(StartQuize.this, "arraylist size is "+TEST.ar.size(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(StartQuize.this, "id is "+ob.getId(), Toast.LENGTH_SHORT).show();
//                    if(ob.getId().equals(id)){
//                        tv.setText(ob.getQue());
//                        rb1.setText(ob.getOp1());
//                        rb2.setText(ob.getOp2());
//                        rb3.setText(ob.getOp3());
//                        rb4.setText(ob.getOp4());
//                    }

                    //Log.d("TAG", "Value is: " + value);
                    //Toast.makeText(MainActivity.this, "Value is: " + value, Toast.LENGTH_SHORT).show();
                }
                displayData();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });


    }


public void displayData() {
    //Toast.makeText(StartQuize.this, "arraylist size is " + TEST.ar.size(), Toast.LENGTH_SHORT).show();
    q = TEST.ar.get(index);
    tv.setText(q.getQue());
    rb1.setText(q.getOp1());
    rb2.setText(q.getOp2());
    rb3.setText(q.getOp3());
    rb4.setText(q.getOp4());

    ans = q.getOp5();
    rg.clearCheck();
    index++;
    if (index > 4) {
        //b1.setVisibility(View.INVISIBLE);
        b1.setEnabled(false);
        // b2.setVisibility(View.VISIBLE);
        b2.setEnabled(true);
        //ans=q.getOp5();

    }


}


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}