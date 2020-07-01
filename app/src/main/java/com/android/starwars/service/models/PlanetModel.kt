package com.android.starwars.service.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlanetModel (

    @SerializedName("name")
    val name: String,
    @SerializedName("rotation_period")
    val rotationPeriod: Int,
    @SerializedName("orbital_period")
    val orbitalPeriod: Int,
    @SerializedName("climate")
    val climate: String,
    @SerializedName("terrain")
    val terrain: String,
    @SerializedName("population")
    val population: String

): Serializable