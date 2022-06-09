package com.example.lol_deliver.item;

public class ShopItem {
    private String imgResId;
    private String shopName;
    private String shopDetail;
    private String shopStar;
    private String shopId;

    public ShopItem(String imgResId, String shopName, String shopDetail, String shopStar, String shopId){
        this.imgResId = imgResId;
        this.shopName = shopName;
        this.shopDetail = shopDetail;
        this.shopStar = shopStar;
        this.shopId = shopId;
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

    public String getShopId(){return shopId;}
}
