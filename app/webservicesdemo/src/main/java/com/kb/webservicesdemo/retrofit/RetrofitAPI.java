package com.kb.webservicesdemo.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("users")
    Call<DataModal> createPost(@Body DataModal dataModal);

    @GET("/api/users/2")
    Call<RandomUserDataModel> getRandomUser();
}
