package com.upax.androidproject.contracts

import com.upax.androidproject.data.remote.response.PokemonsResponse

class PokemonContract {

    interface View {
        fun onResult(pokemons: PokemonsResponse)
        fun onError(error: String)
    }

    interface Presenter {
        fun getPokemons(offset: Int, limit: Int)
    }

    interface Model {

        interface OnFinishedListener {
            fun onResult(pokemons: PokemonsResponse)
            fun onError(error: String)
        }

        fun getPokemons(onFinishedListener: OnFinishedListener, offset: Int, limit: Int)

    }

}