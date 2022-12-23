package com.upax.androidproject.models

import android.content.Context
import com.upax.androidproject.RetrofitProvider
import com.upax.androidproject.contracts.PokemonContract
import com.upax.androidproject.data.remote.PokemonApiService

class PokemonModel: PokemonContract.Model {
    private val apiService = RetrofitProvider.providesApiService(PokemonApiService::class.java)

    override fun getPokemons(onFinishedListener: PokemonContract.Model.OnFinishedListener) {
        apiService.getPokemons()
    }

}