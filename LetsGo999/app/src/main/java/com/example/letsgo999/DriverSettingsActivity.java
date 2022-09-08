package com.example.letsgo999;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DriverSettingsActivity extends AppCompatActivity {

    private TextView mNameField, mPhoneField;
    private EditText mCarField;

    private ImageView mProfileImage;

    private FirebaseAuth mDriverAuth;
    private DatabaseReference mDriverDatabase;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user;

    private String mService;

    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_settings);

        mNameField = (TextView) findViewById(R.id.driverName);
        mPhoneField = (TextView) findViewById(R.id.driverPhone);

        mCarField = (EditText) findViewById(R.id.driverCar);

        mProfileImage = (ImageView) findViewById(R.id.driverPofileImage);

        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        Button mBack = (Button) findViewById(R.id.driverSettingsBack);
        Button mSave = (Button) findViewById(R.id.driverSettingsSave);

        mDriverAuth = FirebaseAuth.getInstance();
        user = mDriverAuth.getCurrentUser();
        String userID = Objects.requireNonNull(mDriverAuth.getCurrentUser()).getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mDriverDatabase = firebaseDatabase.getReference("RideUsers").child("Drivers").child(userID);

        if (user.getUid().equals(userID)) {
            //Query query = mDriverDatabase.orderByChild("uid").equalTo(user.getUid());
            mDriverDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists() && snapshot.getChildrenCount() > 0) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                        if(map.get("name") != null){
                            String name = map.get("name").toString();
                            mNameField.setText(name);
                        }

                        if(map.get("phone") != null){
                            String phone = map.get("phone").toString();
                            mPhoneField.setText(phone);
                        }

                        if(map.get("car") != null){
                            String car = map.get("car").toString();
                            mCarField.setText(car);
                        }

                        if(map.get("service") != null){
                            String service = map.get("service").toString();
                            switch (service){
                                case"Ride Mini":
                                    mRadioGroup.check(R.id.UberX);
                                    break;
                                case"Ride - X":
                                    mRadioGroup.check(R.id.UberBlack);
                                    break;
                                case"Ride - Prime":
                                    mRadioGroup.check(R.id.UberXl);
                                    break;
                            }
                        }

                        if(map.get("image") != null){
                            String imageUrl = map.get("image").toString();
                            try {
                                    Picasso.get().load(imageUrl).into(mProfileImage);
                            }
                            catch (Exception e) {
                                    Picasso.get().load(R.mipmap.ic_default_user).into(mProfileImage);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mCar = mCarField.getText().toString();

                int selectId = mRadioGroup.getCheckedRadioButtonId();

                final RadioButton radioButton = (RadioButton) findViewById(selectId);

                if (radioButton.getText() == null) {
                    return;
                }

                mService = radioButton.getText().toString();

                Map userInfo = new HashMap();
                userInfo.put("car", mCar);
                userInfo.put("service", mService);
                mDriverDatabase.updateChildren(userInfo).addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Intent saveIntent = new Intent(DriverSettingsActivity.this, DriverMapActivity.class);
                            saveIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(saveIntent);
                            finish();
                            Toast.makeText(DriverSettingsActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String message = Objects.requireNonNull(task.getException()).getMessage();
                            Toast.makeText(DriverSettingsActivity.this,""+message,Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DriverSettingsActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(DriverSettingsActivity.this, DriverMapActivity.class);
                mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(mapIntent);
                finish();
            }
        });
    }
}