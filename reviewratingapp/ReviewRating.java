package com.example.monty.reviewratingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;



/**
 * Created by Monty on 20-09-2017.
 */

public class ReviewRating extends AppCompatActivity {
    public static final String MY_CUSTOMER="My Customer";
    AVLoadingIndicatorView av;
    TextView tv2;
    Thread t1=new Thread("my new Thread");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_rating);
        av=(AVLoadingIndicatorView)findViewById(R.id.avi) ;
        av.hide();

        tv2=(TextView)findViewById(R.id.my_result);
        tv2.setText("");
       Intent intent=getIntent();
        String value=intent.getStringExtra(ReviewRating.MY_CUSTOMER);
        Log.d("codekamp",value);
        TextView tv=(TextView)findViewById(R.id.my_customer_id);
        tv.setText(value);
        Button b=(Button)findViewById(R.id.my_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv2.setText("Thank You!Wait!"+"\n"+"Redirecting");
                av.show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("codekamp","executed"); // Do something after 5s = 5000ms

                        Intent intent=new Intent(ReviewRating.this,ApiEnterKeyScreen.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        ReviewRating.this.finish();


                    }
                }, 10000);




            }
        });
    }
}
