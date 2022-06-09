package com.example.lol_deliver.item;



public class OrderItem {
    private String foodName;
    private String foodPrice;
    private String foodQuantity;

    public OrderItem(String foodName, int foodPrice, int foodQuantity){
        this.foodName = foodName;
        this.foodPrice = "$ " + Integer.toString(foodPrice);
        this.foodQuantity = Integer.toString(foodQuantity) + "x";
    }

    public String getFoodName() { return foodName; }

    public String getFoodPrice() { return foodPrice; }

    public String getFoodQuantity() { return foodQuantity; }
}
