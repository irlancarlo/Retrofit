package com.cursoandroid.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtRetrofit;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("viacep.com.br/ws/69073060/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        txtRetrofit = findViewById(R.id.txtRetrofit);
    }
}