package com.android.starwars.ui.viewmodel

import android.app.Application
import android.provider.Contacts
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.starwars.listeners.ClientListener
import com.android.starwars.service.ClientRepository
import com.android.starwars.service.models.FilmModel
import com.android.starwars.service.models.PeopleModel

class FilmViewModel(application: Application) : AndroidViewModel(application) {

    private val mClientRepository = ClientRepository()

    private var  mteste = MutableLiveData<List<FilmModel>?>()
    val text: LiveData<List<FilmModel>?> = mteste

    fun initialListCharacters() {

        mClientRepository.film(object : ClientListener<FilmModel> {

            override fun onSuccess(model: List<FilmModel>) {
                mteste.value = model
            }

            override fun onFailure(model: String) {
                val s = ""
                TODO("Not yet implemented")
            }

        })
    }

}