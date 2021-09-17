package com.siifii.xkcd_comics.feature.browsecomic.domain.interactor

import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import com.siifii.xkcd_comics.feature.browsecomic.domain.repository.IBrowseComicRepository
import io.reactivex.Observable
import javax.inject.Inject

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/

class BrowseComicInteractor @Inject constructor(private val browseComicRepository: IBrowseComicRepository) {

    fun browseComic(comicNumber: String?): Observable<ComicModelEntity> =
        browseComicRepository.browseComic(comicNumber = comicNumber)

}