package com.cursoandroid.retrofit.api;

import com.cursoandroid.retrofit.model.Comment;
import com.cursoandroid.retrofit.model.Foto;
import com.cursoandroid.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataService {

    @GET("/photos")
    Call<List<Foto>> getAllFotos();

    @GET("/posts/{id}")
    Call<Post> getPostById(@Path("id") String id);

    // real url /comments?postId=1
    @GET("/comments")
    Call<List<Comment>> getCommentByParamIdPost(@Query("postId") String postId);

    // utiliza o formato json
    @POST("/posts")
    Call<Post> savePost(@Body Post post);

    // utiliza outro formato. Exemplo XML
    // userId=123&title=Alguma titulo&body=descricao do conteudo
    @FormUrlEncoded
    @POST("/posts")
    Call<Post> savePost(@Field("userId") String userId,
                        @Field("title") String title,
                        @Field("body") String body);

    // PUT sobrescreve todo os objeto post
    @PUT("/posts/{id}")
    Call<Post> updatePost(@Path("id") String id, @Body Post post);

    // PATCH atualiza somente os dados que são enviados
    @PATCH("/posts/{id}")
    Call<Post> updatePostByPatch(@Path("id") String id, @Body Post post);

}
