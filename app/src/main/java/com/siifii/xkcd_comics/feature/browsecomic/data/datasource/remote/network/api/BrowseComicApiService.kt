package com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.network.api

import com.siifii.xkcd_comics.feature.browsecomic.data.model.ComicModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/
interface BrowseComicApiService {
    @GET("{comic_number}/info.0.json")
    fun getComic(@Path("comic_number") comicNumber: String?): Observable<ComicModel>

}