package com.android.starwars.service.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpecieModel (

    @SerializedName("name")
    val name : String,
    @SerializedName("classification")
    val classification : String,
    @SerializedName("language")
    val language : String,
    @SerializedName("average_height")
    val averageHeight : String,
    @SerializedName("average_lifespan")
    val averageLifeSpan : String
): Serializable