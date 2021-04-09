package com.cursoandroid.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.cursoandroid.retrofit.api.CepService;
import com.cursoandroid.retrofit.api.DataService;
import com.cursoandroid.retrofit.model.Cep;
import com.cursoandroid.retrofit.model.Foto;
import com.cursoandroid.retrofit.model.Post;

import java.util.List;

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

        String urlApiCep = "https://viacep.com.br/ws/";
        String urlApiFoto = "https://jsonplaceholder.typicode.com";
        String urlApiPost = "https://jsonplaceholder.typicode.com";

        connectRetrofit(urlApiPost);

        savePost();

//        getAllFotos();

        // getRecuperarCEP();


    }

    private void savePost() {
        Post post = new Post("3", "Algum titulo", "Alguma descrição de corpo");

        DataService dataService = retrofit.create(DataService.class);
        Call<Post> postCall = dataService.savePost(post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post body = response.body();
                    txtRetrofit.setText("ID: " + body.getId() +
                            " ,title: " + body.getTitle() +
                            " ,body: " + body.getBody());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void getAllFotos() {
        DataService dataService = retrofit.create(DataService.class);
        Call<List<Foto>> allFotos = dataService.getAllFotos();
        StringBuilder builder = new StringBuilder();
        allFotos.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                List<Foto> fotos = response.body();
                for (Foto foto : fotos) {
                    builder.append(foto.getId());
                }

                txtRetrofit.setText(builder.toString());
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {

            }
        });

    }

    private void connectRetrofit(String api) {
        retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getRecuperarCEP() {
        CepService cepService = retrofit.create(CepService.class);
        Call<Cep> recuperarCep = cepService.getRecuperarCep("69073060");
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