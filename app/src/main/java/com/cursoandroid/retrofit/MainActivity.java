package com.cursoandroid.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.cursoandroid.retrofit.api.CepService;
import com.cursoandroid.retrofit.model.Cep;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtRetrofit;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRetrofit = findViewById(R.id.txtRetrofit);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getRecuperarCEP();


    }

    public void getRecuperarCEP() {
        CepService cepService = retrofit.create(CepService.class);
        Call<Cep> recuperarCep = cepService.getRecuperarCep();
        recuperarCep.enqueue(new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                Cep cep = response.body();
                txtRetrofit.setText(cep.getLocalidade() + " / " + cep.getLogradouro() + " / " + cep.getBairro());
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {

            }
        });

    }
}