package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.example.lol_deliver.adapter.CartAdapter;
import com.example.lol_deliver.item.OrderItem;

import java.util.ArrayList;

public class CartWithItemActivity extends AppCompatActivity {

    static final String db_name = "order";
    static final String tb_name = "test";
    SQLiteDatabase db;
    private String shopName;
    private ArrayList<OrderItem> OrderList;
    TextView tvSum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_with_item);
        tvSum = findViewById(R.id.tv_cart_price);
        // 開啟或建立資料庫
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
        String createTable = "CREATE TABLE IF NOT EXISTS "
                + tb_name+
                " (shopName VARCHAR(32),"+
                "imageId VARCHAR(50), "+
                "foodName VARCHAR(20), "+
                "foodPrice VARCHAR(10), "+
                "foodCount VARCHAR(100))";
        db.execSQL(createTable);
        int sum = 0;
        Cursor c = db.rawQuery("SELECT * FROM "+ tb_name,null);
        if(c.getCount()==0){
            Toast.makeText(this,"db is empty", Toast.LENGTH_SHORT).show();
        }
        if(c.moveToFirst()){
            String str = "總共有 "+c.getCount()+"筆資料\n";
            str += "------\n";
            shopName = c.getString(0);
            OrderList = new ArrayList<OrderItem>();
            do{
//                str += "shopName:" + c.getString(0)+"\n";
//                str += "foodName:" + c.getString(1)+"\n";
//                str += "foodPrice:" + c.getString(2)+"\n";
//                str += "foodCount:" + c.getString(3)+"\n";
                OrderList.add(new OrderItem(c.getString(1), Integer.parseInt(c.getString(2)),Integer.parseInt(c.getString(3))));
                sum += Integer.parseInt(c.getString(2).substring(2)) * Integer.parseInt(c.getString(3));
            }while(c.moveToNext());
            CartAdapter adapter = new CartAdapter(this,R.layout.item_cart, OrderList);
            ListView lvCart = (ListView) findViewById(R.id.lv_cart);
            lvCart.setAdapter(adapter);

//            TextView tv = (TextView) findViewById(R.id.tv_sqlData);
//            tv.setText(str);
        }
        tvSum.setText("$ " + Integer.toString(sum));
        db.close();
    }
    public void onAccount(View view){
//        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null);
//        String sql = "DELETE FROM " +tb_name+";";
//        db.execSQL(sql);
//        db.close();
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("shopName",shopName);
        startActivity(intent);
    }

    public TextView getTvSum(){ return tvSum; }

    public void onCancel(View view){
        finish();
    }
}