package com.cursoandroid.retrofit.api;

import com.cursoandroid.retrofit.model.Cep;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CepService {

    @GET("69073090/json/")
    Call<Cep> getRecuperarCep();

}
