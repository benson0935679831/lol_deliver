package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShopkeeperHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_shopkeeper_homepage);
        getSupportActionBar().hide();
    }
}