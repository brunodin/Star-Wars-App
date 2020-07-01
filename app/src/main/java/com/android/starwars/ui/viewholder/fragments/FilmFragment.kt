package com.android.starwars.ui.viewholder.fragments

import android.content.Intent
import com.android.starwars.service.models.FilmModel
import com.android.starwars.ui.viewmodel.FilmViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.starwars.*
import com.android.starwars.listeners.OnCharacterClickListener
import com.android.starwars.ui.adapter.RecyclerViewAdapter
import com.android.starwars.ui.viewholder.Description
import kotlinx.android.synthetic.main.fragment_people.*

class FilmFragment : Fragment() {

    private lateinit var mFilmViewModel: FilmViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mFilmViewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_people, container, false)
        mFilmViewModel.initialListCharacters()
        observers()
        return root
    }

    private fun observers() {
        mFilmViewModel.text.observe(viewLifecycleOwner, Observer {
            val adapter =
                RecyclerViewAdapter(it, object :
                    OnCharacterClickListener<FilmModel> {
                    override fun onClickListener(item: FilmModel) {
                        val i = Intent(context, Description::class.java)
                        i.putExtra("info", item)
                        startActivity(i)
                    }
                })
            recyclerview_people.layoutManager = LinearLayoutManager(context)
            recyclerview_people.adapter = adapter
        })
    }

}