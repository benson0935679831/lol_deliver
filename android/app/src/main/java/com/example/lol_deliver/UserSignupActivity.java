package com.example.lol_deliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class UserSignupActivity extends AppCompatActivity{
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

    /**
     * regist and show success or fail on toast
     * @param view
     * @throws IOException
     */
    public void register(View view) throws IOException {
        EditText etxName = (EditText) findViewById(R.id.etx_name);
        EditText etxEmail = (EditText) findViewById(R.id.etx_email);
        EditText etxPassword = (EditText) findViewById(R.id.etx_password);
        EditText etxChkPassword = (EditText) findViewById(R.id.etx_chkPassword);

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
                        if (conn.getResponseCode() != 200)// 判斷請求Url是否成功
                            throw new RuntimeException("請求url失敗");
                        if (Boolean.parseBoolean(conn.getInputStream().toString()))// 確認電子郵件是否存在
                            msg[0] = "此電子郵件已存在!";
                        else
                            msg[0] = "註冊成功";
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

}