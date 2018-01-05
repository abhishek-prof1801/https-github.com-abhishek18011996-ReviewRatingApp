package com.example.monty.reviewratingapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Monty on 17-09-2017.
 */

public interface MailChimpService {
    @GET("lists")
    Call<AllListsResponse> getAllLists(@Header("Authorization") String auth);
    @GET("lists/{xyz}/members")
    Call<AllCustomerListResponse>getAllCustomerList(@Header("Authorization") String auth,
                                                    @Path("xyz") String Id);

}

