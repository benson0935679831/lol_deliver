package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lol_deliver.R;
import com.example.lol_deliver.activity.SignupActivity;

public class SelectIdentityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_identity);
    }

    public void goBack(View view){
        finish();
    }

    public void goToSignupCustomerIntent(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        intent.putExtra("identity", "customer");
        startActivity(intent);
    }
    public void goToSignupShopkeeperIntent(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        intent.putExtra("identity", "shopkeeper");
        startActivity(intent);
    }
    public void goToSignupDeliverIntent(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        intent.putExtra("identity", "deliver");
        startActivity(intent);
    }
}