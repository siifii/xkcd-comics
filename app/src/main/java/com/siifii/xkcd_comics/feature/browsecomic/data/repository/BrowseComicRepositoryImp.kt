package com.siifii.xkcd_comics.feature.browsecomic.data.repository

import android.annotation.SuppressLint
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.IBrowseComicLocalDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.IBrowseComicRemoteDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.model.translate
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import com.siifii.xkcd_comics.feature.browsecomic.domain.repository.IBrowseComicRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/
class BrowseComicRepositoryImp @Inject constructor(
    private val remoteDataSource: IBrowseComicRemoteDataSource,
    private val localDataSource: IBrowseComicLocalDataSource
) :
    IBrowseComicRepository {

    @SuppressLint("CheckResult")
    override fun browseComic(comicNumber: String?): Observable<ComicModelEntity> {
        var isSaved = false
        if (comicNumber.isNullOrEmpty()) {
            return remoteDataSource.browseComic(comicNumber).map { it.translate() }
        }
        getComic(comicNumber)
            .subscribeOn(Schedulers.io())
            .subscribe({
                isSaved = true
            }, {
                isSaved = false
            })

        return if (isSaved) {
            localDataSource.getComic(comicNumber)
        } else {
            remoteDataSource.browseComic(comicNumber).map { it.translate() }
        }
    }

    override fun getAllComics(): Flowable<List<ComicModelEntity>> =
        localDataSource.getAllComics()

    override fun getComic(comicNumber: String): Observable<ComicModelEntity> =
        localDataSource.getComic(comicNumber)

    override fun addComicToBookMark(comicModelEntity: ComicModelEntity) =
        localDataSource.addComicToBookMark(comicModelEntity)

    override fun deleteComic(comicNumber: Int) = localDataSource.deleteComic(comicNumber)

}