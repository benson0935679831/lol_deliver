package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lol_deliver.item.PersonalItem;
import com.example.lol_deliver.R;
import com.example.lol_deliver.adapter.PersonalAdapter;

import java.util.ArrayList;

public class PersonaldataActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    public static final String DATA_NO = "data_no";
    public static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        //隱藏標題列
        getSupportActionBar().hide();
        ListView personalLV = this.findViewById(R.id.personal_list);
        ArrayList<PersonalItem> personals = new ArrayList<PersonalItem>();
        personals.add(new PersonalItem(R.drawable.pencil,"姓名","請輸入姓名"));
        personals.add(new PersonalItem(R.drawable.pencil,"電子信箱","請輸入電子郵件"));
        personals.add(new PersonalItem(R.drawable.pencil,"電話","請輸入電話"));

        PersonalAdapter adapter = new PersonalAdapter(this,R.layout.item_personal,personals);
        personalLV.setAdapter(adapter);
        personalLV.setOnItemClickListener(this);
    }
    public void goBack(View view){
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent();
        intent.setClass(PersonaldataActivity.this, EditorActivity.class);
        intent.putExtra(DATA_NO, position);
        startActivityForResult(intent,REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_CODE && resultCode == EditorActivity.RESULT_CODE){
            String result_data = data.getStringExtra("resultData").toString();
            Toast.makeText(this,result_data,Toast.LENGTH_SHORT).show();
        }

    }
}