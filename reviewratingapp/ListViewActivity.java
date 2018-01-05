package com.example.monty.reviewratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Monty on 17-09-2017.
 */

public class ListViewActivity extends AppCompatActivity {
    public static final String MY_API_CONTAINER="My Api Value";
    public static String myApiValue;
    public static AVLoadingIndicatorView avl;
    public static final String MAIL_CHIMP_URL="https://us16.api.mailchimp.com/3.0/";
    public RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        avl=(AVLoadingIndicatorView)findViewById(R.id.avi);
        ListViewActivity.avl.show();
        Intent obj=getIntent();
         myApiValue=obj.getStringExtra(ListViewActivity.MY_API_CONTAINER);
        rv=(RecyclerView)findViewById(R.id.my_lists);
        rv.setLayoutManager(new LinearLayoutManager(this));
        FriendsAdapter f=new FriendsAdapter(this);
        rv.setAdapter(f);


    }
}
