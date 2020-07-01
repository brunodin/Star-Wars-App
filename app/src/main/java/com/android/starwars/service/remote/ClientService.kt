package com.android.starwars.service.remote

import com.android.starwars.service.constants.StarWarsConstants
import com.android.starwars.service.constants.StarWarsConstants.URL.FILM_URL
import com.android.starwars.service.constants.StarWarsConstants.URL.PEOPLE_URL
import com.android.starwars.service.constants.StarWarsConstants.URL.PLANET_URL
import com.android.starwars.service.constants.StarWarsConstants.URL.SPECIE_URL
import com.android.starwars.service.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientService {

    @GET(PEOPLE_URL)
    fun getPeople(@Query("search") search: String): Call<ResultsModel<PeopleModel>>

    @GET(FILM_URL)
    fun getFilm(@Query("search") search: String): Call<ResultsModel<FilmModel>>

    @GET(PLANET_URL)
    fun getPlanet(@Query("search") search: String): Call<ResultsModel<PlanetModel>>

    @GET(SPECIE_URL)
    fun getSpecie(@Query("search") search: String): Call<ResultsModel<SpecieModel>>

}