package com.dell.demoretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("title")
    @Expose
    String title;
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return (title);
    }
}
