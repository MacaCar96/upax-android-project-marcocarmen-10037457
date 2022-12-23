package com.upax.androidproject.contracts

import com.upax.androidproject.data.remote.response.PokemonDetailResponse
import com.upax.androidproject.data.remote.response.PokemonsResponse

class PokemonDetailContract {

    interface View {
        fun onResult(pokemonDetail: PokemonDetailResponse)
        fun onError(error: String)
    }

    interface Presenter {
        fun getDetailPokemon(idPokemon: Int)
    }

    interface Model {

        interface OnFinishedListener {
            fun onResult(pokemonDetail: PokemonDetailResponse)
            fun onError(error: String)
        }

        fun getDetailPokemon(idPokemon: Int)

    }

}