package com.example.lol_deliver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
    private EditText etEmail;
    private EditText etPassword;
    private EditText etchkPassword;
    private String identity;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        etName = findViewById(R.id.et_name);
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

    /**
     * regist and show success or fail on toast
     * @param view
     * @throws IOException
     */
    public void register(View view) throws IOException {
        EditText etxName = (EditText) findViewById(R.id.et_name);
        EditText etxEmail = (EditText) findViewById(R.id.et_email);
        EditText etxPassword = (EditText) findViewById(R.id.et_password);
        EditText etxChkPassword = (EditText) findViewById(R.id.et_chkPassword);

        if(etxPassword.getText().toString().compareTo(etxChkPassword.getText().toString()) != 0)// 確認密碼與驗證碼是否相同
            Toast.makeText(this,"密碼與確認密碼不同!",Toast.LENGTH_SHORT).show();
        else {
            final String[] msg = new String[1];
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String path = String.format("https://localhost:8080/delivery/registerCheck.php?userIdentity=customer&userName=%s&userMail=%s&userPassword=%s", etxName.getText().toString(), etxEmail.getText().toString(), etxPassword.getText().toString());
                        URL url = new URL(path);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setConnectTimeout(5000);// 設置連接超時為5秒
                        conn.setRequestMethod("GET");// 設置請求類型為Get類型
                        Log.i("notice", "here");
                        if (conn.getResponseCode() != 200) {// 判斷請求Url是否成功
                            Log.i("notice", "請求url失敗");
                            throw new RuntimeException("請求url失敗");
                        }
                        if (Boolean.parseBoolean(conn.getInputStream().toString())){// 確認電子郵件是否存在
                            msg[0] = "此電子郵件已存在!";
                            Log.i("notice", "此電子郵件已存在!");
                            Log.i("notice", msg[0]);
                        }
                        else {
                            msg[0] = "註冊成功";
                            Log.i("notice", "註冊成功");
                            Log.i("notice", msg[0]);
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //Toast.makeText(this, msg[0], Toast.LENGTH_SHORT).show();

        }
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
            addUser();
            finish();
        }
        else{
            Toast.makeText(this, "註冊失敗", Toast.LENGTH_LONG).show();
        }
    }
    private void addUser(){
        String email = etEmail.getText().toString();
        String name = etName.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference userRef = firebaseDatabase.getReference("users");
        DatabaseReference phoneRef = userRef.child(name);
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("name",name);
        user.put("identity",identity);
        phoneRef.updateChildren(user);

    }
}