package com.projeto.shopshoes.model;

import android.annotation.SuppressLint;
import android.content.Context;

import com.projeto.shopshoes.R;

import java.io.Serializable;

public class ExtraInfo  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int stock;
    private String recommended;
    private String type;
    private String composition;
    private String fullDescription;

    public ExtraInfo(int stock, String recommended, String type, String composition, String fullDescription) {
        this.stock = stock;
        this.recommended = recommended;
        this.type = type;
        this.composition = composition;
        this.fullDescription = fullDescription;
    }
    @SuppressLint("DefaultLocale")
    public String getStockFormatted(Context context) {
        return String.format(
                "%s (%d %s)",
                context.getString(R.string.value_stok_invetory_amount),
                stock,
                context.getString(R.string.value_stok_invetory_end)
        );
    }
    public int describeContents() {
        return 0;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}