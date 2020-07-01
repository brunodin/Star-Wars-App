package com.android.starwars.service

import com.android.starwars.listeners.ClientListener
import com.android.starwars.service.models.*
import com.android.starwars.service.remote.ClientService
import com.android.starwars.service.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientRepository {

    private val remote = RetrofitClient.createService(ClientService::class.java)

    fun character(listener: ClientListener<PeopleModel>) {
        val call = remote.getPeople("")
        list(call, listener)

    }

    fun specie(listener: ClientListener<SpecieModel>) {
        val call = remote.getSpecie("")
        list(call, listener)
    }

    fun planet(listener: ClientListener<PlanetModel>) {
        val call = remote.getPlanet("")
        list(call, listener)
    }

    fun film(listener: ClientListener<FilmModel>) {
        val call = remote.getFilm("")
        list(call, listener)
    }

    private fun <Z> list(call: Call<ResultsModel<Z>>, listener: ClientListener<Z>) {

        call.enqueue(
            object : Callback<ResultsModel<Z>> {

                override fun onFailure(call: Call<ResultsModel<Z>>, t: Throwable) {
                    listener.onFailure("")
                }

                override fun onResponse(call: Call<ResultsModel<Z>>, response: Response<ResultsModel<Z>>) {
                    listener.onSuccess(response.body()?.results?: listOf())
                }
            })
    }

}