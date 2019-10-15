package com.dell.demoretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackAPI {
    @GET("2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<Question> loadQuestion(@Query("tagged") String tag);

}
