package com.kostya_windows.trackinggooglrmapapp.di

import android.content.Context
import androidx.room.Room
import com.kostya_windows.trackinggooglrmapapp.db.RunDao
import com.kostya_windows.trackinggooglrmapapp.db.RunDatabase
import com.kostya_windows.trackinggooglrmapapp.other.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunDatabase(@ApplicationContext context: Context):RunDatabase{
        return Room.databaseBuilder(context,RunDatabase::class.java,Constans.RUNNING_DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun provideRunDao(database: RunDatabase):RunDao{
        return database.runDao()
    }
}