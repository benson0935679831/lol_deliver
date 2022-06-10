package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lol_deliver.R;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }
    public void goBack(){
        Intent intent = new Intent(this, CustomerBeginActivity.class);
        startActivity(intent);
    }
}