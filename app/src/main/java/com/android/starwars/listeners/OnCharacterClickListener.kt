package com.android.starwars.listeners

import com.android.starwars.service.models.PeopleModel


interface OnCharacterClickListener<Z> {

    fun onClickListener(item: (Z))
}
