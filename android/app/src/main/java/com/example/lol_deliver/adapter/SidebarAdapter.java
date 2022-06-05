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
import com.example.lol_deliver.item.SidebarItem;

import java.util.List;

public class SidebarAdapter extends ArrayAdapter<SidebarItem> {
    private Context context;
    private List<SidebarItem> sidebarItemList;
    public SidebarAdapter(@NonNull Context context, int resource, List<SidebarItem> sidebarItemList) {
        super(context, resource, sidebarItemList);
        this.context = context;
        this.sidebarItemList = sidebarItemList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout sidebarLayout = null;

        if(convertView == null){
            sidebarLayout = (LinearLayout) inflater.inflate(R.layout.item_sidebar, null);
        }
        else{
            sidebarLayout = (LinearLayout) convertView;
        }
        SidebarItem navigation = sidebarItemList.get(position);

        ImageView iv = sidebarLayout.findViewById(R.id.iv_ct_icon);
        iv.setImageResource(navigation.getImgResId());

        TextView tvIcon = sidebarLayout.findViewById(R.id.tv_icon);
        tvIcon.setText(navigation.getNavigationName());

        return sidebarLayout;
    }
}
