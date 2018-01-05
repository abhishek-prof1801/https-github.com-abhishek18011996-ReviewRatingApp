package com.example.monty.reviewratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Monty on 18-09-2017.
 */

public class CustomerListViewActivity extends AppCompatActivity {
    public static final String MY_LIST_NAME="My Name";
    public static final String MY_LIST_ID="My Id";
    private static String id;
    public static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chosen);
        EditText e1=(EditText)findViewById(R.id.my_list_name);
        EditText e2=(EditText)findViewById(R.id.my_list_id);
        Intent intent=getIntent();
        id=intent.getStringExtra(MY_LIST_NAME);
        e1.setText(id);
        name=intent.getStringExtra(MY_LIST_ID);
        e2.setText(name);
        Button button=(Button)findViewById(R.id.my_login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomerListViewActivity.this,MyCustomerList.class);
                SharedPrefs.setListName(id);
                intent.putExtra(MyCustomerList.MY_LIST_NAME2,name);
                intent.putExtra(MyCustomerList.MY_LIST_ID1,id);
                startActivity(intent);


            }
        });

    }
}
