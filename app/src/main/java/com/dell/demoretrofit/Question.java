package com.dell.demoretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {
    @SerializedName("items")
    @Expose
    List<Item> items;

    public List<Item> getItemList() {
        return items;
    }
}
