package com.upax.androidproject.presenters

import com.upax.androidproject.contracts.PokemonContract
import com.upax.androidproject.contracts.PokemonDetailContract
import com.upax.androidproject.data.remote.response.PokemonDetailResponse
import com.upax.androidproject.data.remote.response.PokemonsResponse
import com.upax.androidproject.models.PokemonDetailModel
import com.upax.androidproject.models.PokemonModel

class PokemonDetailPresenter(private var view: PokemonDetailContract.View): PokemonDetailContract.Presenter, PokemonDetailContract.Model.OnFinishedListener {
    private val pokemonDetailModel = PokemonDetailModel()

    /** PokemonContract.Model */
    override fun getDetailPokemon(idPokemon: Int) {
        pokemonDetailModel.getDetailPokemon(idPokemon)
    }

    /** PokemonContract.View */
    override fun onResult(pokemonDetail: PokemonDetailResponse) {
        view.onResult(pokemonDetail)
    }

    override fun onError(error: String) {
        view.onError(error)
    }

}