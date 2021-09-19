package com.siifii.xkcd_comics.feature.browsecomic.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.siifii.xkcd_comics.feature.browsecomic.data.model.ComicModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

/*
Created by Kareem Alsaifi for  on 9/18/2021.
Copyright (c) 2021 . All rights reserved.
*/

@Dao
interface IComicDao {
    @Query("SELECT * FROM comic")
    fun getAllComics(): Flowable<List<ComicModel>>

    @Query("SELECT * FROM comic where num = :comicNumber")
    fun getComic(comicNumber: String): Observable<ComicModel>

    @Query("DELETE FROM comic where num = :comicNumber")
    fun deleteComic(comicNumber: Int): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addComicToBookMark(comicModel: ComicModel): Completable

    @Query("DELETE FROM comic")
    fun clear()

}