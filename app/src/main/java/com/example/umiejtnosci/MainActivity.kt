package com.example.umiejtnosci

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        displayFragment(-1)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun displayFragment(id: Int) {
        val frag: Any = when (id) {

            R.id.mage_1 -> {
            MageFragment1()
            }
            R.id.mage_2 -> {
            MainFragment()
            }
            R.id.mage_3 -> {
            MainFragment()
            }
            R.id.rogue_1 -> {
            RogueFragment1()
            }
            R.id.rogue_2 -> {
            MainFragment()
            }
            R.id.rogue_3 -> {
            MainFragment()
            }
            R.id.warrior_1 -> {
                WarriorFragment1()
            }
            R.id.warrior_2 -> {
                WarriorFragment2()
            }
            R.id.warrior_3 -> {
                WarriorFragment3()
            }
            R.id.ranger_1 -> {
            RangerFragment1()
            }
            R.id.ranger_2 -> {
            MainFragment()
            }
            R.id.ranger_3 -> {
            MainFragment()
            }
            else -> {
                MainFragment()
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.relativeLayout, frag as Fragment)
            .commit()

    }

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            // Handle navigation view item clicks here.
            displayFragment(item.itemId)

            drawer_layout.closeDrawer(GravityCompat.START)
            return true
        }
    }

