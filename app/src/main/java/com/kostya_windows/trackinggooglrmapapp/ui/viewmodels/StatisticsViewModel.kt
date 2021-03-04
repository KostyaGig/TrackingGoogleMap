package com.kostya_windows.trackinggooglrmapapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kostya_windows.trackinggooglrmapapp.repositories.MainRepository
import javax.inject.Inject

class StatisticsViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

}