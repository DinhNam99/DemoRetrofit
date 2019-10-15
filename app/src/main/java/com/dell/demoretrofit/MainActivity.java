package com.dell.demoretrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnLoad;
    List<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        btnLoad = findViewById(R.id.btnLoad);
        final ArrayAdapter<Item> arrayAdapter
                = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(arrayAdapter);

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
                        List<Item> items = response.body().getItemList();
                        for (int i = 0; i < 5; i++) {
                            itemList.add(items.get(i));
                            Log.d("TAG", "onResponse" + items.get(i).toString());
                        }
                        arrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Question> call, Throwable t) {
                        Log.e("Failure", t.getMessage() + "");
                    }
                });
            }
        });

    }

}
