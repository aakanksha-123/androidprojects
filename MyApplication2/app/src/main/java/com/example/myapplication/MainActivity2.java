package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    ArrayList<Question> ar;
    TextView tv;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
    Button b1,b2;
    int index=0;
    Question q;
    int count=0;
    int result=0;
    String ans="",ans1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv=findViewById(R.id.textView);

        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);

        rg=findViewById(R.id.rr);
        rg.setOnCheckedChangeListener(this);

        rg.clearCheck();
        b1=findViewById(R.id.button2);

        b2=findViewById(R.id.button3);
        b2.setEnabled(false);
        b2.setOnClickListener(this);
        b1.setOnClickListener(this);

        ar = new ArrayList<>();

        //method 1
        Question q1 = new Question( "Who is the father of C language?","Steve Jobs","James Gosling","Dennis Ritchie","Rasmus Lerdorf","C");
        ar.add(q1);
        Question q2 = new Question("Which of the following is not a valid C variable name?"," int number;","float rate;","int variable_count;","int $main;","D");
        ar.add(q2);
        Question q3 = new Question(" All keywords in C are in ____________","LowerCase letters","UpperCase letters","CamelCase letters","None of the mentioned","A");
        ar.add(q3);
        Question q4 = new Question("Which is valid C expression?","int my_num = 100,000;"," int my_num = 100000;","int my num = 1000;","int $my_num = 10000;","B");
        ar.add(q4);
        Question q5 = new Question("Which of the following cannot be a variable name in C?","true","friend","export","volatile","D");
        ar.add(q5);
        Question q6 = new Question("Which of the following declaration is not supported by C language?","String str;","char *str;","float str = 3e2;","Both String str; & float str = 3e2;","A");
        ar.add(q6);
        Question q7 = new Question("Which keyword is used to prevent any changes in the variable within a C program?","immutable","mutable","const","volatile","C");
        ar.add(q7);
        Question q8 = new Question("What is the result of logical or relational expression in C?","True or False","0 0r 1","0 if an expression is false and any positive number if an expression is true","tNone of the mentioned","B");
        ar.add(q8);
        Question q9 = new Question("What is an example of iteration in C?","for","while","do-while","all of the mentioned","D");
        ar.add(q9);
        Question q10 = new Question("The C-preprocessors are specified with _________symbol.","#","$"," ","&","A");
        ar.add(q10);


         //method2
        /*Question q2=new Question();
        q2.setQuestion("What is c ?");
        q2.setA("language");
        q2.setB("hardware");
        q2.setC("data");
        q2.setD("year");
        q2.setAns("A");
        ar.add(q2); */

        //show first question
       show();

    }

    void show(){
            q=ar.get(index);
            tv.setText(q.getQuestion());
            rb1.setText(q.getA());
            rb2.setText(q.getB());
            rb3.setText(q.getC());
            rb4.setText(q.getD());
            ans=q.getAns();
        rg.clearCheck();
            index++;
        if(index>9){
        //b1.setVisibility(View.INVISIBLE);
            b1.setEnabled(false);
           // b2.setVisibility(View.VISIBLE);
            b2.setEnabled(true);
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button2:

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

                if(q.getAns().equals(ans1)){
                    count++;
                   //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                }
                show();
                break;

            case R.id.button3:
                Intent it=new Intent(this,MainActivity3.class);
                Toast.makeText(this, "Finish", Toast.LENGTH_SHORT).show();
                it.putExtra("count",count);
                //tv.setText("End test");
                startActivity(it);
                //Toast.makeText(this, "Finish", Toast.LENGTH_SHORT).show();

                    break;

        }

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}




