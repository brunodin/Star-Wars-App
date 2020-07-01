package com.android.starwars.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.starwars.listeners.ClientListener
import com.android.starwars.service.ClientRepository
import com.android.starwars.service.models.PeopleModel

class PeopleViewModel(application: Application) : AndroidViewModel(application) {

    private val mClientRepository = ClientRepository()

   private var  mteste = MutableLiveData<List<PeopleModel>?>()
    val text: LiveData<List<PeopleModel>?> = mteste

    fun initialListCharacters() {

        mClientRepository.character(object : ClientListener<PeopleModel> {

            override fun onSuccess(model: List<PeopleModel>) {
                mteste.value = model
            }

            override fun onFailure(model: String) {
                val s = ""
                TODO("Not yet implemented")
            }

        })
    }

}