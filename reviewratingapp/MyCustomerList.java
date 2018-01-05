package com.example.monty.reviewratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Monty on 18-09-2017.
 */

public class MyCustomerList extends AppCompatActivity {
    public static final String MY_LIST_NAME2="My Name";
    public static final String MY_LIST_ID1="My Id";
    public static String id;
    public static AVLoadingIndicatorView avl;

    private static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_customer_list);
        avl=(AVLoadingIndicatorView)findViewById(R.id.avi);
        MyCustomerList.avl.show();
        Intent intent=getIntent();
        MyCustomerList.name=intent.getStringExtra(MY_LIST_NAME2);
        MyCustomerList.id=intent.getStringExtra(MY_LIST_ID1);
        RecyclerView rv=(RecyclerView)findViewById(R.id.my_recycle);
        rv.setLayoutManager(new LinearLayoutManager(this));
        CustomerListAdapter adapter=new CustomerListAdapter(this);
        rv.setAdapter(adapter);


    }
}
