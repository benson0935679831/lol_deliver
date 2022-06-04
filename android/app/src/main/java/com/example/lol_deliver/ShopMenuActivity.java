package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShopMenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_menu);
        //隱藏標題列
        getSupportActionBar().hide();

        ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

        foodList.add(new FoodItem(R.drawable.zhujian,"澳洲羊肉鍋","", "$420起"));
        foodList.add(new FoodItem(R.drawable.macdonald,"梅花豬肉鍋","", "$400起"));
        foodList.add(new FoodItem(R.drawable.qingno3,"超值獨享鍋物三選一","小肥牛、梅花豚、雞腿肉擇一", "$228起"));

        FoodAdapter adapter = new FoodAdapter(this,R.layout.fooditem, foodList);

        ListView lvfood =(ListView) findViewById(R.id.lv_menu);
        lvfood.setAdapter(adapter);
        lvfood.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Toast.makeText(this, "第"+Integer.toString(index)+"樣食物",Toast.LENGTH_SHORT).show();
    }
    public void goBack(View view){
        finish();
    }
}