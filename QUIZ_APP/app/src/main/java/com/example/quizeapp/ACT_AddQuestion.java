package com.example.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ACT_AddQuestion extends AppCompatActivity implements View.OnClickListener {
EditText et0,et1,et2,et3,et4,et5,et6;
Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_add_question);
        et0=findViewById(R.id.ed0);
        et1=findViewById(R.id.ed1);
        et2=findViewById(R.id.ed2);
        et3=findViewById(R.id.ed3);
        et4=findViewById(R.id.ed4);
        et5=findViewById(R.id.ed5);
        et6=findViewById(R.id.ed6);


        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       saveData();
    }

    void saveData(){                     //save button
       String id1=et0.getText().toString();
        String que1=et1.getText().toString();
        String A1=et2.getText().toString();
        String B1=et3.getText().toString();
        String C1=et4.getText().toString();
        String D1=et5.getText().toString();
        String Ans1=et6.getText().toString();


        Question ob=new Question(id1,que1,A1,B1,C1,D1,Ans1);  //id1
      

        // Write a data to the database

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quizedatabase-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Question");

        //String key=myRef.push().getKey();

        myRef.child(id1).setValue(ob);
        Toast.makeText(ACT_AddQuestion.this, "Value saved", Toast.LENGTH_SHORT).show();

    }
}