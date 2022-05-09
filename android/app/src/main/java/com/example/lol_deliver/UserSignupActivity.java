package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class UserSignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);
    }

    /**
     * go back to last page
     * @param view
     */
    public void goBack(View view){
        finish();
    }


    public void register(View view){
        // check if the input account is exist
        // true -> do something
        // false -> register a new account
    }
}