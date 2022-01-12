package com.example.roomdb_4button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText e1,e2;
Button b1,b2,b3,b4;
StudentDao st;
   // private RoomDatabase.Builder RoomDatabseBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button3);
        b3 = findViewById(R.id.button4);
        b4 = findViewById(R.id.button5);
        b1.setOnClickListener(this::onClick);
        b2.setOnClickListener(this::onClick);
        b3.setOnClickListener(this::onClick);
        b4.setOnClickListener(this::onClick);

        RoomDatabase.Builder builder;
        builder = Room.databaseBuilder(this, AppdataBase.class, "Mydb12");
        builder.allowMainThreadQueries();
        AppdataBase db = (AppdataBase) builder.build();
        st = db.StudentDao();
    }


    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.button2:
                save();
                break;
            case R.id.button3:
                select();
                break;
            case R.id.button4:
                update();
                break;
            case R.id.button5:
                delete();
                break;

        }
    }
        public void save(){
            int id=Integer.parseInt(e1.getText().toString());
            String n = e2.getText().toString();
            Student st1 = new Student();
            st1.id=id;
            st1.name=n;
            st.addAll(st1);
            Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
        }

       public void select(){
            int id = Integer.parseInt(e1.getText().toString());
            Student st1;
            st1=st.getStudent(id);
            if(st1!=null){
                e2.setText(st1.name);

            }else{
                Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
            }
        }

        public void update(){
            int id=Integer.parseInt(e1.getText().toString());
            String n = e2.getText().toString();
            Student st1 = new Student();
            st1.id=id;
            st1.name=n;
            st.updateAll(st1);
            Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
        }

        public void delete(){
            int id = Integer.parseInt(e1.getText().toString());
            Student st1 = new Student();
            st1.id=id;

            st.deleteAll(st1);
            Toast.makeText(this, "Record is deleted", Toast.LENGTH_SHORT).show();

        }

    }
