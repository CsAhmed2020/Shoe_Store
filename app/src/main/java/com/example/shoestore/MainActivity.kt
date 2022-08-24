package com.example.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.ActivityMainBinding
import com.example.shoestore.databinding.ShoeDetailFragmentBinding
import com.example.shoestore.screens.shoeDetail.ShoeDetailFragmentDirections
import com.example.shoestore.screens.shoeListing.ShoeListingFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.tool_bar)
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
       NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration)

    }



}