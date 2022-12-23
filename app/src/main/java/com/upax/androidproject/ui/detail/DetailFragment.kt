package com.upax.androidproject.ui.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.upax.androidproject.R
import com.upax.androidproject.common.Constans
import com.upax.androidproject.common.Constans.ARG_ID_POKEMON
import com.upax.androidproject.contracts.PokemonDetailContract
import com.upax.androidproject.data.remote.response.PokemonDetailResponse
import com.upax.androidproject.databinding.FragmentDetailBinding
import com.upax.androidproject.presenters.PokemonDetailPresenter

class DetailFragment : Fragment(), PokemonDetailContract.View {
    private lateinit var binding: FragmentDetailBinding
    private var idPokemon: Int? = null
    private lateinit var pokemonDetailPresenter: PokemonDetailPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonDetailPresenter = PokemonDetailPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idPokemon = it.getInt(Constans.ARG_ID_POKEMON)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }



    }

    companion object {

        fun getBundle(idPokemon: Int) = bundleOf(ARG_ID_POKEMON to idPokemon)
    }

    override fun onResult(pokemonDetail: PokemonDetailResponse) {
        //TODO("Not yet implemented")
    }

    override fun onError(error: String) {
        //TODO("Not yet implemented")
    }
}