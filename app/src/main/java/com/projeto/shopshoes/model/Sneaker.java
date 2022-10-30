package com.projeto.shopshoes.model;

import java.io.Serializable;
import java.util.Locale;

public class Sneaker  implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String KEY = "SNEAKER_KEY";
    public static final String KEY_AMOUNT = "AMOUNT_SNEAKERS_KEY";
    private long id;
    private int imageResource;
    private int[] album;
    private String model;
    private Brand brand;
    private boolean isForMale;
    private boolean isForFemale;
    private Rating rating;
    private double price;
    private ExtraInfo extraInfo;

    public Sneaker(){
    }
    public Sneaker(long id, int imageResource, int[] album, String model, Brand brand, boolean isForMale, boolean isForFemale, Rating rating, double price, ExtraInfo extraInfo) {
        this.id = id;
        this.imageResource = imageResource;
        this.album = album;
        this.model = model;
        this.brand = brand;
        this.isForMale = isForMale;
        this.isForFemale = isForFemale;
        this.rating = rating;
        this.price = price;
        this.extraInfo = extraInfo;
    }

    public String getPriceAsString() {
        return String.format(Locale.FRANCE, "R$ %.2f", price);
    }

    public long getId() {
        return  this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getPriceParcelsAsString() {
        double value = price / 10;
        return String.format(Locale.FRANCE, "10x R$ %.2f", value);
    }

    public int describeContents() {
        return 0;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int[] getAlbum() {
        return album;
    }

    public void setAlbum(int[] album) {
        this.album = album;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isForMale() {
        return isForMale;
    }

    public void setForMale(boolean forMale) {
        isForMale = forMale;
    }

    public boolean isForFemale() {
        return isForFemale;
    }

    public void setForFemale(boolean forFemale) {
        isForFemale = forFemale;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    // To string
    @Override
    public String toString() {
        return "Sneaker{" +
                "id=" + id +
                ", imageResource=" + imageResource +
                ", album=" + album +
                ", model='" + model + '\'' +
                ", brand=" + brand +
                ", isForMale=" + isForMale +
                ", isForFemale=" + isForFemale +
                ", rating=" + rating +
                ", price=" + price +
                ", extraInfo=" + extraInfo +
                '}';
    }
}