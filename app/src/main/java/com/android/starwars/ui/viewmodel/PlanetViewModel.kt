package com.android.starwars.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.starwars.listeners.ClientListener
import com.android.starwars.service.ClientRepository
import com.android.starwars.service.models.PlanetModel

class PlanetViewModel : ViewModel() {

    private val mClientRepository = ClientRepository()

    private var mteste = MutableLiveData<List<PlanetModel>>()
    val text: LiveData<List<PlanetModel>> = mteste

    fun initializerList() {

        mClientRepository.planet(object : ClientListener<PlanetModel> {
            override fun onSuccess(model: List<PlanetModel>) {

                mteste.value = model
            }

            override fun onFailure(model: String) {
                val s = ""
                TODO("Not yet implemented")
            }


        })
    }
}
