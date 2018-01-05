package com.example.monty.reviewratingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Monty on 18-09-2017.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListViewHolder> {
    public String[] myArrayList=new String[50];
    public String[] myArrayList2=new String[50];
     static Context context;
    public  int KahanTak=0;
    public String j1;
    public String j2;
    public String j3;
    public String s;
    public Response<AllCustomerListResponse> res;
    public CustomerListAdapter(Context cont){
        context=cont;
        Log.d("codekamp", "String reached" + ListViewActivity.myApiValue);

        Log.d("codekamp", "onResponse1 called");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ListViewActivity.MAIL_CHIMP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("codekamp", "onResponse2 called");
        MailChimpService service = retrofit.create(MailChimpService.class);
        Call c1 = service.getAllCustomerList("bearer " + ListViewActivity.myApiValue,CustomerListViewActivity.name);
        Log.d("codekamp", "onResponse3 called");
        c1.enqueue(new Callback<AllCustomerListResponse>() {
            @Override
            public void onResponse(Call<AllCustomerListResponse> call, Response<AllCustomerListResponse> response) {
                MyCustomerList.avl.setVisibility(MyCustomerList.avl.GONE);
                Log.d("codekamp", "onResponse4 called");
                CustomerListAdapter.this.res=response;
                Log.d("codekamp", "onResponse5 called");
                int a=response.body().count;
                Log.d("codekamp",String.valueOf(a)+"hello");
                if(a==13)
                CustomerListAdapter.this.KahanTak=a-3;
                else
                    CustomerListAdapter.this.KahanTak=a;
                CustomerListAdapter.this.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AllCustomerListResponse> call, Throwable t) {
                Log.d("codekamp", "onFailure called");
            }
        });
    }
    //constructor ends

    @Override
    public CustomerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycle_activity, parent, false);
        return new CustomerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomerListViewHolder holder, final int position) {
        Log.d("Abhishek", "onBind called");
        TextView tv=(TextView)holder.itemView;
        j1=res.body().members.get(position).email;
        j2=res.body().members.get(position).id.firstName;
        j3=res.body().members.get(position).id.lasttName;
       // j=res.body().members.get(position).id;
        myArrayList[position]=j2+""+j3;
        tv.setText(j2+""+j3);
       tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context,ReviewRating.class);
               intent.putExtra(ReviewRating.MY_CUSTOMER,myArrayList[position]);
               context.startActivity(intent);
           }
       });
        if(position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.WHITE);
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return this.KahanTak;
    }
}
