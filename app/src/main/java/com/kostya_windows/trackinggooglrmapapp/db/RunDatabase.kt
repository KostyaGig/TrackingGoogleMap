package com.kostya_windows.trackinggooglrmapapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kostya_windows.trackinggooglrmapapp.model.Run

@Database(
    entities = [Run::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RunDatabase : RoomDatabase() {

    abstract fun runDao():RunDao

}