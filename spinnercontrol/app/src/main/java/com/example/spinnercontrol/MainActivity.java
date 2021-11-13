package com.example.spinnercontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button b1;
    TextView tv;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b1.setOnClickListener(this);
        tv=findViewById(R.id.textView);

        sp=findViewById(R.id.spinner);
        String[] arr = {"Hindi","Marathi","English"};
        ArrayAdapter<String> ad;
        ad = new ArrayAdapter<> (MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arr);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(this);
    }
   void check(){
       String s1;
       s1 = sp.getSelectedItem().toString();
       int i=sp.getSelectedItemPosition();
       tv.setText(s1+" "+i);
   }



    @Override
    public void onClick(View v) {
        /*String s1;
        s1 = sp.getSelectedItem().toString();
        int i=sp.getSelectedItemPosition();
        tv.setText(s1+" "+i);  */
        check();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
      /*  TextView tv;
        tv = (TextView) view;
        String s2 = tv.getText().toString();
        tv.setText(s2+" "+i);  */
        check();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}