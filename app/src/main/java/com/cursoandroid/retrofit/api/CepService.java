package com.cursoandroid.retrofit.api;

import com.cursoandroid.retrofit.model.Cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("{cep}/json/")
    Call<Cep> getRecuperarCep(@Path("cep") String cep);

}
