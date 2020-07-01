package com.android.starwars.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.starwars.R
import com.android.starwars.listeners.OnCharacterClickListener
import com.android.starwars.service.models.PeopleModel
import com.android.starwars.ui.viewholder.RecyclerViewHolder

class RecyclerViewAdapter<Z>(private val list: List<Z>?, private val onCharacterClickListener: OnCharacterClickListener<Z> ) : RecyclerView.Adapter<RecyclerViewHolder<Z>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<Z> {
       if (viewType == 1) {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.character, parent, false)
           return RecyclerViewHolder(view, onCharacterClickListener)
       }else{
           val view = LayoutInflater.from(parent.context).inflate(R.layout.character2, parent, false)
           return RecyclerViewHolder(view, onCharacterClickListener)
       }
    }

    override fun getItemViewType(position: Int): Int {
        return if (list?.get(position) is PeopleModel){
             1
        }else{
            0
        }

    }
    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder<Z>, position: Int) {
        val item = list?.get(position)
        item?.let {
            holder.bind(item)
            holder.listener(item)
        }
    }
}
