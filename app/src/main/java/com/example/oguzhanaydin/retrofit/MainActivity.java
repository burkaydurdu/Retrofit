package com.example.oguzhanaydin.retrofit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreateRetrofit();
        getData();
    }

    private void onCreateRetrofit() {
         retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();
    }
    private void getData() {
        Service service = retrofit.create(Service.class);
        Call<ResponseBody> call = service.getData();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                String data = null;
                try {
                    data = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("DATA => ", data);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
