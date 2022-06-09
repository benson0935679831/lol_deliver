package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.example.lol_deliver.ShopkeeperHomepage;

import java.util.ArrayList;


public class SideDishActivity extends AppCompatActivity{

    private int foodCount;
    private int id;
    private String shopName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidedish);
        this.foodCount = 0;
        Intent intent = getIntent();
        this.id = intent.getExtras().getInt("foodId");
        this.shopName = intent.getExtras().getString("shopName");

        ImageView ivIcon = findViewById(R.id.iv_sideDish_foodIcon);
        TextView tvName = findViewById(R.id.tv_sideDish_foodName);
        TextView tvPrice = findViewById(R.id.tv_sideDish_foodPrice);
        TextView tvDetail = findViewById(R.id.tv_sideDish_foodDetail);

        ivIcon.setImageResource(intent.getExtras().getInt("foodImg"));
        tvName.setText(intent.getExtras().getString("foodName"));
        tvPrice.setText(intent.getExtras().getString("foodPrice"));
        tvDetail.setText(intent.getExtras().getString("foodDetail"));


        //隱藏標題列
        getSupportActionBar().hide();
    }

    public void addFood(View view){
        foodCount += 1;
        if(foodCount > 0){
            ImageView ivSub = findViewById(R.id.iv_sideDish_minusBtn);
            ImageView ivSubmit = findViewById(R.id.iv_sideDish_addCartBtn);
            ivSub.setImageResource(R.drawable.ic_minus_on);
            ivSubmit.setImageResource(R.drawable.ic_add_cart_on);
        }
    }

    public void subFood(View view){
        if(foodCount > 0){
            foodCount -= 1;
        }
        if(foodCount == 0){
            ImageView ivSub = findViewById(R.id.iv_sideDish_minusBtn);
            ImageView ivSubmit = findViewById(R.id.iv_sideDish_addCartBtn);
            ivSub.setImageResource(R.drawable.ic_minus_off);
            ivSubmit.setImageResource(R.drawable.ic_add_cart_off);
        }
    }

    public void submit(View view){
        if(foodCount == 0)
            return;
        else{
            Intent intent = new Intent(this, MainActivity.class);//改成結帳頁面
            intent.putExtra("foodCount", foodCount);
            intent.putExtra("foodName", id);
            intent.putExtra("shopName", shopName);
            startActivity(intent);
        }
    }

    public void goBack(View view){
        finish();
    }
}