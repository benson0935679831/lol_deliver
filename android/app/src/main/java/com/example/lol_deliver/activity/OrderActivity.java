package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lol_deliver.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String shopName = intent.getExtras().getString("shopName");
        TextView tvShopName = (TextView) findViewById(R.id.tv_shopName);
        TextView tvOrderShopName = (TextView) findViewById(R.id.tv_order_shopName);
        tvOrderShopName.setText(shopName);
        tvShopName.setText(shopName);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference orderRef = mDatabase.child("orders");
        Map<String, Object> order = new HashMap<>();
        Map<String, Object> meal = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();

        db = openOrCreateDatabase("order", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM "+ "test",null);
        int sum = 0;
        if(c.moveToFirst()){
            do{
                meal.put(c.getString(1),c.getString(3));
                sum += Integer.parseInt(c.getString(2).substring(2)) * Integer.parseInt(c.getString(3));
                Log.d("total",Integer.toString(sum));
//                str += "shopName:" + c.getString(0)+"\n";
//                str += "foodName:" + c.getString(1)+"\n";
//                str += "foodPrice:" + c.getString(2)+"\n";
//                str += "foodCount:" + c.getString(3)+"\n";
//                OrderList.add(new OrderItem(c.getString(1), Integer.parseInt(c.getString(2)),Integer.parseInt(c.getString(3))));
//                sum += Integer.parseInt(c.getString(2).substring(2)) * Integer.parseInt(c.getString(3));
            }while(c.moveToNext());
//            TextView tv = (TextView) findViewById(R.id.tv_sqlData);
//            tv.setText(str);
        }

        order.put("meal", meal);
        order.put("price",sum);
        temp.put("key",order);
        orderRef.updateChildren(temp);
    }
    public void goBack(View view){
        Intent intent = new Intent(this, CustomerBeginActivity.class);
        startActivity(intent);
    }
}