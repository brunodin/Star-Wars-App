package com.android.starwars.listeners


interface ClientListener<Z>{
    fun onSuccess(model: List<Z>)
    fun onFailure(model: String)
}