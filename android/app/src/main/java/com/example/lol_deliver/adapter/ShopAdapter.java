package com.example.lol_deliver.adapter;

import android.content.Context;
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
import com.example.lol_deliver.item.ShopItem;

import java.util.List;

public class ShopAdapter extends ArrayAdapter<ShopItem>{
    private Context context;
    private List<ShopItem> shopItemList;
    public ShopAdapter(@NonNull Context context, int resource, List<ShopItem> shopItemList){
        super(context, resource, shopItemList);
        this.context = context;
        this.shopItemList = shopItemList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout shopLayout = null;

        if(convertView == null){
            shopLayout = (LinearLayout) inflater.inflate(R.layout.item_shop, null);
        }
        else{
            shopLayout = (LinearLayout) convertView;
        }
        ShopItem food = shopItemList.get(position);

        ImageView iv = shopLayout.findViewById(R.id.iv_sk_shopIcon);
        iv.setImageResource(food.getImgResId());
        // 這行true會導致圖片不一樣大
//        iv.setAdjustViewBounds(true);
        TextView tvShopName = shopLayout.findViewById(R.id.tv_shopName);
        tvShopName.setText(food.getShopName());

        TextView tvShopDetail = shopLayout.findViewById(R.id.tv_shopDetail);
        tvShopDetail.setText(food.getShopDetail());

        TextView tvStar = shopLayout.findViewById(R.id.tv_shopStar);
        tvStar.setText(food.getShopStar());

        return shopLayout;
    }
}