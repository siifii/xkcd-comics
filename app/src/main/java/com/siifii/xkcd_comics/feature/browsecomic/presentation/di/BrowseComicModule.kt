package com.siifii.xkcd_comics.feature.browsecomic.presentation.di

import com.siifii.xkcd_comics.core.database.ComicsDatabase
import com.siifii.xkcd_comics.core.network.ServiceGenerator
import com.siifii.xkcd_comics.feature.bookmarkcomics.presentation.viewmodel.BookmarkedComicsViewModel
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.IBrowseComicLocalDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.IBrowseComicRemoteDataSource
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.local.dao.BrowseComicLocalDataSourceImp
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.BrowseComicRemoteDataSourceImp
import com.siifii.xkcd_comics.feature.browsecomic.data.datasource.remote.network.api.BrowseComicApiService
import com.siifii.xkcd_comics.feature.browsecomic.data.repository.BrowseComicRepositoryImp
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
        BrowseComicRemoteDataSourceImp(browseComicApiService)

    @Provides
    fun provideBrowseLocalDataSource(comicsDatabase: ComicsDatabase): IBrowseComicLocalDataSource =
        BrowseComicLocalDataSourceImp(comicsDatabase.comicDao())

    @Provides
    fun provideBrowseComicRepository(
        remoteDataSource: IBrowseComicRemoteDataSource,
        localDataSource: IBrowseComicLocalDataSource
    ): IBrowseComicRepository =
        BrowseComicRepositoryImp(remoteDataSource, localDataSource)

    @Provides
    fun provideBrowseInterActor(browseRepository: IBrowseComicRepository): BrowseComicInteractor =
        BrowseComicInteractor(browseRepository)

    @Provides
    fun provideBrowseComicViewModel(interactor: BrowseComicInteractor): BrowseComicsViewModel =
        BrowseComicsViewModel(interactor)

    @Provides
    fun provideFavouriteComicsViewModel(interactor: BrowseComicInteractor): BookmarkedComicsViewModel =
        BookmarkedComicsViewModel(interactor)
}