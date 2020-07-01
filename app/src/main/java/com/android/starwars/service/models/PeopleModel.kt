package com.android.starwars.service.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PeopleModel (


    @SerializedName("name")
    val name : String,
    @SerializedName("gender")
    val gender : String,
    @SerializedName("height")
    val height : Int,
    @SerializedName("mass")
    val mass : Int,
    @SerializedName("skin_color")
    val skinColor : String,
    @SerializedName("eye_color")
    val eyeColor : String,
    @SerializedName("birth_year")
    val birthYear : String,
    @SerializedName("hair_color")
    val hairColor : String
): Serializable
