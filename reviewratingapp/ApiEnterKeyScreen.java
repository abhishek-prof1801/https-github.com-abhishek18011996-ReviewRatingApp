package com.example.monty.reviewratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Monty on 17-09-2017.
 */

public class ApiEnterKeyScreen extends AppCompatActivity {
    EditText e1;
    EditText e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_enter_key_screen);
        e1=(EditText)findViewById(R.id.my_api_value);
         e2=(EditText)findViewById(R.id.my_name);
        SharedPrefs.parent=this;
        e2.setText(String.valueOf(SharedPrefs.getUserName()));
        e1.setText(String.valueOf(SharedPrefs.getApiKey()));
    }
    public void recyclerViewOrigin(View view){
        SharedPrefs.setUserName(e2.getText().toString());
        String apiValue=e1.getText().toString();
        SharedPrefs.setApiKey(apiValue);
        Intent intent=new Intent(this,ListViewActivity.class);
        intent.putExtra(ListViewActivity.MY_API_CONTAINER,apiValue);
        startActivity(intent);
    }
}
