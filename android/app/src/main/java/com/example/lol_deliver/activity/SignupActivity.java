package com.example.lol_deliver.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class SignupActivity extends AppCompatActivity implements OnCompleteListener<AuthResult> {
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etchkPassword;
    private String identity;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
//        getSupportActionBar().hide();

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etchkPassword = findViewById(R.id.et_chkPassword);

        Intent oldIntent = getIntent();
        identity = oldIntent.getStringExtra("identity");
        firebaseAuth = FirebaseAuth.getInstance();
    }

    /**
     * go back to last page
     * @param view
     */
    public void goBack(View view){
        finish();
    }


    public void onRegister(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String chkPassword = etchkPassword.getText().toString();
        if(password.compareTo(chkPassword) != 0){
            Toast.makeText(this,"密碼與確認密碼不同!",Toast.LENGTH_LONG).show();
        }
        else {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, this);
        }
    }
    public void onCancel(View view){
        finish();
    }
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Toast.makeText(this, "註冊成功", Toast.LENGTH_LONG).show();
            Log.d("debug", task.getResult().getUser().getUid());
            String UID = task.getResult().getUser().getUid();
            addUser(UID);
            finish();
        }
        else{
            Toast.makeText(this, "註冊失敗", Toast.LENGTH_LONG).show();
        }
    }
    private void addUser(String UID){
        // 改為由UID當主鍵
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference userRef = firebaseDatabase.getReference("users");
        DatabaseReference idRef = userRef.child(UID);
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("name",name);
        user.put("identity",identity);
        idRef.updateChildren(user);
    }
}