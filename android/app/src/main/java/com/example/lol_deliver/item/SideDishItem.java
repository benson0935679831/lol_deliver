package com.example.lol_deliver.item;

public class SideDishItem {
    private String cateName;
    private boolean canNull;
    private String optionQuan;
    private String optionDesc;

    public SideDishItem(String cateName, int optionQuan, boolean canNull, String optionDesc){
        this.cateName = cateName;
        this.canNull = canNull;
        if(canNull) {//選填
            this.optionQuan = "可選";
        }
        else {//必填
            this.optionQuan = Integer.toString(optionQuan) + "必填";
        }
        this.optionDesc = optionDesc;
    }

    public String getCateName() {
        return cateName;
    }

    public String getOptionQuan() {
        return optionQuan;
    }

    public String getOptionDesc() {
        return optionDesc;
    }

    public boolean getCanNull(){
        return canNull;
    }
}
