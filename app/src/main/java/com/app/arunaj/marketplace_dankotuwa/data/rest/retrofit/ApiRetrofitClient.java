package com.app.arunaj.marketplace_dankotuwa.data.rest.retrofit;

import com.app.arunaj.marketplace_dankotuwa.data.rest.ApiClient;
import com.squareup.okhttp.Interceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arunaj on 12/15/17.
 */

public class ApiRetrofitClient implements ApiClient {

    private ApiInterface mApiService;

    public ApiRetrofitClient() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS).
                        build();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        mApiService = retrofit.create(ApiInterface.class);
    }
}
