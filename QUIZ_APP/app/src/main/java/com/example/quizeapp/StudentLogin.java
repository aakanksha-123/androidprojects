package com.example.quizeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener {
    EditText et_email, et_pass;
    Button btn_login, btn_register;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        et_email = findViewById(R.id.e1);
        et_pass = findViewById(R.id.e2);

        btn_login = findViewById(R.id.b1);
        btn_register = findViewById(R.id.b2);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);


        mAuth = FirebaseAuth.getInstance();
        //retrieveData();
    }



    void register() {

        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(StudentLogin.this, "User Created Successed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StudentLogin.this, "User Created Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    void login() {

        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(StudentLogin.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent it=new Intent(StudentLogin.this,MainActivity.class);
                    startActivity(it);
                } else {
                    Toast.makeText(StudentLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.b1:
                //login();
                Intent it=new Intent(StudentLogin.this,StartQuize.class);
                startActivity(it);
                break;

            case R.id.b2:
                register();
                break;
        }
    }



    void retrieveData(){                 //select button

       // String id=e1.getText().toString();
        //Toast.makeText(StartQuize.this, "id="+id, Toast.LENGTH_LONG).show();

        TEST.ar=new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quizedatabase-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Question");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot sn : dataSnapshot.getChildren()) {

                    Question ob = sn.getValue(Question.class);
                    TEST.ar.add(ob);
                    //Toast.makeText(StartQuize.this, "arraylist size is "+ar.size(), Toast.LENGTH_SHORT).show();
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

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
        Toast.makeText(StudentLogin.this, "arraylist size is "+TEST.ar.size(), Toast.LENGTH_SHORT).show();
        //displayData();
    }
}