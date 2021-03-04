package com.kostya_windows.trackinggooglrmapapp.repositories

import android.util.Log
import com.kostya_windows.trackinggooglrmapapp.db.RunDao
import com.kostya_windows.trackinggooglrmapapp.model.Run
import javax.inject.Inject

class MainRepository
@Inject constructor(
    val dao:RunDao
)
{

    suspend fun insertRun(run: Run) = dao.insertRun(run)

    suspend fun deleteRun(run:Run) = dao.deleteRun(run)

    fun getAllRunsSortedByDate() = dao.getAllRunsSortedByDate()

    fun getAllRunsSortedByDistance() = dao.getAllRunsSortedByDistance()

    fun getAllRunsSortedByAvgSpeed() = dao.getAllRunsSortedByAvgSpeed()

    fun getAllRunsSortedByCaloriesBurned() = dao.getAllRunsSortedByCaloriesBurned()

    fun getTotalAvgSpeed() = dao.getTotalAvgSpeed()

    fun getTotalDistance() = dao.getTotalDistance()

    fun getTotalCaloriesBurned() = dao.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = dao.getTotalTimeInMillis()

}