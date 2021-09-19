package com.siifii.xkcd_comics.feature.browsecomic.data.datasource

import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

/*
Created by Kareem Alsaifi for  on 9/18/2021.
Copyright (c) 2021 . All rights reserved.
*/
interface IBrowseComicLocalDataSource {
    fun getAllComics(): Flowable<List<ComicModelEntity>>
    fun getComic(comicNumber: String?): Observable<ComicModelEntity>
    fun addComicToBookMark(comicModelEntity: ComicModelEntity): Completable
    fun deleteComic(comicNumber: Int): Completable
}