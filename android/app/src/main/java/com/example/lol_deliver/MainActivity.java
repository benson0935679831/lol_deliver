package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToLoginIntent(View view){
        Intent intent = new Intent(this, UserRegisterActivity.class);

        startActivity(intent);
    }
}