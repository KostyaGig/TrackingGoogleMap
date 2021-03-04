package com.kostya_windows.trackinggooglrmapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kostya_windows.trackinggooglrmapapp.db.RunDao
import com.kostya_windows.trackinggooglrmapapp.model.Run
import com.kostya_windows.trackinggooglrmapapp.ui.fragments.StatisticsFragment
import com.kostya_windows.trackinggooglrmapapp.ui.viewmodels.MainViewModel
import com.kostya_windows.trackinggooglrmapapp.ui.viewmodels.StatisticsViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
//import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setup toolbar
        setSupportActionBar(toolbar)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

        navHostFragment.findNavController()
            .addOnDestinationChangedListener{_,destination,_ ->
                when(destination.id){
                    R.id.settingsFragment,R.id.runFragment2,R.id.statisticsFragment -> bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
    }
}