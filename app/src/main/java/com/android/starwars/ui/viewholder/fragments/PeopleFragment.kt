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
import com.android.starwars.service.models.PeopleModel
import com.android.starwars.ui.adapter.RecyclerViewAdapter
import com.android.starwars.ui.viewholder.DescriptionAll
import com.android.starwars.ui.viewmodel.PeopleViewModel
import kotlinx.android.synthetic.main.fragment_people.*

class PeopleFragment : Fragment(){

    private lateinit var mPeopleViewModel: PeopleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPeopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_people, container, false)
        mPeopleViewModel.initialListCharacters()
        observers()
        return root
    }

    private fun observers() {
        mPeopleViewModel.text.observe(viewLifecycleOwner, Observer {
            val adapter =
                RecyclerViewAdapter(it, object :
                    OnCharacterClickListener<PeopleModel> {
                    override fun onClickListener(item: PeopleModel) {
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
