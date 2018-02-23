package com.example.oguzhanaydin.retrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/users/defunkt")
    Call<ResponseBody> getData();
}
