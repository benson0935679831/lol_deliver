package com.example.lol_deliver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class SKModifyInfo extends AppCompatActivity {

    EditText Name, Phone ,Address;
    EditText Mon, Tue, Wed, Thur, Fri, Sat, Sun;
    private DatabaseReference mDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sk_modify_info);
//        getSupportActionBar().hide();

        Name = (EditText) findViewById(R.id.et_sk_shopName);
        Phone = (EditText) findViewById(R.id.et_sk_phone);
        Address = (EditText) findViewById(R.id.et_sk_address);
        Mon = (EditText) findViewById(R.id.et_sk_timeMon);
        Tue = (EditText) findViewById(R.id.et_sk_timeTue);
        Wed = (EditText) findViewById(R.id.et_sk_timeWed);
        Thur = (EditText) findViewById(R.id.et_sk_timeThur);
        Fri = (EditText) findViewById(R.id.et_sk_timeFri);
        Sat = (EditText) findViewById(R.id.et_sk_timeSat);
        Sun = (EditText) findViewById(R.id.et_sk_timeSun);

        loadInfo("name", Name);
        loadInfo("phone", Phone);
        loadInfo("address", Address);
        loadInfo("Mon", Mon);
        loadInfo("Tue", Tue);
        loadInfo("Wed", Wed);
        loadInfo("Thur", Thur);
        loadInfo("Fri", Fri);
        loadInfo("Sat", Sat);
        loadInfo("Sun", Sun);
    }

    public void loadInfo(String tag, EditText et){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("shops").child("JhuJian").child(tag).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String res = snapshot.getValue(String.class);
                        et.setText(res);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    public void ModifyInfo(View view){
        String name = Name.getText().toString();
        String phone = Phone.getText().toString();
        String address = Address.getText().toString();
        String mon = Mon.getText().toString();
        String tue = Tue.getText().toString();
        String wed = Wed.getText().toString();
        String thur = Thur.getText().toString();
        String fri = Fri.getText().toString();
        String sat = Sat.getText().toString();
        String sun = Sun.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference shopRef = firebaseDatabase.getReference("shops/JhuJian");
        Map<String, Object> shopInfo = new HashMap<>();
        shopInfo.put("name", name);
        shopInfo.put("phone", phone);
        shopInfo.put("address", address);
        shopInfo.put("Mon", mon);
        shopInfo.put("Tue", tue);
        shopInfo.put("Wed", wed);
        shopInfo.put("Thur", thur);
        shopInfo.put("Fri", fri);
        shopInfo.put("Sat", sat);
        shopInfo.put("Sun", sun);
        shopRef.updateChildren(shopInfo);

        Intent intent = new Intent(this, ShopkeeperHomepage.class);
        startActivity(intent);
    }

    public void Cancel(View view){
        finish();
    }
}