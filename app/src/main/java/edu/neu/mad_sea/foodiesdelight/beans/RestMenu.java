package edu.neu.mad_sea.foodiesdelight.beans;

public class RestMenu {

    private String menuName;
    private String menuDesc;

    public RestMenu() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public RestMenu(String menuName, String menuTitle, String menuImg, String price) {
        this.menuName = menuName;
        this.menuDesc = menuTitle;
        this.menuImg = menuImg;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    private String menuImg;
}
