package com.siifii.xkcd_comics.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.siifii.xkcd_comics.core.Constants.DATABASE_VERSION
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.local.dao.IComicDao
import com.siifii.xkcd_comics.feature.browsecomic.data.model.ComicModel

/*
Created by Kareem Alsaifi for  on 9/18/2021.
Copyright (c) 2021 . All rights reserved.
*/

@Database(entities = [ComicModel::class], version = DATABASE_VERSION, exportSchema = false)
abstract class ComicsDatabase : RoomDatabase() {
    abstract fun comicDao(): IComicDao
}