package com.example.lol_deliver.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lol_deliver.item.FoodItem;
import com.example.lol_deliver.R;
import com.example.lol_deliver.adapter.FoodAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShopMenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, MainActivity.DataListenerMenu{

    private DatabaseReference mDataBase, menuDataBase;
    private String shopName, foodName, foodDetail, foodPrice, count1, tmp;
    private int count, id, imgID;
    private TextView listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_menu);
        //隱藏標題列
        getSupportActionBar().hide();

        ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();

//        listener = (TextView) findViewById(R.id.tv_menu_listener);
        shopName = "JhuJian";
        mDataBase = FirebaseDatabase.getInstance().getReference().child("shops").child(shopName).child("menu");
//        loadString(mDataBase, "count", this);
        count = 1;
        menuDataBase = mDataBase.child(Integer.toString(count));
        loadString(menuDataBase, foodName, "name", this);
        loadString(menuDataBase, foodPrice, "price", this);
        Log.d("firebase", String.valueOf(foodName));

//        for(int i=1;i<=count;i++){
//            menuDataBase = mDataBase.child(Integer.toString(count));
//            //loadInt(menuDataBase, "id", listener);
//            loadString(menuDataBase,"name", this);
//            foodName = listener.getText().toString();
//            loadString(menuDataBase, "detail", this);
//            foodDetail = listener.getText().toString();
//            //loadInt(menuDataBase, "price", listener);
//
//            foodList.add(new FoodItem(imgID, foodName, foodDetail, foodPrice));
//        }

        foodList.add(new FoodItem(id,"澳洲羊肉鍋","", "$430起"));
        foodList.add(new FoodItem(id,"梅花豬肉鍋","", "$400起"));

        FoodAdapter adapter = new FoodAdapter(this,R.layout.item_food, foodList);

        ListView lvfood =(ListView) findViewById(R.id.lv_menu);
        lvfood.setAdapter(adapter);
        lvfood.setOnItemClickListener(this);
    }

    public void loadString(DatabaseReference dbr, String target, String tag, MainActivity.DataListenerMenu dataListenerMenu){
        final String[] identity = new String[2];
        identity[0] = target;
        dbr.child(tag).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    identity[1] = String.valueOf(task.getResult().getValue());
                }
                // 接受到新資料(身分)後呼叫DataListener
                dataListenerMenu.setString(identity[0], identity[1]);
            }
        });
    }

//    public String loadString(DatabaseReference dbr, String tag){
//        final String[] identity = new String[1];
//        dbr.child(tag).addListenerForSingleValueEvent(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        String res = snapshot.getValue(String.class).toString();
//                        identity[0] = res;
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                }
//        );
//        return identity[0];
//    }
//
//    public void loadInt(DatabaseReference dbr, String tag, TextView tv){
//        dbr.child(tag).addListenerForSingleValueEvent(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        Integer res = snapshot.getValue(Integer.class).intValue();
//                        tv.setText(res.toString());
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                }
//        );
//    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        //Toast.makeText(this, "第"+Integer.toString(index)+"樣食物",Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "tmp", Toast.LENGTH_SHORT).show();
    }
    public void goBack(View view){
        finish();
    }

    @Override
    public void setString(String target, String res) {
        target = res;
        Log.d("firebase", String.valueOf(target));
    }
}