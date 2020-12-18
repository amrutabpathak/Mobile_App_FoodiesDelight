package edu.neu.mad_sea.foodiesdelight.beans;

import java.util.List;

public class Order {
    private String userName;
    private String restaurantName;
    private List<CartItem> cartItems;
    private String orderUpdate;

    public Order(){

    }

    public Order(String userName, String restaurantName, List<CartItem> cartItems, String orderUpdate) {
        this.userName = userName;
        this.restaurantName = restaurantName;
        this.cartItems = cartItems;
        this.orderUpdate = orderUpdate;
    }

    public String getOrderUpdate() {
        return orderUpdate;
    }

    public void setOrderUpdate(String orderUpdate) {
        this.orderUpdate = orderUpdate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
