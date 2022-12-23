package com.upax.androidproject.data.remote.response

import com.google.gson.annotations.SerializedName

data class PokemonsResponseAll(
    val count: Int,
    val next: String,
    val previous: String? = null,
    val results: List<PokemonInfo>,
)

data class PokemonInfo(
    val name: String,
    val url: String,
    val info: PokemonDetailResponse,
)
