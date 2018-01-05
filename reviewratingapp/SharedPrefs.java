package com.example.monty.reviewratingapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Monty on 21-09-2017.
 */

public class SharedPrefs {
    private static final String USER_NAME = "user_name";
    private static final String API_KEY="my_api_key";
    private static final String LIST_KEY="my_list_key";
    static Context parent=MyApplication.con;
    private static SharedPreferences getPrefrences() {
        return SharedPrefs.parent .getSharedPreferences("main", Context.MODE_PRIVATE);
    }
    public static void setUserName(String name) {
        getPrefrences().edit().putString(USER_NAME, name).commit();
    }
    public static String getUserName() {
        return getPrefrences().getString(USER_NAME, "");
    }
    public static void setApiKey(String apiKey) {
        getPrefrences().edit().putString(API_KEY, apiKey).commit();
    }
    public static String getApiKey() {
        return getPrefrences().getString(API_KEY, null);
    }
    public static void setListName(String listKey) {
        getPrefrences().edit().putString(LIST_KEY, listKey).commit();
    }
    public static String getListName() {
        return getPrefrences().getString(LIST_KEY, null);
    }

}
