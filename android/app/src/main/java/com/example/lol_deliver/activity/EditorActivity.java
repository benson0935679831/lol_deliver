package com.example.lol_deliver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.example.lol_deliver.activity.PersonaldataActivity;

public class EditorActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        //隱藏標題列
        getSupportActionBar().hide();

        Intent it = this.getIntent();
        int dataNO = it.getIntExtra(PersonaldataActivity.DATA_NO,0);
        String msg = "輸入姓名";
        if (dataNO == 1) {
            msg = "輸入電子信箱";
        }
        else if(dataNO == 2){
            msg = "輸入電話";
        }
        TextView textView = findViewById(R.id.edit_data);
        textView.setHint(msg);
    }
    public void goSave(View view){
        EditText editText = findViewById(R.id.edit_data);
        String data = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("resultData", editText.getText().toString());
        setResult(RESULT_CODE, intent);
        finish();

    }
    public void goBack(View view){
        finish();
    }
}