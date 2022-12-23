package com.upax.androidproject.data.remote

import com.upax.androidproject.data.remote.response.PokemonDetailResponse
import com.upax.androidproject.data.remote.response.PokemonsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon/")
    fun getPokemons(@Query("offset") offset: String, @Query("limit") limit: String): Call<PokemonsResponse>

    @GET("pokemon/{id}")
    fun getDetailPokemon(@Path("id") id: String,): Call<PokemonDetailResponse>

}