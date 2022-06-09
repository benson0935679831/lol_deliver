package com.example.lol_deliver.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.example.lol_deliver.item.ShopItem;
import com.example.lol_deliver.item.SidebarItem;
import com.example.lol_deliver.adapter.ShopAdapter;
import com.example.lol_deliver.adapter.SidebarAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CustomerBeginActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private  ArrayList<ShopItem> shopList;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_begin);
        //隱藏標題列
//        getSupportActionBar().hide();

        mDatabase = FirebaseDatabase.getInstance().getReference("shops");
        // ShopItem
        shopList = new ArrayList<ShopItem>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Log.d("shops",snapshot.child("name").getValue().toString());
                    Log.d("shops",snapshot.child("id").getValue().toString());
                    Log.d("shops",snapshot.child("detail").getValue().toString());
                    Log.d("shops",snapshot.child("star").getValue().toString());
                    Log.d("shops",snapshot.getKey());
                    ShopItem shop = new ShopItem(snapshot.child("id").getValue().toString(), snapshot.child("name").getValue().toString(),snapshot.child("detail").getValue().toString(),snapshot.child("star").getValue().toString(), snapshot.getKey());

                    shopList.add(shop);
                }
                ShopAdapter adapter = new ShopAdapter(CustomerBeginActivity.this,R.layout.item_shop, shopList);

                ListView lvShop =(ListView) findViewById(R.id.lv_shops);
                lvShop.setAdapter(adapter);
                lvShop.setOnItemClickListener(CustomerBeginActivity.this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        //        Toast.makeText(this, "第"+Integer.toString(index)+"間餐廳",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ShopMenuActivity.class);
        intent.putExtra("shopName", shopList.get(index).getShopId());
        startActivity(intent);
    }
    public void onCartClick(View view){
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}