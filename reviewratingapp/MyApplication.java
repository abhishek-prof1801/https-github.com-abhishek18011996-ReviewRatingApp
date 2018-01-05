package com.example.monty.reviewratingapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Monty on 26-09-2017.
 */

public class MyApplication extends Application {
    static Context con;

    @Override
    public void onCreate() {
        super.onCreate();
        con=this;
    }
}
