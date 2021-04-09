package com.cursoandroid.retrofit.api;

import com.cursoandroid.retrofit.model.Foto;
import com.cursoandroid.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("/photos")
    Call<List<Foto>> getAllFotos();

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

}
