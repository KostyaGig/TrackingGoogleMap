package com.kostya_windows.trackinggooglrmapapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.kostya_windows.trackinggooglrmapapp.R
import com.kostya_windows.trackinggooglrmapapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tracking.*
import javax.inject.Inject

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {

    @Inject
    lateinit var viewModel: MainViewModel

    private var map:GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView?.onCreate(savedInstanceState)

        //load map
        mapView.getMapAsync {
            map = it
        }

    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        //when мало памяти
        mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //save currentstate
        //А при Oncreate мы будем создавать нашу map с Bundle которыц мы тут сохранили
        mapView?.onSaveInstanceState(outState)
    }
}