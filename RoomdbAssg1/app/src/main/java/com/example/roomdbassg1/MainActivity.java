package com.example.roomdbassg1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button b1;
EditText e1,e2;
AppDatabase app;
UserDao userdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button2);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        RoomDatabase.Builder b = Room.databaseBuilder(this, AppDatabase.class, "db13");
        b.allowMainThreadQueries();
        app = (AppDatabase) b.build();
        userdao = app.getUserDao();
        b1.setOnClickListener(this);


    }



public void ADD(){
         //Student st = new Student();
    //insert
   // Student st = new Student();
   // st.id = 300;
   // st.name = "qqq";
   // userdao.addAll(st);
  ///  tv.setText("Record inserted !!");

        int s1 = Integer.parseInt(e1.getText().toString());
        String s2 =e2.getText().toString();
    Student st = new Student();
     st.id = s1;
     st.name = s2;
     userdao.addAll(st);


}
    @Override
    public void onClick(View v) {
        ADD();

    }


}