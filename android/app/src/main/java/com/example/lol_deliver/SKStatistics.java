package com.example.lol_deliver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SKStatistics extends AppCompatActivity {

    TextView name;
    private DatabaseReference mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sk_statistics);
        getSupportActionBar().hide();

        name = (TextView) findViewById(R.id.tv_sk_statistics_name);
        loadInfo("name", name);
    }

    public void loadInfo(String tag, TextView tv){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("shops").child("JhuJian").child(tag).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String res = snapshot.getValue(String.class);
                        tv.setText(res);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }
}