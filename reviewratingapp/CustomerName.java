package com.example.monty.reviewratingapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Monty on 20-09-2017.
 */

public class CustomerName {
    @Expose
    @SerializedName("FNAME")
    public String firstName;
    @Expose
    @SerializedName("LNAME")
    public String lasttName;

}
