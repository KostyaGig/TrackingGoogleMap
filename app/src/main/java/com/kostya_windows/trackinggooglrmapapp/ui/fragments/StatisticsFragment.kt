package com.kostya_windows.trackinggooglrmapapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kostya_windows.trackinggooglrmapapp.R
import com.kostya_windows.trackinggooglrmapapp.ui.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    @Inject
    lateinit var viewModel: StatisticsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}