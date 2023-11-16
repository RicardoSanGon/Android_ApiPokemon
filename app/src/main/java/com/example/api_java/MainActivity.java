package com.example.api_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.api_java.Adapter.PokeAdapter;
import com.example.api_java.PokemonApi.Poke;
import com.example.api_java.PokemonApi.ResultApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPoke;

    PokeAdapter pokeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPoke=findViewById(R.id.rvPokemon);
        getPokemon();
    }

    private void getPokemon() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokemonRequest pokemonRequest = retrofit.create(PokemonRequest.class);
        Call<Poke> call = pokemonRequest.getPokemonList();
        call.enqueue(new Callback<Poke>() {
            @Override
            public void onResponse(Call<Poke> call, Response<Poke> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                Poke poke = response.body();
                List<ResultApi> results = poke.getResults();
                pokeAdapter = new PokeAdapter(results);
                rvPoke.setAdapter(pokeAdapter);
                rvPoke.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvPoke.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<Poke> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}