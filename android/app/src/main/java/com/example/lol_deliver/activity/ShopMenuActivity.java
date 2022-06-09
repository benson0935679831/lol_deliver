package com.example.lol_deliver.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.adapter.ShopAdapter;
import com.example.lol_deliver.item.FoodItem;
import com.example.lol_deliver.R;
import com.example.lol_deliver.adapter.FoodAdapter;
import com.example.lol_deliver.item.ShopItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShopMenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private DatabaseReference mDataBase;
    private String shopName;
    TextView tv_shopName;
    ImageView iv_shopImg;
    private ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_menu);
        //隱藏標題列
//        getSupportActionBar().hide();

        tv_shopName = (TextView) findViewById(R.id.tv_menu_shopName);
        iv_shopImg = (ImageView) findViewById(R.id.iv_menu_shopImg);
        Intent intent = getIntent();
        shopName = intent.getExtras().getString("shopName");
        mDataBase = FirebaseDatabase.getInstance().getReference().child("shops").child(shopName);

        mDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tv_shopName.setText(dataSnapshot.child("name").getValue().toString());
                String uri = "@drawable/"+dataSnapshot.child("id").getValue().toString();
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable imageId = ContextCompat.getDrawable(ShopMenuActivity.this, imageResource);
                iv_shopImg.setImageDrawable(imageId);
                for(DataSnapshot snapshot : dataSnapshot.child("menu").getChildren()){
                    Log.d("shops",snapshot.child("id").getValue().toString());
                    Log.d("shops",snapshot.child("name").getValue().toString());
                    Log.d("shops",snapshot.child("detail").getValue().toString());
                    Log.d("shops",snapshot.child("price").getValue().toString());
                    FoodItem food = new FoodItem(snapshot.child("id").getValue().toString(), snapshot.child("name").getValue().toString(),snapshot.child("detail").getValue().toString(), snapshot.child("price").getValue().toString(), snapshot.getKey());

                    foodList.add(food);
                }
                //ShopAdapter adapter = new ShopAdapter(CustomerBeginActivity.this,R.layout.item_shop, shopList);

                FoodAdapter adapter = new FoodAdapter(ShopMenuActivity.this,R.layout.item_food, foodList);
                ListView lvfood =(ListView) findViewById(R.id.lv_menu);
                lvfood.setAdapter(adapter);
                lvfood.setOnItemClickListener(ShopMenuActivity.this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Intent intent = new Intent(this, SideDishActivity.class);
        intent.putExtra("foodName", foodList.get(index).getFoodName());
        intent.putExtra("foodDetail", foodList.get(index).getFoodDetail());
        intent.putExtra("foodPrice", foodList.get(index).getFoodPrice());
        intent.putExtra("foodImg", foodList.get(index).getImgResId());
        intent.putExtra("shopName", shopName);
        intent.putExtra("foodId", foodList.get(index).getFoodDetail());
        startActivity(intent);
    }
    public void goBack(View view){
        finish();
    }

}