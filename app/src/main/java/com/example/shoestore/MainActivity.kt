package com.example.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.screens.shoeDetail.ShoeDetailFragmentDirections
import com.example.shoestore.screens.shoeListing.ShoeListingFragmentDirections

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.tool_bar)
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
       NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.log_out -> {
                val currentDestination = navController.currentDestination?.id
                if (currentDestination == R.id.shoeListing_destination){
                    navController.navigate(ShoeListingFragmentDirections.actionShoeListingToStart())
                }else if (currentDestination == R.id.shoeDetail_destination){
                    navController.navigate(ShoeDetailFragmentDirections.actionShoeDetailToStart())
                }
            }


        }
        return super.onOptionsItemSelected(item)
    }

}