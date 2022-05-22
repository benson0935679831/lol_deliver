package com.example.lol_deliver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements OnCompleteListener<AuthResult> {
    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        etEmail = findViewById(R.id.et_login_account);
        etPassword = findViewById(R.id.et_login_password);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onLogin(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, this);
    }

    public void onRegister(View view){
        Intent intent = new Intent(this, SelectIdentityActivity.class);
        startActivity(intent);
    }
    public void goBack(View view){
        finish();
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            finish();
        }
        else{
            Toast.makeText(this, "登入失敗", Toast.LENGTH_LONG).show();
        }
    }
}