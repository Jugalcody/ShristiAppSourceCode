package com.example.shristi2k24;


public class SliderData {

    // image url is used to
    // store the url of image
    private String imgUrl;
    private int imgUrl2;
     String status;

    // Constructor method.
    public SliderData(String imgUrl,String s) {
        this.imgUrl = imgUrl;
        status=s;
    }
    public SliderData(int img,String s){
        this.imgUrl2=img;
        this.status=s;
    }

    // Getter method
    public String getImgUrlStr() {
        return imgUrl;

    }

    public int getImgUrlInt() {
        return imgUrl2;

    }


    // Setter method
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
