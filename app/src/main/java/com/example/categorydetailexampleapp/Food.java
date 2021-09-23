package com.example.categorydetailexampleapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {

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
            new Food("Waffles", 7.50, "Crispy Golden Brown", R.drawable.waffles),
            new Food("Oatmeal", 3.99, "One bowl of oatmeal with fruit on top", R.drawable.oatmeal),
    };

    public static final Food[] lunchItems = {
            new Food("Soup", 9.99, "One bowl of chicken soup", R.drawable.soup),
            new Food("Salad", 10.99, "One bowl of chicken Caesar salad", R.drawable.salad),
            new Food("Sandwich", 10.99, "One ham sandwich", R.drawable.sandwich),
    };

    public static final Food[] dinnerItems = {
            new Food("Pizza", 15.99, "Thin crust pizza", R.drawable.pizza),
            new Food("Pasta", 15.99, "One bowl of fettuccine pasta", R.drawable.pasta),
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

    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * @param parcel    the parcel that is received from the intent
     */

    public Food(Parcel parcel) {
        name = parcel.readString();
        price = parcel.readDouble();
        desc = parcel.readString();
        imageResourceID = parcel.readInt();
    }

    @Override
    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     */
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(desc);
        dest.writeInt(imageResourceID);
    }

    public Food() {
        name = "";
        price = 0;
        desc = "";
        imageResourceID = 0;
    }


    // this code is needed for the Food class to work with Parcelable
    // These methods look the same for any class that implements Parcelable
    // The only diff is the class name used (Ex. Food)
    public static final Parcelable.Creator<Food> CREATOR = new
            Parcelable.Creator<Food>() {

                @Override
                public Food createFromParcel(Parcel parcel) {
                    return new Food(parcel);
                }

                @Override
                public Food[] newArray(int size) {
                    return new Food[0];
                }
            };

    /**
     * This method is required for the Parceable interface.  As of now, this method * is in the default state and doesn't really do anything.
     *
     * If your Parcelable class will have child classes, you'll need to
     * take some extra care with the describeContents() method. This would
     * let you identify the specific child class that should be created by
     * the Parcelable.Creator. You can read more about how this works on
     *  Stack Overflow with this link.
     *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
     * @return
     */

    @Override
    public int describeContents() {
        return 0;
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

    public int getImageResourceID() {
        return imageResourceID;
    }

    // this toString method is called when we "print"  an object reference.
    // it is also called if you it as toString()
    // the reason we only want the name, is because this is what will be displayed
    // in our listView when we show the options the user can click on
    public String toString(){
        return this.name;
    }
}
