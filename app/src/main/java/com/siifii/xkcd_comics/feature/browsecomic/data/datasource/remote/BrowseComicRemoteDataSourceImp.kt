package com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote

import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.IBrowseComicRemoteDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.network.api.BrowseComicApiService
import com.siifii.xkcd_comics.feature.browsecomic.data.model.ComicModel
import io.reactivex.Observable
import javax.inject.Inject

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/

class BrowseComicRemoteDataSourceImp @Inject constructor(private val apiService: BrowseComicApiService) :
    IBrowseComicRemoteDataSource {

    override fun browseComic(comicNumber: String?): Observable<ComicModel> =
        apiService.getComic(comicNumber = comicNumber)

}