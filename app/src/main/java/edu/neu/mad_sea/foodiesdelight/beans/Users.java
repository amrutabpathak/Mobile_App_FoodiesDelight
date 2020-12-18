package edu.neu.mad_sea.foodiesdelight.beans;

public class Users {
    private String userName;
    private String password;
    private boolean isCustomer;
    private boolean isRestaurantAuth;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    public boolean isRestaurantAuth() {
        return isRestaurantAuth;
    }

    public void setRestaurantAuth(boolean restaurantAuth) {
        isRestaurantAuth = restaurantAuth;
    }
}
