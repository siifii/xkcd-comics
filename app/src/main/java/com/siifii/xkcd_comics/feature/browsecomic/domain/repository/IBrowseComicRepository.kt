package com.siifii.xkcd_comics.feature.browsecomic.domain.repository

import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/
interface IBrowseComicRepository {
    fun browseComic(comicNumber: String?): Observable<ComicModelEntity>
    fun getAllComics(): Flowable<List<ComicModelEntity>>
    fun getComic(comicNumber: String?): Observable<ComicModelEntity>
    fun addComicToBookMark(comicModelEntity: ComicModelEntity): Completable
    fun deleteComic(comicNumber: Int): Completable

}