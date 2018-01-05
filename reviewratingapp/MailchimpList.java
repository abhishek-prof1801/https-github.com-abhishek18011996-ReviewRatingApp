package com.example.monty.reviewratingapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Monty on 17-09-2017.
 */

class MailchimpList {
    @Expose
    @SerializedName("id")
    public String id;

    @Expose
    @SerializedName("name")
    public String title;

}
