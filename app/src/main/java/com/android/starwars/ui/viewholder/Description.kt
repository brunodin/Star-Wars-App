package com.android.starwars.ui.viewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.starwars.R
import com.android.starwars.service.constants.StarWarsConstants.KeyWords.KEYWORD_INFO
import com.android.starwars.service.models.FilmModel
import kotlinx.android.synthetic.main.activity_description.*

class Description : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        image_back.setOnClickListener(this)
        replaceAttributes()

    }

    private fun replaceAttributes() {
        val model = intent.getSerializableExtra(KEYWORD_INFO)
        text_title.text = (model as FilmModel).title
        text_name.text = getString(R.string.opening_crawl, model.episodeId, model.title)
        text_directors_name.text = model.director
        text_opening.text = model.openingCrawl
        text_release_date.text = model.release_date
    }

    override fun onClick(v: View?) {
        val id = v!!.id
        if (id == R.id.image_back){
            onBackPressed()
            finish()
        }
    }



}
