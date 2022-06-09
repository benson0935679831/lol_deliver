package com.example.lol_deliver.item;

public class ShopItem {
    private String imgResId;
    private String shopName;
    private String shopDetail;
    private String shopStar;

    public ShopItem(String imgResId, String shopName, String shopDetail, String shopStar){
        this.imgResId = imgResId;
        this.shopName = shopName;
        this.shopDetail = shopDetail;
        this.shopStar = shopStar;
    }

    public String getImgResId() {
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
