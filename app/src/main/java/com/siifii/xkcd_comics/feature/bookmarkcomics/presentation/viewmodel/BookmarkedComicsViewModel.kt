package com.siifii.xkcd_comics.feature.bookmarkcomics.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.siifii.xkcd_comics.core.base.BaseViewModel
import com.siifii.xkcd_comics.core.extension.SingleLiveEvent
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import com.siifii.xkcd_comics.feature.browsecomic.domain.interactor.BrowseComicInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BookmarkedComicsViewModel(private val interactor: BrowseComicInteractor) : BaseViewModel() {
    var favouriteComics: MutableLiveData<List<ComicModelEntity>> = MutableLiveData()
    val messageToShow: SingleLiveEvent<String> = SingleLiveEvent()

    fun getBookmarkedComics() {
        launch {
            interactor.getAllComics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    favouriteComics.value = it
                }, {
                    messageToShow.postValue(it.message)
                })
        }
    }

    fun deleteBookmarkedComic(comicNumber: Int) {
        launch {
            interactor.deleteComic(comicNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    messageToShow.postValue("You have deleted comic #${comicNumber} from your bookmark")
                }, {
                    messageToShow.postValue(it.message)
                })
        }
    }
}