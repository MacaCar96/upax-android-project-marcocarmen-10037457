package com.upax.androidproject.presenters

import android.content.Context
import com.upax.androidproject.contracts.PokemonContract
import com.upax.androidproject.data.remote.response.PokemonsResponse
import com.upax.androidproject.models.PokemonModel

class PokemonPresenter(private var view: PokemonContract.View): PokemonContract.Presenter, PokemonContract.Model.OnFinishedListener {
    private val pokemonModel = PokemonModel()

    /** PokemonContract.Model */
    override fun getPokemons(offset: Int, limit: Int) {
        pokemonModel.getPokemons(this, offset, limit)
    }

    override fun getDetailPokemon(pokemonsResponse: PokemonsResponse) {
        TODO("Not yet implemented")
    }


    /** PokemonContract.View */

    override fun onResultPokemons(pokemons: PokemonsResponse) {

    }

    override fun onResult(pokemons: PokemonsResponse) {
        view.onResult(pokemons)
    }

    override fun onError(error: String) {
        view.onError(error)
    }

}