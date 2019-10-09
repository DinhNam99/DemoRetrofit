package com.dell.demoretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("link")
    @Expose
    String link;

    @Override
    public String toString() {
        return (title);
    }
}
