package com.example.categorydetailexampleapp;

public class Food {
    /*
    these final static arrays will represent the data for each category. If we have three
    categories, we will have 3 arrays. Each array can have as many elements as it wants.
    Each element in the category array will contain the data for the specific Food items in this category.

    as a placeholder, if you don't have your images yet, then you can put any integer

    static array means this array belongs to the Food class as a whole, not just to one particular Food item

    because the array is public, we can access it from other Activity files

    final means its values cannot change elsewhere in any other Activity files

    initializing the contents with an initializer list, ex for would be:
    int[] myNums = {1,2,3,4,5}
    String[] myNames = {"Kevin", "Zhou"}

    In this case, the array is of type Food, so we need to call the Food constructor to create new Food
    objects for each element in the array
    */

    public static final Food[] breakfastItems = {
            new Food("Pancakes", 6.99, "4 pancakes", R.drawable.pancake),
            new Food("Waffles", 7.50, "Crispy Golden Brown", 0),
    };

    public static final Food[] lunchItems = {
            new Food("Soup", 8.99, "One bowl of chicken soup", 0),
            new Food("Salad", 10.99, "One bowl of salad", 0),
    };

    public static final Food[] dinnerItems = {
            new Food("Pizza", 11.99, "A large slice of thin crust pizza", 0),
            new Food("Pasta", 10.99, "One bowl of pasta", 0),
    };


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
