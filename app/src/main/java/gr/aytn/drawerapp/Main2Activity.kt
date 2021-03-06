package gr.aytn.drawerapp

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import gr.aytn.drawerapp.config.App
import gr.aytn.drawerapp.config.prefs
import gr.aytn.drawerapp.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity(){

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view: View = binding.navView.getHeaderView(0)


        var txtName:TextView = view.findViewById(R.id.txtName)
        txtName.text = prefs.name + " " + prefs.surname
        Log.i("Main Activity Fullname" , App.prefs?.name + "" + App.prefs?.surname)
        var txtEmail:TextView = view.findViewById(R.id.txtEmail)
        txtEmail.text = prefs.email

        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain2.toolbar)

//        binding.appBarMain2.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView


        val navController = findNavController(R.id.nav_host_fragment_content_main2)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_history, R.id.nav_slideshow,R.id.nav_logout
            ), drawerLayout
        )


        val logoutMenuItem = binding.navView.menu.findItem(R.id.nav_logout)

        logoutMenuItem.setOnMenuItemClickListener {
            prefs.token = ""
            prefs.name = ""
            prefs.surname = ""
            prefs.email = ""
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            true
        }


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main2)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}