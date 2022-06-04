package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    public static String identity;
    private DatabaseReference mDatabase;
    private Intent intent;
    private FirebaseAuth firebaseAuth;
    public static boolean VALID_USER = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!VALID_USER){
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            Log.v("user","user is null");
        }
        else{
            Log.v("user","user is exist");
        }
        if(identity!=null) {
            Log.d("id", identity);
        }
        else{
            Log.d("id","null");
        }
//        if(user!=null){
//            // Name, email address, and profile photo Url
//            String name = user.getDisplayName();
//            String email = user.getEmail();
//            String phone = user.getPhoneNumber();
//            Log.v("user",name);
//            Log.v("user",email);
//            Log.v("user",phone);
//            // Check if user's email is verified
////            boolean emailVerified = user.isEmailVerified();
////            if(emailVerified) {
////                Log.v("user", "true");
////            }
////            else{
////                Log.v("user", "false");
////            }
//            // The user's ID, unique to the Firebase project. Do NOT use this value to
//            // authenticate with your backend server, if you have one. Use
//            // FirebaseUser.getIdToken() instead.
//            String uid = user.getUid();
//            Log.v("user",uid);
//        }

    }
    public void sign_out(View view){
        VALID_USER = false;
        FirebaseAuth.getInstance().signOut();
    }
}