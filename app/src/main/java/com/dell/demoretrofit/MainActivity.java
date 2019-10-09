package com.dell.demoretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button btnLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textTest);
        btnLoad = findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder().
                        baseUrl("https://api.stackexchange.com").
                        addConverterFactory(GsonConverterFactory.create())
                        .build();

                StackAPI stackAPI = retrofit.create(StackAPI.class);
                Call<Question> stackOverFlowCall = stackAPI.loadQuestion("android");
                stackOverFlowCall.enqueue(new Callback<Question>() {
                    @Override
                    public void onResponse(Call<Question> call, Response<Question> response) {

                        Log.e("Response",response.body().getItemList().size()+"");
                    }

                    @Override
                    public void onFailure(Call<Question> call, Throwable t) {

                    }
                });
            }
        });

    }

}
