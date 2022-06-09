package com.example.lol_deliver.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.example.lol_deliver.ShopkeeperHomepage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements OnCompleteListener<AuthResult>, MainActivity.DataListener{
    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth firebaseAuth;
    private EditText etName;
    private DatabaseReference mDatabase;
    private String identity2;
    static public String Uid;

    private String account,repassword,re_account,re_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        getSupportActionBar().hide();

        etEmail = findViewById(R.id.et_login_account);
        etPassword = findViewById(R.id.et_login_password);
        release();
        etName = findViewById(R.id.et_name);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onLogin(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        account = email;
        repassword = password;
//        name = etName.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, this);
        remeber();
    }
    private void remeber(){
        SharedPreferences user = getSharedPreferences("remember", MODE_PRIVATE);
        SharedPreferences.Editor editor = user.edit();
        editor.putString("account",account);
        editor.putString("password",repassword);
        editor.commit();
    }
    private void release(){
        SharedPreferences user = getSharedPreferences("remember", MODE_PRIVATE);
        re_account = user.getString("account","");
        re_password = user.getString("password","");
        etEmail.setText(re_account);
        etPassword.setText(re_password);
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
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Uid = user.getUid();
            if(Uid!=null) {
                Log.d("user", Uid);
            }
            finish();
            getIdentity(Uid, this);
        }
        else{
            Toast.makeText(this, "登入失敗", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void newIdentityReceived(String identity) {
        if(identity.equals("customer")){
            Intent intent = new Intent(this, CustomerBeginActivity.class);
            startActivity(intent);
        }
        else if(identity.equals("shopkeeper")) {
            Intent intent = new Intent(this, ShopkeeperHomepage.class);
            startActivity(intent);
        }
        else{
            Log.d("error", "identity is null");
        }
    }
    public void getIdentity(String Uid, MainActivity.DataListener dataListener){
        final String[] identity = new String[1];
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(Uid).child("identity").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    identity[0] = String.valueOf(task.getResult().getValue());
                }
                // 接受到新資料(身分)後呼叫DataListener
                dataListener.newIdentityReceived(identity[0]);
            }
        });
    }
}