package com.example.friendfinderapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,LocationListener{
EditText e0,e1,e2;
Button b1,b2;

LocationManager locationManager;
    String lat,lng;
   
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e0=findViewById(R.id.ed0);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(this);
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        //   String[] arr = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
        // requestPermissions(arr, 123);

        //register locationManager with LocationListner to get updates for location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //  return;
            String[] arr = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(arr, 123);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1000,  this);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1000,  this);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button:
                saveData();
                break;

            case R.id.button2:
                retrieveData();
                //show map
                Intent it = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(it);
                break;
        }
    }

   @Override
   public void onLocationChanged(@NonNull Location location) {
        double lat,lng;

       lat=location.getLatitude();
        lng=location.getLongitude();
     // e1.setText(" "+lat);
     // e2.setText(" "+lng);
       TEST.lat = lat;
       TEST.lng = lng;
       Toast.makeText(MainActivity.this, "Got Location", Toast.LENGTH_SHORT).show();
    }


    void saveData(){                     //save button

       String lat=e1.getText().toString();  //lat
     String lng=e2.getText().toString();  //lng
     String id=e0.getText().toString();  //id
    // String id="1";


        location ob=new location();
        ob.setId(id);
        ob.setLat(lat);
        ob.setLng(lng);

        // Write a data to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Location");

        myRef.child(id).setValue(ob);
        Toast.makeText(MainActivity.this, "Value saved", Toast.LENGTH_SHORT).show();


    }

    void retrieveData(){                 //select button

        String id=e0.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Location");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot sn : dataSnapshot.getChildren()) {

                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);

                    location ob=sn.getValue(location.class);

                    if(ob.getId().equals(id)){
                        e1.setText(ob.getLat());
                        e2.setText(ob.getLng());
                    }

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
    }
}

