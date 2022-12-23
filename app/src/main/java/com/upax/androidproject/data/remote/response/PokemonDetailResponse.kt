package com.upax.androidproject.data.remote.response

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprite") val sprite: Sprite,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("types") val types: List<Types>,
)

data class Sprite(
    @SerializedName("front_default") val frontDefault: String,
)

data class Types(
    @SerializedName("type") val type: Type,
)

data class Type(
    @SerializedName("name") val name: String,
)
