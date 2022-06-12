package com.example.lol_deliver.adapter;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.lol_deliver.R;
import com.example.lol_deliver.activity.CartWithItemActivity;
import com.example.lol_deliver.activity.CustomerBeginActivity;
import com.example.lol_deliver.item.OrderItem;

import java.lang.ref.WeakReference;
import java.util.List;

public class CartAdapter extends ArrayAdapter<OrderItem>{
    private Context context;
    private List<OrderItem> cartItemList;
    private int sum;
    WeakReference<Activity> weak;
    public CartAdapter(@NonNull Context context, int resource, List<OrderItem> cartItemList){
        super(context, resource, cartItemList);
        this.context = context;
        this.cartItemList = cartItemList;
        this.sum = 0;
        this.weak = new WeakReference<Activity>((Activity) context);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout cartLayout = null;

        if(convertView == null){
            cartLayout = (LinearLayout) inflater.inflate(R.layout.item_cart, null);
        }
        else{
            cartLayout = (LinearLayout) convertView;
        }
        OrderItem cart = cartItemList.get(position);

        TextView tvFoodName = (TextView) cartLayout.findViewById(R.id.tv_cart_name);
        tvFoodName.setText(cart.getFoodName());

        TextView tvFoodPrice = (TextView) cartLayout.findViewById(R.id.tv_cart_foodPrice);
        tvFoodPrice.setText(cart.getFoodPrice());

        TextView tvFoodQuantity = (TextView) cartLayout.findViewById(R.id.tv_cart_quantity);
        tvFoodQuantity.setText(cart.getFoodQuantity().split("x")[0]);

        ImageView ivAdd = (ImageView) cartLayout.findViewById(R.id.iv_cart_plus);
        ImageView ivSub = (ImageView) cartLayout.findViewById(R.id.iv_cart_minus);


        sum += Integer.parseInt(tvFoodPrice.getText().toString().substring(2)) * Integer.parseInt(tvFoodQuantity.getText().toString().split("x")[0]);
        Log.d("sum",Integer.toString(sum));
        View.OnClickListener addFood = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFoodQuantity.setText(Integer.toString(Integer.parseInt(tvFoodQuantity.getText().toString()) + 1));
                sum += Integer.parseInt(tvFoodPrice.getText().toString().substring(2));
            }
        };

        View.OnClickListener subFood = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvFoodQuantity.setText(Integer.toString(Integer.parseInt(tvFoodQuantity.getText().toString()) - 1));
                sum -= Integer.parseInt(tvFoodPrice.getText().toString().substring(2));
                if(Integer.parseInt(tvFoodQuantity.getText().toString()) <= 0){
                    cartItemList.remove(position);
                    notifyDataSetChanged();
                }
                Log.d("sum",Integer.toString(sum));
            }
        };

        ivAdd.setOnClickListener(addFood);
        ivSub.setOnClickListener(subFood);


        return cartLayout;
    }


}
