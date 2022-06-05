package com.example.lol_deliver.item;

public class FoodItem {
    private int imgResId;
    private String foodName;
    private String foodDetail;
    private String foodPrice;

    public FoodItem(int imgResId, String foodName, String foodDetail, String foodPrice){
        this.imgResId = imgResId;
        this.foodName = foodName;
        this.foodDetail = foodDetail;
        this.foodPrice = foodPrice;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getFoodName(){
        return foodName;
    }

    public String getFoodDetail() {
        return foodDetail;
    }

    public String getFoodPrice(){return foodPrice;}
}
