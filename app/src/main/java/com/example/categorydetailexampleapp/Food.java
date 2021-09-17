package com.example.categorydetailexampleapp;

public class Food {
    private String name;
    private double price;
    private String desc;
    private int imageResourceID; // this will allow us to have a picture
                                    // AS catalogs images with int values

    public Food(String n, double p, String d, int i){
        name = n;
        price = p;
        desc = d;
        imageResourceID = i;
    }

    public Food(String name, double price, int i) {
        this.name = name;
        this.price = price;
        this.desc = ""; // default value so we don't get a null pointer error
        imageResourceID = i;
    }

    /*
    to auto generate code, go to Code --> Generate on the top menu
    make sure your cursor is positioned after the constructor (where you want the code to go)
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    // this toString method is called when we "print"  an object reference.
    // it is also called if you it as toString()
    // the reason we only want the name, is because this is what will be displayed
    // in our listView when we show the options the user can click on
    public String toString(){
        return this.name;
    }
}
