package com.android.starwars.service.models

import com.android.starwars.service.models.PeopleModel
import com.google.gson.annotations.SerializedName

data class ResultsModel<S>(

    @SerializedName("results")
    val results: List<S>

)
