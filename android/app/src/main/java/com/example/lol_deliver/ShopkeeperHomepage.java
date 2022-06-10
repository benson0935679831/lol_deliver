package com.example.lol_deliver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javax.crypto.SecretKey;

public class ShopkeeperHomepage extends AppCompatActivity {

    BottomNavigationView bnView;
    private SKHomepageFragment skHomepageFragment;
    private SKNowOrderFragment skNowOrderFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private DatabaseReference mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_shopkeeper_homepage);
//        getSupportActionBar().hide();

        bnView = findViewById(R.id.nvg_sk);

        fragmentManager = getSupportFragmentManager();
        skHomepageFragment = new SKHomepageFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fcv_sk, skHomepageFragment);
        fragmentTransaction.show(skHomepageFragment);
        fragmentTransaction.commit();

        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav1:
                        selectedFragment = new SKHomepageFragment();
                        break;
                    case R.id.nav2:
                        selectedFragment = new SKNowOrderFragment();
                        break;
                }
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fcv_sk, selectedFragment);
                fragmentTransaction.show(selectedFragment);
                fragmentTransaction.commit();
                return true;
            }
        });

        OrderRecieve();
    }

    private void OrderRecieve() {
        mDataBase = FirebaseDatabase.getInstance().getReference().child("orders");
        mDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
                    Intent intent = new Intent(ShopkeeperHomepage.this, SKRecieveOrder.class);
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        intent.putExtra("orderId", dataSnapshot.getKey());
                    }
                    startActivity(intent);
                }
                else{
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
