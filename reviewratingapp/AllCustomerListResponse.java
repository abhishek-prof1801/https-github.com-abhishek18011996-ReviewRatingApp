package com.example.monty.reviewratingapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Monty on 18-09-2017.
 */

public class AllCustomerListResponse {
    @Expose
    @SerializedName("total_items")
    public int count;
    @Expose
    @SerializedName("members")
    public ArrayList<CustomerDetail> members;
}
