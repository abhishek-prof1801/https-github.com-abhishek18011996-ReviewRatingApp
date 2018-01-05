package com.example.monty.reviewratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Monty on 26-09-2017.
 */

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
          if(SharedPrefs.getApiKey()==null){
              Log.d("Abhishek","My Result true");
             intent=new Intent(this,MainActivity.class);}
          else {
              Log.d("Abhishek","My Result false");
              intent = new Intent(this, ApiEnterKeyScreen.class);

          }
        startActivity(intent);
    }
}
