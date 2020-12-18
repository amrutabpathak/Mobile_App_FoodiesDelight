package edu.neu.mad_sea.foodiesdelight.beans;

public class Restaurant {

    private String restTitle;
    private String restLocation;
    private String restDesc;
    public Restaurant(){

    }
    public Restaurant(String restTitle, String restLocation, String restDesc, String restImage, String restBGImg) {
        this.restTitle = restTitle;
        this.restLocation = restLocation;
        this.restDesc = restDesc;
        this.restImage = restImage;
        this.restBGImg = restBGImg;
    }

    private String restImage;

    public String getRestImage() {
        return restImage;
    }

    public void setRestImage(String restImage) {
        this.restImage = restImage;
    }

    public String getRestTitle() {
        return restTitle;
    }

    public void setRestTitle(String restTitle) {
        this.restTitle = restTitle;
    }

    public String getRestLocation() {
        return restLocation;
    }

    public void setRestLocation(String restLocation) {
        this.restLocation = restLocation;
    }

    public String getRestDesc() {
        return restDesc;
    }

    public void setRestDesc(String restDesc) {
        this.restDesc = restDesc;
    }

    public String getRestBGImg() {
        return restBGImg;
    }

    public void setRestBGImg(String restBGImg) {
        this.restBGImg = restBGImg;
    }

    private String restBGImg;
}
