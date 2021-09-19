package com.siifii.xkcd_comics.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.siifii.xkcd_comics.core.Constants.DATABASE_NAME
import com.siifii.xkcd_comics.core.database.ComicsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
Created by Kareem Alsaifi for  on 9/18/2021.
Copyright (c) 2021 . All rights reserved.
*/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideComicsDatabase(context: Context): ComicsDatabase {
        return Room.databaseBuilder(
            context, ComicsDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}