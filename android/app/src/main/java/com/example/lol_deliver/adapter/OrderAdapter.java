package com.example.lol_deliver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lol_deliver.R;
import com.example.lol_deliver.item.OrderItem;

import java.util.List;

public class OrderAdapter extends ArrayAdapter<OrderItem> {
    private Context context;
    private List<OrderItem> orderItemList;
    public OrderAdapter(@NonNull Context context, int resource, List<OrderItem> orderItemList){
        super(context, resource, orderItemList);
        this.context = context;
        this.orderItemList = orderItemList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout orderLayout = null;

        if(convertView == null){
            orderLayout = (LinearLayout) inflater.inflate(R.layout.item_order, null);
        }
        else{
            orderLayout = (LinearLayout) convertView;
        }
        OrderItem order = orderItemList.get(position);

        TextView tvFoodName = (TextView) orderLayout.findViewById(R.id.tv_Name);
        tvFoodName.setText(order.getFoodName());

        TextView tvFoodPrice = (TextView) orderLayout.findViewById(R.id.tv_price);
        tvFoodPrice.setText(order.getFoodPrice());

        TextView tvFoodQuantity = (TextView) orderLayout.findViewById(R.id.tv_quantity);
        tvFoodQuantity.setText(order.getFoodQuantity());

        return orderLayout;
    }
}
