package com.android.starwars.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.starwars.R
import com.android.starwars.listeners.OnCharacterClickListener
import com.android.starwars.service.models.FilmModel
import com.android.starwars.service.models.PeopleModel
import com.android.starwars.service.models.PlanetModel
import com.android.starwars.service.models.SpecieModel
import kotlinx.android.synthetic.main.character.view.*
import kotlinx.android.synthetic.main.character2.view.*


class RecyclerViewHolder<Z>(itemView: View, private val OnCharacterClickListener: OnCharacterClickListener<Z>): RecyclerView.ViewHolder(itemView) {

    private val context = itemView.context

    fun bind(item: (Z)){
        when (item) {
            is PeopleModel -> {
                itemView.text_character.text = context.getString(R.string.m_people_name, (item as PeopleModel).name)
                itemView.text_gender.text = context.getString(R.string.m_people_gender, (item as PeopleModel).gender)
                itemView.text_height.text = context.getString(R.string.m_people_height, (item as PeopleModel).height.toString())
                itemView.text_mass.text =  context.getString(R.string.m_people_mass, (item as PeopleModel).mass.toString())
            }
            is PlanetModel -> {
                itemView.text2_character.text = context.getString(R.string.m_planet_name, (item as PlanetModel).name)
                itemView.text2_mass.text = context.getString(R.string.m_planet_orbital_period, (item as PlanetModel).orbitalPeriod.toString())
//                itemView.text_height.text = context.getString(R.string.m_planet_population, (item as PlanetModel).population)
                itemView.text2_height.text = context.getString(R.string.m_planet_climate, (item as PlanetModel).climate)
//                itemView.text_character.text = "Nome: ${(item as PlanetModel).rotationPeriod}"
//                itemView.text_character.text = "Nome: ${(item as PlanetModel).terrain}"

            }
            is SpecieModel -> {
                itemView.text2_character.text = context.getString(R.string.m_specie_name, (item as SpecieModel).name)
//                itemView.text_mass.text = context.getString(R.string.m_specie_average_height, (item as SpecieModel).averageHeight)
                itemView.text2_mass.text = context.getString(R.string.m_specie_average_life_span, (item as SpecieModel).averageLifeSpan)
                itemView.text2_height.text = context.getString(R.string.m_specie_classification, (item as SpecieModel).classification)
//                itemView.text_character.text = "Nome: ${(item as SpecieModel).language}"
            }
            is FilmModel -> {
                itemView.text2_character.text = context.getString(R.string.m_film_nome, (item as FilmModel).title)
                itemView.text2_height.text = context.getString(R.string.m_film_director, (item as FilmModel).director)
//                itemView.text2_height.text = context.getString(R.string.m_film_episode_id, (item as FilmModel).episodeId)
//                itemView.text_gender.text = "Nome: ${(item as FilmModel).openingCrawl}"
                itemView.text2_mass.text = context.getString(R.string.m_film_release_date, (item as FilmModel).release_date)
            }
        }

    }

    fun listener(item: (Z)) {
        itemView.setOnClickListener{
            OnCharacterClickListener.onClickListener(item)
        }
    }
}
