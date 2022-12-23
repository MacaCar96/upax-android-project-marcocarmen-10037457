package com.upax.androidproject.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upax.androidproject.R
import com.upax.androidproject.contracts.PokemonContract
import com.upax.androidproject.data.remote.response.PokemonsResponse
import com.upax.androidproject.databinding.FragmentHomeBinding
import com.upax.androidproject.presenters.PokemonPresenter

class HomeFragment : Fragment(), PokemonContract.View {
    private lateinit var binding:  FragmentHomeBinding
    private lateinit var pokemonPresenter: PokemonPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonPresenter = PokemonPresenter(this)
        pokemonPresenter.getPokemons(0, 25)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment
    }

    override fun onResult(pokemons: PokemonsResponse) {
        Log.i("i-pokemons", "Pokemons -> ${pokemons.results.size}")
    }

    override fun onError(error: String) {
        Log.i("i-pokemons", "Error de respuesta -> $error")
    }
}