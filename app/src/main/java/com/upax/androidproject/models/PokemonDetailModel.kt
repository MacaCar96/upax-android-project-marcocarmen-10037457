package com.upax.androidproject.models

import android.content.Context
import com.upax.androidproject.RetrofitProvider
import com.upax.androidproject.contracts.PokemonContract
import com.upax.androidproject.contracts.PokemonDetailContract
import com.upax.androidproject.data.remote.PokemonApiService
import com.upax.androidproject.data.remote.response.PokemonsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailModel: PokemonDetailContract.Model {
    private val apiService = RetrofitProvider.providesApiService(PokemonApiService::class.java)

    override fun getDetailPokemon(idPokemon: Int) {

    }


}