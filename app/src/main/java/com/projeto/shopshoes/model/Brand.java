package com.projeto.shopshoes.model;

import java.io.Serializable;

public class Brand  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int imageResource;
    private String name;

    public Brand(int imageResource, String name) {
        this.imageResource = imageResource;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}