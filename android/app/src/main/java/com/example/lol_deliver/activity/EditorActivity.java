package com.example.lol_deliver.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.R;
import com.example.lol_deliver.ShopkeeperHomepage;
import com.example.lol_deliver.activity.PersonaldataActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class EditorActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 1;
    private String Uid;
    private DatabaseReference mDataBase;
    private EditText editName,editEmail,editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        //隱藏標題列
        getSupportActionBar().hide();
        Uid = LoginActivity.Uid;
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        loadInfo(Uid,"name",editName);
        loadInfo(Uid,"email",editEmail);
        loadInfo(Uid,"phone",editPhone);

    }
    public void loadInfo(String Uid, String tag, EditText et){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("users").child(Uid).child(tag).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String res = snapshot.getValue(String.class);
                        et.setHint(res);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    public void editor(View view){
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String phone = editPhone.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference personalRef = firebaseDatabase.getReference("users/"+Uid);
        Map<String, Object> personalData = new HashMap<>();
        personalData.put("name", name);
        personalData.put("email", email);
        personalData.put("phone", phone);
        personalRef.updateChildren(personalData);
        finish();

//        Intent intent = new Intent(this, PersonaldataActivity.class);
//        startActivity(intent);
    }

    public void Cancel(View view){
        finish();
    }
    public void goBack(View view){
        finish();
    }
}