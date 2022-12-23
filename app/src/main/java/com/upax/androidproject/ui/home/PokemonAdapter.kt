package com.upax.androidproject.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upax.androidproject.R
import com.upax.androidproject.data.remote.response.Pokemon
import com.upax.androidproject.databinding.ItemPokemonBinding
import com.upax.androidproject.interfaces.onClickListener
import com.upax.androidproject.utils.ImageUtil

class PokemonAdapter(context: Context, listener: onClickListener): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private var listaPokemons: List<Pokemon> = listOf()
    private var mListener = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pokemon = listaPokemons[position]
        holder.initData(holder.pokemon, position)
    }

    override fun getItemCount(): Int {
        return listaPokemons.size
    }

    fun setData(lista: List<Pokemon>) {
        listaPokemons = lista
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemPokemonBinding.bind(itemView)
        lateinit var pokemon: Pokemon

        fun initData( pokemon: Pokemon, position: Int) {
            binding.pokemonPhotoText.visibility = View.VISIBLE
            binding.pokemonTitle.text = pokemon.name

            if (pokemon.url.contains(".npg") || pokemon.url.contains(".jpg") || pokemon.url.contains(".jpeg")) {
                ImageUtil.load(binding.pokemonPhoto, pokemon.url)
                binding.pokemonPhotoText.visibility = View.GONE
            } else { binding.pokemonPhotoText.text = pokemon.name.substring(0, 2).toUpperCase() }

            binding.pokemonItem.setOnClickListener{
                mListener.onClickItem(pokemon.url.split("/")[6].toInt(), position)
            }

        }
    }

}