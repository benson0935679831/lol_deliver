package com.example.lol_deliver.item;

public class SidebarItem {
    private int imgResId;
    private String navigationName;

    public SidebarItem(int imgResId, String navigationName){
        this.imgResId = imgResId;
        this.navigationName = navigationName;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getNavigationName(){
        return navigationName;
    }
}
