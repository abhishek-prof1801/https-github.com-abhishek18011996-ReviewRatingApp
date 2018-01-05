package com.example.monty.reviewratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Monty on 24-09-2017.
 */

public class MailPoetActivity extends AppCompatActivity{
    private AVLoadingIndicatorView av;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_poet);
        av=(AVLoadingIndicatorView)findViewById(R.id.avi);
        av.show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("codekamp","executed"); // Do something after 5s = 5000ms

                Intent intent=new Intent(MailPoetActivity.this,MainActivity.class);
                startActivity(intent);
                MailPoetActivity.this.finish();


            }
        }, 10000);

    }
}
