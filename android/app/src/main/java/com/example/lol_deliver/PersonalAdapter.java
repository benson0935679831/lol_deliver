package com.example.lol_deliver;

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

import java.util.List;

public class PersonalAdapter extends ArrayAdapter<Personal> {
    private Context context;
    private List<Personal> personals;
    public PersonalAdapter(@NonNull Context context, int resource,List<Personal>personals) {
        super(context, resource,personals);
        this.context = context;
        this.personals = personals;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout listLayout = null;

        if(convertView == null){
            listLayout = (LinearLayout) inflater.inflate(R.layout.personalitem, null);
        }
        else{
            listLayout = (LinearLayout) convertView;
        }
        Personal food = personals.get(position);

        ImageView iv = listLayout.findViewById(R.id.btn_edit);
        iv.setImageResource(food.getImg());
        // 這行true會導致圖片不一樣大
//        iv.setAdjustViewBounds(true);
        TextView tvShopName = listLayout.findViewById(R.id.subject);
        tvShopName.setText(food.getSubject());

        TextView tvShopDetail = listLayout.findViewById(R.id.content);
        tvShopDetail.setText(food.getContent());

        return listLayout;
    }
}
