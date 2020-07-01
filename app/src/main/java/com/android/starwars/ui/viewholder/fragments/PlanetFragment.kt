package com.android.starwars.ui.viewholder.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.starwars.R
import com.android.starwars.listeners.OnCharacterClickListener
import com.android.starwars.service.models.PlanetModel
import com.android.starwars.ui.adapter.RecyclerViewAdapter
import com.android.starwars.ui.viewholder.DescriptionAll
import com.android.starwars.ui.viewmodel.PlanetViewModel
import kotlinx.android.synthetic.main.fragment_people.*

class PlanetFragment : Fragment() {

    private lateinit var mPlanetViewModel: PlanetViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlanetViewModel = ViewModelProvider(this).get(PlanetViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_people, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
        mPlanetViewModel.initializerList()
        observers()
        return root
    }

    private fun observers() {
        mPlanetViewModel.text.observe(viewLifecycleOwner, Observer {
            val adapter =
                RecyclerViewAdapter(it, object :
                    OnCharacterClickListener<PlanetModel> {
                    override fun onClickListener(item: PlanetModel) {
                        val i = Intent(context, DescriptionAll::class.java)
                        i.putExtra("info", item)
                        startActivity(i)
                    }

                })
            recyclerview_people.layoutManager = LinearLayoutManager(context)
            recyclerview_people.adapter = adapter
        })
    }
}
