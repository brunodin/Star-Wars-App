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
import com.android.starwars.service.models.SpecieModel
import com.android.starwars.ui.adapter.RecyclerViewAdapter
import com.android.starwars.ui.viewholder.DescriptionAll
import com.android.starwars.ui.viewmodel.SpecieViewModel
import kotlinx.android.synthetic.main.fragment_people.*

class SpecieFragment : Fragment() {

    private lateinit var mSpecieViewModel: SpecieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mSpecieViewModel = ViewModelProvider(this).get(SpecieViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_people, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
        mSpecieViewModel.initializerList()
        observers()
        return root
    }

    private fun observers() {
        mSpecieViewModel.text.observe(viewLifecycleOwner, Observer {
            val adapter =
                RecyclerViewAdapter(it, object :
                    OnCharacterClickListener<SpecieModel> {
                    override fun onClickListener(item: SpecieModel) {
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
