package com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote

import com.siifii.xkcd_comics.feature.browsecomic.data.model.ComicModel
import io.reactivex.Observable

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/
interface IBrowseComicRemoteDataSource {
    fun browseComic(comicNumber: String?): Observable<ComicModel>

}