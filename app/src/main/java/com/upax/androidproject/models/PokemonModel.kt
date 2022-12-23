package com.upax.androidproject.models

import android.content.Context
import com.upax.androidproject.RetrofitProvider
import com.upax.androidproject.contracts.PokemonContract
import com.upax.androidproject.data.remote.PokemonApiService
import com.upax.androidproject.data.remote.response.PokemonsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonModel: PokemonContract.Model {
    val apiService = RetrofitProvider.providesApiService(PokemonApiService::class.java)

    override fun getPokemons(
        onFinishedListener: PokemonContract.Model.OnFinishedListener,
        offset: Int,
        limit: Int
    ) {
        val call = apiService.getPokemons(offset.toString(), limit.toString())
        call.enqueue(object : Callback<PokemonsResponse> {
            override fun onResponse(
                call: Call<PokemonsResponse>,
                response: Response<PokemonsResponse>
            ) {
                if (response.isSuccessful) {
                    var pokemonsResponse = response.body()
                    if (pokemonsResponse != null){
                        onFinishedListener.onResult(pokemonsResponse)
                    } else {onFinishedListener.onError("Error: la respuesta es null") }
                } else { onFinishedListener.onError("Error: Hubo un error en la respuesta") }

            }

            override fun onFailure(call: Call<PokemonsResponse>, t: Throwable) {
                onFinishedListener.onError(t.toString())
            }

        })
    }

    override fun getDetailPokemon(pokemonsResponse: PokemonsResponse) {

    }

}