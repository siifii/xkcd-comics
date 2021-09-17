package com.siifii.xkcd_comics.feature.browsecomic.presentation.di

import com.siifii.xkcd_comics.core.service.ServiceGenerator
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.BrowseComicRemoteRemoteDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.IBrowseComicRemoteDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.network.api.BrowseComicApiService
import com.siifii.xkcd_comics.feature.browsecomic.data.repository.BrowseComicRepository
import com.siifii.xkcd_comics.feature.browsecomic.domain.interactor.BrowseComicInteractor
import com.siifii.xkcd_comics.feature.browsecomic.domain.repository.IBrowseComicRepository
import com.siifii.xkcd_comics.feature.browsecomic.presentation.viewmodel.BrowseComicsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/

@Module
@InstallIn(ActivityComponent::class)
object BrowseComicModule {

    @Provides
    fun provideBrowseComicApiService(): BrowseComicApiService =
        ServiceGenerator().createService(BrowseComicApiService::class.java)

    @Provides
    fun provideBrowseRemoteDataSource(browseComicApiService: BrowseComicApiService): IBrowseComicRemoteDataSource =
        BrowseComicRemoteRemoteDataSource(browseComicApiService)

    @Provides
    fun provideBrowseComicRepository(remoteRemoteDataSource: IBrowseComicRemoteDataSource): IBrowseComicRepository =
        BrowseComicRepository(remoteRemoteDataSource)

    @Provides
    fun provideBrowseInterActor(browseRepository: IBrowseComicRepository): BrowseComicInteractor =
        BrowseComicInteractor(browseRepository)

    @Provides
    fun provideBrowseComicViewModel(interactor: BrowseComicInteractor): BrowseComicsViewModel =
        BrowseComicsViewModel(interactor)
}