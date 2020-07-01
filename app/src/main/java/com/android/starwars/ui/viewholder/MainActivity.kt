package com.android.starwars.ui.viewholder

import android.app.SearchManager
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.android.starwars.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Toolbar
        val mToolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_menu)
        setSupportActionBar(mToolbar)
        mToolbar.
        //button bottom nav
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_people,
                R.id.navigation_planet,
                R.id.navigation_film
            )
        )
        navView.setupWithNavController(navController)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Inflate the options menu from XML
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        //Get the SearchView and set the searchable configuration
        val mSearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val mSearchItem = menu?.findItem(R.id.menu_search)
        mSearchItem?.setIcon(R.drawable.ic_search)
        MenuItemCompat.getActionView(mSearchItem)
        val mSearchView = mSearchItem?.actionView as SearchView

        mSearchView.setSearchableInfo(mSearchManager.getSearchableInfo(componentName))

        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                mSearchView.clearFocus()
                mSearchView.setQuery("", false)
                Toast.makeText(baseContext, "$query", Toast.LENGTH_LONG).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        return true
    }

}
