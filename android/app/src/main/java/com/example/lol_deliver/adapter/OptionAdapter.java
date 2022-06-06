package com.example.lol_deliver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lol_deliver.R;
import com.example.lol_deliver.item.OptionItem;

import java.util.List;

public class OptionAdapter  extends ArrayAdapter<OptionItem> {
    private Context context;
    private List<OptionItem> optionItemList;
    private boolean isSingle;
    private int selectedPosition = 0;
    public OptionAdapter(@NonNull Context context, int resource, List<OptionItem> optionItemList, boolean isSingle){
        super(context, resource, optionItemList);
        this.context = context;
        this.optionItemList = optionItemList;
        this.isSingle = isSingle;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout optionLayout = null;

        //確定是單選或複選
        if(isSingle) {
            if(convertView == null){
                optionLayout = (LinearLayout) inflater.inflate(R.layout.item_option_single, null);
                RadioButton rb = (RadioButton) optionLayout.findViewById(R.id.rb_sideDish_optionName);
            }
            else{
                optionLayout = (LinearLayout) convertView;
            }
            OptionItem sideDish = optionItemList.get(position);

            RadioButton rbOptionName = (RadioButton) optionLayout.findViewById(R.id.rb_sideDish_optionName);
            rbOptionName.setText(sideDish.getOptionName());
            rbOptionName.setChecked(position == selectedPosition);
            rbOptionName.setTag(position);
            rbOptionName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedPosition = (Integer)view.getTag();
                    notifyDataSetChanged();
                }
            });

            TextView tvOption = optionLayout.findViewById(R.id.tv_sideDish_option);
            tvOption.setText(sideDish.getExtra());
        }
        else{
            if(convertView == null){
                optionLayout = (LinearLayout) inflater.inflate(R.layout.item_option_mutiple, null);
            }
            else{
                optionLayout = (LinearLayout) convertView;
            }
            OptionItem sideDish = optionItemList.get(position);

            CheckBox cbOptionName = optionLayout.findViewById(R.id.cb_sideDish_optionName);
            cbOptionName.setText(sideDish.getOptionName());

            TextView tvOption = optionLayout.findViewById(R.id.tv_sideDish_option);
            tvOption.setText(sideDish.getExtra());
        }

        return optionLayout;
    }
}
