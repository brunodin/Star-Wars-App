package com.android.starwars.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.starwars.listeners.ClientListener
import com.android.starwars.service.ClientRepository
import com.android.starwars.service.models.PlanetModel
import com.android.starwars.service.models.SpecieModel

class SpecieViewModel : ViewModel() {

    private val mClientRepository = ClientRepository()

    private var mteste = MutableLiveData<List<SpecieModel>>()
    val text: LiveData<List<SpecieModel>> = mteste

    fun initializerList() {

        mClientRepository.specie(object : ClientListener<SpecieModel> {
            override fun onSuccess(model: List<SpecieModel>) {
                mteste.value = model
            }

            override fun onFailure(model: String) {
                val s = ""
            }


        })
    }
}