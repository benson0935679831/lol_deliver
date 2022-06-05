package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lol_deliver.R;

public class SideDishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidedish);
        //隱藏標題列
        getSupportActionBar().hide();
    }

    public void goBack(View view){finish();}
}