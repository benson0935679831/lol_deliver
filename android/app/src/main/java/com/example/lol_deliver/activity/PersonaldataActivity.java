package com.example.lol_deliver.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.SKHomepageFragment;
import com.example.lol_deliver.SKModifyInfo;
import com.example.lol_deliver.item.PersonalItem;
import com.example.lol_deliver.R;
import com.example.lol_deliver.adapter.PersonalAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PersonaldataActivity extends AppCompatActivity{
    public static final String DATA_NO = "data_no";
    public static final int REQUEST_CODE = 1;
    private DatabaseReference mDataBase;
    private String Uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        //隱藏標題列
//        getSupportActionBar().hide();

        Uid = LoginActivity.Uid;

        TextView personalName = findViewById(R.id.content_name);
        TextView personalEmail = findViewById(R.id.content_email);
        TextView personalPhone = findViewById(R.id.content_phone);
        loadInfo(Uid,"name",personalName);
        loadInfo(Uid,"email",personalEmail);
        loadInfo(Uid,"phone",personalPhone);
//        ListView personalLV = this.findViewById(R.id.personal_list);
//        ArrayList<PersonalItem> personals = new ArrayList<PersonalItem>();
//        personals.add(new PersonalItem(R.drawable.pencil,"姓名","請輸入姓名"));
//        personals.add(new PersonalItem(R.drawable.pencil,"電子信箱","請輸入電子郵件"));
//        personals.add(new PersonalItem(R.drawable.pencil,"電話","請輸入電話"));
//
//        PersonalAdapter adapter = new PersonalAdapter(this,R.layout.item_personal,personals);
//        personalLV.setAdapter(adapter);
//        personalLV.setOnItemClickListener(this);
    }
    public void goBack(View view){
        finish();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this,EditorActivity.class);
        startActivity(intent);
    }
    public void loadInfo(String Uid, String tag, TextView tv){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("users").child(Uid).child(tag).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String res = snapshot.getValue(String.class);
                        tv.setText(res);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("TAG", "loadPost:onCancelled", error.toException());
                    }
                }
        );
    }
}