package com.android.starwars.ui.viewholder

import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.android.starwars.R
import com.android.starwars.service.constants.StarWarsConstants
import com.android.starwars.service.models.PeopleModel
import com.android.starwars.service.models.PlanetModel
import com.android.starwars.service.models.SpecieModel
import kotlinx.android.synthetic.main.activity_description_all.*

class DescriptionAll : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_all)
        image_back.setOnClickListener(this)
        replaceAttributes()
    }

    private fun replaceAttributes() {
        val model = intent.getSerializableExtra(StarWarsConstants.KeyWords.KEYWORD_INFO)
        when (model) {
            is PeopleModel -> {
                phrases(0, getString(R.string.m_people_name, model.name))
                phrases(1, getString(R.string.m_people_birth_year, model.birthYear))
                phrases(2, getString(R.string.m_people_gender, model.gender))
                phrases(3, getString(R.string.m_people_height, model.height.toString()))
                phrases(4, getString(R.string.m_people_mass, model.mass.toString()))
                phrases(5, getString(R.string.m_people_eye_color, model.eyeColor))
                phrases(6, getString(R.string.m_people_hair_color, model.hairColor))
                phrases(7, getString(R.string.m_people_skin_color, model.skinColor))

            }
            is PlanetModel -> {
                phrases(0, getString(R.string.m_planet_name, model.name))
                phrases(1, getString(R.string.m_planet_population, model.population))
                phrases(2, getString(R.string.m_planet_climate, model.climate))
                phrases(3, getString(R.string.m_planet_terrain, model.terrain))
                phrases(4, getString(R.string.m_planet_orbital_period, model.orbitalPeriod.toString()))
                phrases(5, getString(R.string.m_planet_rotation_period, model.rotationPeriod.toString()))
            }
            is SpecieModel -> {
                phrases(0, getString(R.string.m_specie_name, model.name))
                phrases(1, getString(R.string.m_specie_language, model.language))
                phrases(2, getString(R.string.m_specie_classification, model.classification))
                phrases(3, getString(R.string.m_specie_average_life_span, model.averageLifeSpan))
                phrases(4, getString(R.string.m_specie_average_height, model.averageHeight))
            }
        }
    }

    private fun phrases(i: Int, string: String) {
        when (i) {
            0 -> {
                text_title.text = string
                text_2.text = string
            }
            1 -> {
                text_3.text = string
            }
            2 -> {
                text_4.text = string
            }
            3 -> {
                text_5.text = string
                text_5.visibility = VISIBLE
            }
            4 -> {
                    text_6.text = string
                text_6.visibility = VISIBLE
            }
            5 -> {
                text_7.text = string
                text_7.visibility = VISIBLE
            }
            6 -> {
                text_8.text = string
                text_8.visibility = VISIBLE
            }
            7 -> {
                    text_9.text = string
                text_9.visibility = VISIBLE
            }
        }
    }

    override fun onClick(v: View?) {
        val id = v!!.id
        if (id == R.id.image_back) {
            onBackPressed()
        }
    }


}
