package com.example.roomdatabase2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    TextView tv;
    AppDatabase app;
    UserDao userdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        tv=findViewById(R.id.textView2);
        RoomDatabase.Builder b = Room.databaseBuilder(this,AppDatabase.class, "db12");

        b.allowMainThreadQueries();
        app = (AppDatabase)b.build();
        userdao = app.getUserDao();
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            //insert
           // Student st = new Student();
           // st.id = 500;
           // st.name = "sss";
           // userdao.addAll(st);
          //  tv.setText("Record inserted !!");
            //Update
           // Student st = new Student();
            //  st.id = 500;
            // st.name = "ttt";
           // userdao.updateAll(st);
           //   tv.setText("Record updated !!");
            Student st = new Student();
            st.id = 500;
            st.name = "ttt";
            userdao.deleteAll(st);
            tv.setText("Record deleted !!");



        }catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }

    }
}