package com.example.lol_deliver;

public class ShopItem {
    private int imgResId;
    private String shopName;
    private String shopDetail;
    private String shopStar;

    public ShopItem(int imgResId, String shopName, String shopDetail, String shopStar){
        this.imgResId = imgResId;
        this.shopName = shopName;
        this.shopDetail = shopDetail;
        this.shopStar = shopStar;
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

    public String getShopStar(){return shopStar;}
}
