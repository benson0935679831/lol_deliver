package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隱藏標題列
        getSupportActionBar().hide();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
    public void goToShop(View view){
        Intent intent = new Intent(this, ShopkeeperHomepage.class);
        startActivity(intent);
    }
    public void goToCustomer(View view){
        Intent intent = new Intent(this, CustomerBeginActivity.class);
        startActivity(intent);
    }
    public void sign_out(View view){
        FirebaseAuth.getInstance().signOut();
    }
}