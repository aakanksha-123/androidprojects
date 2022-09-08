package com.example.quizeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity implements View.OnClickListener {
    EditText et_email, et_pass;
    Button btn_login,btn_register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        et_email = findViewById(R.id.e1);
        et_pass = findViewById(R.id.e2);

        btn_login = findViewById(R.id.b1);
        btn_register=findViewById(R.id.bb);

        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    void login() {

        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(AdminLogin.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(AdminLogin.this, MainActivity.class);
                    startActivity(it);
                } else {
                    Toast.makeText(AdminLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void register() {

        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();

        Toast.makeText(AdminLogin.this, email+"->"+pass, Toast.LENGTH_SHORT).show();

        try{

            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(AdminLogin.this, "User Created Successed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AdminLogin.this, "User Created Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        catch (Exception e){
            Toast.makeText(AdminLogin.this, "Exception "+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.b1:

              //  login();
               Intent it = new Intent(this, ACT_AddQuestion.class);
                startActivity(it);
                break;

            case R.id.bb:
                register();
                break;
        }
    }
}