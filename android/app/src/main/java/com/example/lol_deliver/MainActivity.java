package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        ArrayList<ShopItem> shopList = new ArrayList<ShopItem>();

        shopList.add(new ShopItem(R.drawable.zhujian,"築間幸福鍋物 台中逢甲店","20-30分鐘•30.00TWD"));
        shopList.add(new ShopItem(R.drawable.macdonald,"麥當勞 台中逢甲店","20-30分鐘•30.00TWD"));
        shopList.add(new ShopItem(R.drawable.zhujian,"慶三號烤肉倉庫 台中逢甲店","50-60分鐘•20.00TWD"));

    ShopAdapter adapter = new ShopAdapter(this,R.layout.shopitem, shopList);

    ListView lvShop =(ListView) findViewById(R.id.lv_shops);
    lvShop.setAdapter(adapter);
    }
}