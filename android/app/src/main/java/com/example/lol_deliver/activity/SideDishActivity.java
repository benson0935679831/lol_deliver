package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.example.lol_deliver.adapter.SideDishAdapter;

import com.example.lol_deliver.item.SideDishItem;

import java.util.ArrayList;


public class SideDishActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidedish);
        //隱藏標題列
        getSupportActionBar().hide();

        ArrayList<SideDishItem> sideDishList = new ArrayList<SideDishItem>();

        sideDishList.add(new SideDishItem("肉品選擇 [超值]", 1, false,"選一項"));
        sideDishList.add(new SideDishItem("湯底選擇 [熟食套餐]",1, false, "選一項"));
        sideDishList.add(new SideDishItem("直人獨享鍋加點選擇 [附餐]",1, false, "選一項"));

        SideDishAdapter adapter = new SideDishAdapter(this,R.layout.item_sidedish, sideDishList);

        ListView lvsideDish =(ListView) findViewById(R.id.lv_sideDish);
        lvsideDish.setAdapter(adapter);
        lvsideDish.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Toast.makeText(this, "第"+Integer.toString(index)+"樣食物",Toast.LENGTH_SHORT).show();
    }
    public void goBack(View view){
        finish();
    }
}