package com.tavares.kaique.kaiquetavaresrm79173.api

import com.tavares.kaique.kaiquetavaresrm79173.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/api/v2/pokemon/{id}")
    fun buscarPokemon(@Path("id") id:String):Call<Pokemon>
}