package com.siifii.xkcd_comics.feature.browsecomic.data.repository

import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.IBrowseComicRemoteDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.model.translate
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import com.siifii.xkcd_comics.feature.browsecomic.domain.repository.IBrowseComicRepository
import io.reactivex.Observable
import javax.inject.Inject

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/
class BrowseComicRepository @Inject constructor(private val remoteRemoteDataSource: IBrowseComicRemoteDataSource) :
    IBrowseComicRepository {

    override fun browseComic(comicNumber: String?): Observable<ComicModelEntity> =
        remoteRemoteDataSource.browseComic(comicNumber = comicNumber).map { it.translate() }

}