package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerBeginActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_begin);
        //隱藏標題列
        getSupportActionBar().hide();

        // ShopItem
        ArrayList<ShopItem> shopList = new ArrayList<ShopItem>();

        shopList.add(new ShopItem(R.drawable.zhujian,"築間幸福鍋物 台中逢甲店","20-30分鐘•30.00TWD","4.5"));
        shopList.add(new ShopItem(R.drawable.macdonald,"麥當勞 台中逢甲店","20-30分鐘•30.00TWD","4.7"));
        shopList.add(new ShopItem(R.drawable.qingno3,"慶三號烤肉倉庫 台中逢甲店","50-60分鐘•20.00TWD","4.8"));

        ShopAdapter adapter = new ShopAdapter(this,R.layout.shopitem, shopList);

        ListView lvShop =(ListView) findViewById(R.id.lv_shops);
        lvShop.setAdapter(adapter);
        lvShop.setOnItemClickListener(this);

        // Sidebar
        ArrayList<SidebarItem> sidebarItems = new ArrayList<SidebarItem>();
        sidebarItems.add(new SidebarItem(R.drawable.icon_personaldata, "個人資料"));
        sidebarItems.add(new SidebarItem(R.drawable.icon_setting, "設定"));
        SidebarAdapter sidebarAdapter = new SidebarAdapter(this, R.layout.sidebaritem, sidebarItems);
        ListView lvSidebar = (ListView) findViewById(R.id.lv_sidebar);
        lvSidebar.setAdapter(sidebarAdapter);
        lvSidebar.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Toast.makeText(this, "第"+Integer.toString(index)+"間餐廳",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ShopMenuActivity.class);
        startActivity(intent);
    }
    public void onClick(View view){
//        Intent intent = new Intent(this, ShopkeeperHomepage.class);
//        startActivity(intent);
    }
}