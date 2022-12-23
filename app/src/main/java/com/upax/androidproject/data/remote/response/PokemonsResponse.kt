package com.upax.androidproject.data.remote.response

import com.google.gson.annotations.SerializedName

data class PokemonsResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<Pokemon>,
)

data class Pokemon(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)
