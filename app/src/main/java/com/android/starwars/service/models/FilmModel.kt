package com.android.starwars.service.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmModel (
    @SerializedName("title")
    val title: String,
    @SerializedName("episode_id")
    val episodeId: Int,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("release_date")
    val release_date: String
): Serializable