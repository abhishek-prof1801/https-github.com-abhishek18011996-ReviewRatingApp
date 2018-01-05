package com.example.monty.reviewratingapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Monty on 18-09-2017.
 */

public class CustomerDetail {
    @Expose
    @SerializedName("email_address")
    public String email;
    @Expose
    @SerializedName("merge_fields")
    public CustomerName id;



}
