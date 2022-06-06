package com.example.lol_deliver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.lol_deliver.R;
import com.example.lol_deliver.item.SideDishItem;



import java.util.List;

public class SideDishAdapter extends ArrayAdapter<SideDishItem> {
    private Context context;
    private List<SideDishItem> sideDishItemList;

    public SideDishAdapter(@NonNull Context context, int resource, List<SideDishItem> sideDishItemList){
        super(context, resource, sideDishItemList);
        this.context = context;
        this.sideDishItemList = sideDishItemList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout sideDishLayout = null;
        if(convertView == null){
            sideDishLayout = (LinearLayout) inflater.inflate(R.layout.item_sidedish, null);
        }
        else{
            sideDishLayout = (LinearLayout) convertView;
        }
        SideDishItem sideDish = sideDishItemList.get(position);


        TextView tvCateName = sideDishLayout.findViewById(R.id.tv_sideDish_cateName);
        tvCateName.setText(sideDish.getCateName());

        TextView tvOption = sideDishLayout.findViewById(R.id.tv_sideDish_option);
        tvOption.setText(sideDish.getOptionQuan());

        TextView tvPrice = sideDishLayout.findViewById(R.id.tv_sideDish_opitonDesc);
        tvPrice.setText(sideDish.getOptionDesc());

        return sideDishLayout;
    }
}
