package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PersonaldataActivity extends AppCompatActivity {
    public static final String DATA_NO = "data_no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        //隱藏標題列
        getSupportActionBar().hide();
        ListView personalLV = this.findViewById(R.id.personal_list);
        ArrayList<Personal> personals = new ArrayList<Personal>();
        personals.add(new Personal(R.drawable.pencil,"姓名","請輸入姓名"));
        personals.add(new Personal(R.drawable.pencil,"電子信箱","請輸入電子郵件"));
        personals.add(new Personal(R.drawable.pencil,"電話","請輸入電話"));

        PersonalAdapter adapter = new PersonalAdapter(this,R.layout.personalitem,personals);
        personalLV.setAdapter(adapter);

        personalLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(PersonaldataActivity.this, EditorActivity.class);
                intent.putExtra(DATA_NO, position);
                startActivity(intent);

            }
        });
    }
    public void goBack(View view){
        finish();
    }
}