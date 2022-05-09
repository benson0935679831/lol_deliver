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

    /**
     * go to select identity page
     * @param view
     */
    public void goToSltId(View view){
        Intent intent = new Intent(this, SelectIdentityActivity.class);
        startActivity(intent);
    }
}