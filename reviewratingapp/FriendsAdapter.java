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
 * Created by Monty on 21-08-2017.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendViewHolder> {
    public String[] myArrayList=new String[50];
    public String[] myArrayList2=new String[50];
     public  int KahanTak=0;
    public String j;
    public String s;
    Context context;
    public Response<AllListsResponse> res;
    //constructor begins
   public FriendsAdapter(Context con) {
       Log.d("Abhishek", "String reached" + ListViewActivity.myApiValue);
       context=con;
       Log.d("Abhishek", "onResponse1 called");
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(ListViewActivity.MAIL_CHIMP_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       Log.d("Abhishek", "onResponse2 called");
       MailChimpService service = retrofit.create(MailChimpService.class);
       Call c1 = service.getAllLists("bearer " + ListViewActivity.myApiValue);
       Log.d("Abhishek", "onResponse3 called");
       c1.enqueue(new Callback<AllListsResponse>() {
           @Override
           public void onResponse(Call<AllListsResponse> call, Response<AllListsResponse> response) {
               ListViewActivity.avl.setVisibility(ListViewActivity.avl.GONE);
               Log.d("Abhishek", "onResponse4 called");
               FriendsAdapter.this.res=response;
               int a=response.body().listsCount;
               Log.d("Abhishek",String.valueOf(a)+"hello");
               FriendsAdapter.this.KahanTak=a;
               FriendsAdapter.this.notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call<AllListsResponse> call, Throwable t) {
               Log.d("Abhishek", "onFailure called");
           }
       });
   }
   //constructor ends
    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d("Abhishek", "onCreateViewHolder called");
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycle_activity, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, final int position) {
        Log.d("Abhishek", "onBind called");
        TextView tv=(TextView)holder.itemView;
         j=res.body().lists.get(position).title;
        myArrayList[position]=j;
        tv.setText(j);
         s=res.body().lists.get(position).id;
        myArrayList2[position]=s;
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FriendsAdapter.this.context,CustomerListViewActivity.class);
                intent.putExtra(CustomerListViewActivity.MY_LIST_NAME, myArrayList[position]);
                intent.putExtra(CustomerListViewActivity.MY_LIST_ID,myArrayList2[position]);
                context.startActivity(intent);

            }
        });
        if(position % 2 == 0) {
            tv.setBackgroundColor(Color.WHITE);
        } else {
            tv.setBackgroundColor(Color.TRANSPARENT);
        }




    }

    @Override
    public int getItemCount() {
        Log.d("Abhishek", "onCount called");
        Log.d("Abhishek", "KahanTak"+this.KahanTak);
        return this.KahanTak;
    }
}
