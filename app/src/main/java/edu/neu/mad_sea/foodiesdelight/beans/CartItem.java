package edu.neu.mad_sea.foodiesdelight.beans;

public class CartItem {


    private String dishName;
    private Integer dishQty;
    private Float dishPrice;

    public CartItem() {
    }

    public CartItem(String dishName, Integer dishQty, Float dishPrice) {
        this.dishName = dishName;
        this.dishQty = dishQty;
        this.dishPrice = dishPrice;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishQty() {
        return dishQty;
    }

    public void setDishQty(Integer dishQty) {
        this.dishQty = dishQty;
    }

    public Float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }
}
