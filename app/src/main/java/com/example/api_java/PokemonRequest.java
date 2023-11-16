package com.example.api_java;

import com.example.api_java.PokemonApi.Poke;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonRequest {
    @GET("pokemon?limit=150&offset=0")
    Call<Poke> getPokemonList();

    /*
    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Header("Authorization") String token);

    esa es la forma de introducir datos a la cabezera de la peticion

     */
}
