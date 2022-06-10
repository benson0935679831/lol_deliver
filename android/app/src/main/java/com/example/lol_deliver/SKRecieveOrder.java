package com.example.lol_deliver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.activity.MainActivity;
import com.example.lol_deliver.item.FoodItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SKRecieveOrder extends AppCompatActivity {

    private DatabaseReference mDataBase;
    private String orderId;
    private ArrayList<String> mealList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sk_recieve_order);
        Intent intent = getIntent();
        orderId = intent.getExtras().getString("orderId");

        mDataBase = FirebaseDatabase.getInstance().getReference().child("orders").child(orderId);
        mDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.child("meal").getChildren()){
                    String meal =  snapshot.getKey() + "  " + snapshot.getValue().toString() + "份";
                    mealList.add(meal);
                }
                Log.d("adder", mealList.toString());

                TextView tv_mealList = (TextView) findViewById(R.id.tv_sk_recieve_mealdetail);
                TextView tv_price = (TextView) findViewById(R.id.tv_sk_recieve_pricedetail);
                tv_mealList.setText(mealList.toString());
                tv_price.setText(dataSnapshot.child("price").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Ok(View view) {
        Toast.makeText(this, "接單成功！", Toast.LENGTH_SHORT);
        setContentView(R.layout.acitivity_shopkeeper_homepage);
    }

    public void Cancel(View view) {
        Toast.makeText(this, "取消接單", Toast.LENGTH_SHORT);
        finish();
    }
}