package com.example.forwardandreversegeocoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {
    EditText ed1, ed2;
    String TAG = "MainActivity";
    Button b;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "After setting main xml file");
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        b = findViewById(R.id.button);
        b.setOnClickListener(this);
        Log.i(TAG, "on msg end");


        //get the referance of LocationManager by using getSystem()
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //check that permission is allowed or not
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
           // return;
            String[] arr = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(arr, 123);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1000, this);
    }

    void  reverseGecoding(Location location){
        double lat,lng;
        lat=location.getLatitude();
        lng=location.getLongitude();
        //get geocoder object
        Geocoder geocoder = new Geocoder(this);
        try {
            List<Address> addresses;
            addresses = geocoder.getFromLocation(lat, lng, 0);
            Address ad = addresses.get(0);
            String s1 = " ";
            //s1+=ad.getAddress.get(0)
            //st+=ad.getLocality();
            StringBuffer sb = new StringBuffer();
            sb.append(ad.getAddressLine(0));
            sb.append(ad.getLocality());
            sb.append(ad.getCountryName());
            sb.append(ad.getPostalCode());
            ed1.setText(" " + sb);
        }catch (IOException e){
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();

        }

        }

        void forwardGeocoding(){
        String addr = ed1.getText().toString();
        double lat,lng;
        //get Geocoder object

            Geocoder geocoder = new Geocoder(this);
            try{
                List<Address> addresses;
                addresses=geocoder.getFromLocationName(addr,10);
                Address ad =addresses.get(0);
                String s1=" ";
                //s1+=ad.getAddressLine(0);
                //s1+=ad.getLocality(0);
                StringBuffer sb = new StringBuffer();
                lat=ad.getLatitude();
                lng=ad.getLongitude();
                sb.append(" "+lat);
                sb.append(" "+lng);
                ed2.setText(" "+sb);

            }catch (IOException e){
                Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }
        }
    @Override
    public void onLocationChanged(@NonNull Location location) {
       reverseGecoding(location);
    }

    @Override
    public void onClick(View v) {
      forwardGeocoding();
    }
}