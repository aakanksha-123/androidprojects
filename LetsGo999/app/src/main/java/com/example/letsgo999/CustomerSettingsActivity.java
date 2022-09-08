package com.example.letsgo999;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;
import java.util.Objects;

public class CustomerSettingsActivity extends AppCompatActivity {

    private TextView mNameField, mPhoneField;

    private ImageView mProfileImage;

    private FirebaseAuth mCustomerAuth;
    private DatabaseReference mCustomerDatabase;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_settings);

        mNameField = (TextView) findViewById(R.id.customerName);
        mPhoneField = (TextView) findViewById(R.id.customerPhone);

        mProfileImage = (ImageView) findViewById(R.id.customerPofileImage);

        Button mBack = (Button) findViewById(R.id.customerSettingsBack);

        mCustomerAuth = FirebaseAuth.getInstance();
        user = mCustomerAuth.getCurrentUser();
        String userID = Objects.requireNonNull(mCustomerAuth.getCurrentUser()).getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mCustomerDatabase = firebaseDatabase.getReference("RideUsers").child("Customers").child(userID);

        if (user.getUid().equals(userID)) {
            //Query query = mCustomerDatabase.orderByChild("uid").equalTo(user.getUid());
            mCustomerDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists() && snapshot.getChildrenCount() > 0) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                        assert map != null;
                        if(map.get("name") != null){
                            String name = map.get("name").toString();
                            mNameField.setText(name);
                        }

                        if(map.get("phone") != null){
                            String phone = map.get("phone").toString();
                            mPhoneField.setText(phone);
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


        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}