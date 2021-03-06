package com.example.lol_deliver.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.lol_deliver.item.FoodItem;
import com.example.lol_deliver.R;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<FoodItem> {
    private Context context;
    private List<FoodItem> foodItemList;
    public FoodAdapter(@NonNull Context context, int resource, List<FoodItem> foodItemList){
        super(context, resource, foodItemList);
        this.context = context;
        this.foodItemList = foodItemList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout foodLayout = null;

        if(convertView == null){
            foodLayout = (LinearLayout) inflater.inflate(R.layout.item_food, null);
        }
        else{
            foodLayout = (LinearLayout) convertView;
        }
        FoodItem food = foodItemList.get(position);

        ImageView iv = foodLayout.findViewById(R.id.iv_sk_foodIcon);
        String uri = "@drawable/"+food.getImgResId();
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable imageId = ContextCompat.getDrawable(context, imageResource);
        iv.setImageDrawable(imageId);
        // 這行true會導致圖片不一樣大
//        iv.setAdjustViewBounds(true);
        TextView tvfoodName = foodLayout.findViewById(R.id.tv_foodName);
        tvfoodName.setText(food.getFoodName());

        TextView tvfoodDetail = foodLayout.findViewById(R.id.tv_foodDetail);
        tvfoodDetail.setText(food.getFoodDetail());

        TextView tvPrice = foodLayout.findViewById(R.id.tv_foodPrice);
        tvPrice.setText(food.getFoodPrice());

        return foodLayout;
    }
}
