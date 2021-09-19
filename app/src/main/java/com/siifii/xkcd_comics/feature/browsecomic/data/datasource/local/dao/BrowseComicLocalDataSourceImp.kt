package com.siifii.xkcd_comics.feature.browsecomic.data.datasource.local.dao

import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.IBrowseComicLocalDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.model.translate
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/*
Created by Kareem Alsaifi for  on 9/18/2021.
Copyright (c) 2021 . All rights reserved.
*/

@Singleton
class BrowseComicLocalDataSourceImp @Inject constructor(private val dao: IComicDao) :
    IBrowseComicLocalDataSource {

    override fun getAllComics(): Flowable<List<ComicModelEntity>> = dao.getAllComics().map {
        if (it.isEmpty()) {
            throw Exception("There is no data")
        }
        it.translate()
    }

    override fun getComic(comicNumber: String?): Observable<ComicModelEntity> =
        dao.getComic(comicNumber).map { it.translate() }

    override fun addComicToBookMark(comicModelEntity: ComicModelEntity): Completable =
        dao.addComicToBookMark(comicModelEntity.translate())

    override fun deleteComic(comicNumber: Int): Completable = dao.deleteComic(comicNumber)
}