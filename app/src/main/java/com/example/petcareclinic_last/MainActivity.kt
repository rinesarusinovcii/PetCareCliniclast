package com.example.petcareclinic_last

import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity


import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.petcareclinic_last.R
import com.example.petcareclinic_last.databinding.ActivityMainBinding

import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup DrawerLayout
        drawerLayout = binding.drawerLayout

        // Setup NavController
        navController = findNavController(R.id.nav_host_fragment_container_main)

        // Setup AppBarConfiguration
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, // Replace with actual destination IDs
                R.id.sitterFragment,
                R.id.shopFragment
            // Add other top-level destinations as needed
            ),
            drawerLayout
        )

        // Setup ActionBar with NavController
        setSupportActionBar(binding.appBarMain.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        // Setup NavigationView with NavController
        val navigationView: NavigationView = binding.navigationView
        NavigationUI.setupWithNavController(navigationView, navController)

        // Setup Drawer Toggle
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.appBarMain.toolbar,
            R.string.open, R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}

