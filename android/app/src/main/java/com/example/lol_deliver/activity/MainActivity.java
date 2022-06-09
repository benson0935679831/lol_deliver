package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lol_deliver.R;
import com.example.lol_deliver.ShopkeeperHomepage;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    /**
     * DataListener是用來實作接收identity的介面
     */
    public interface DataListener {
        void newIdentityReceived(String identity);
    }

    public interface ShopNameListener {
        void setShopName(String target, String res);
    }

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
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void personalData(View view){
        Intent intent = new Intent(this, PersonaldataActivity.class);
        startActivity(intent);
    }

//    public void test(View view){
//        Intent intent = new Intent(this, SideDishActivity.class);
//        startActivity(intent);
//    }
}