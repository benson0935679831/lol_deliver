package com.example.lol_deliver;

public class ShopItem {
    private int imgResId;
    private String shopName;
    private String shopDetail;

    public ShopItem(int imgResId, String shopName, String shopDetail){
        this.imgResId = imgResId;
        this.shopName = shopName;
        this.shopDetail = shopDetail;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getShopName(){
        return shopName;
    }

    public String getShopDetail() {
        return shopDetail;
    }
}
