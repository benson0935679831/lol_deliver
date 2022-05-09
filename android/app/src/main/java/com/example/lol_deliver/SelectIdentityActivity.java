package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectIdentityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_identity);
    }

    public void goBack(View view){
        finish();
    }

    public void goToSignupIntent(View view){
        Intent intent = new Intent(this, UserSignupActivity.class);
        startActivity(intent);
    }
}