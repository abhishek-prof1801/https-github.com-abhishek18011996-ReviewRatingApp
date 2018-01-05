package com.example.monty.reviewratingapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Monty on 17-09-2017.
 */

class AllListsResponse {
    @Expose
    @SerializedName("total_items")
    public int listsCount;


    @Expose
    @SerializedName("status")
    public int status_code;


    @Expose
    @SerializedName("lists")
    public ArrayList<MailchimpList> lists;
}
