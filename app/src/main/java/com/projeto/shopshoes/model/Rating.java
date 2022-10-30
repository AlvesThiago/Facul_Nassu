package com.projeto.shopshoes.model;

import java.io.Serializable;

public class Rating  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int amount;
    private int stars;

    public Rating(int amount, int stars) {
        this.amount = amount;
        this.stars = stars;
    }

    public int describeContents() {
        return 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}