package com.example.lol_deliver.item;

public class OptionItem {
    private String optionName;
    private String extra;

    public OptionItem(String optionName, int extra){
        this.optionName = optionName;
        this.extra = "+ $ " + Integer.toString(extra);
    }

    public OptionItem(String optionName){
        this.optionName = optionName;
        this.extra = "";
    }

    public String getOptionName() {
        return optionName;
    }

    public String getExtra() {
        return extra;
    }
}
