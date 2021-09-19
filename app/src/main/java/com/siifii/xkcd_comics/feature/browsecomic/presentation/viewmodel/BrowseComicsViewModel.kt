package com.siifii.xkcd_comics.feature.browsecomic.presentation.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.siifii.xkcd_comics.core.base.BaseViewModel
import com.siifii.xkcd_comics.core.extension.*
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import com.siifii.xkcd_comics.feature.browsecomic.domain.interactor.BrowseComicInteractor
import dagger.hilt.android.scopes.ActivityScoped
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScoped
class BrowseComicsViewModel @Inject constructor(private val interactor: BrowseComicInteractor) :
    BaseViewModel() {

    private var isCurrentComic = false
    private val currentComicNumber: MutableLiveData<Int?> = MutableLiveData<Int?>()
    val messageToShow: SingleLiveEvent<String> = SingleLiveEvent()
    val comicNumber: MutableLiveData<Int> = MutableLiveData<Int>()
    val comicModelLiveData: MutableLiveData<ComicModelEntity> = MutableLiveData<ComicModelEntity>()
    val browseComicResource = SingleLiveEvent<Resource<ComicModelEntity>>()

    fun browseComic() {
        launch {
            interactor.browseComic(if (comicNumber.value != null) comicNumber.value.toString() else "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { browseComicResource.setLoading() }
                .subscribe({
                    if (!isCurrentComic) {
                        comicNumber.value = it.num
                        currentComicNumber.value = it.num
                    }
                    comicModelLiveData.value = it
                    browseComicResource.setSuccess(it)
                    isCurrentComic = true
                }, {
                    browseComicResource.setError(it)
                })
        }
    }

    fun addComicToBookMark(view: View) {
        launch {
            interactor.addComicToBookMark(comicModelLiveData.value!!)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    comicModelLiveData.value!!.isBookmarked = true
                    messageToShow.postValue("You have added comic #${comicModelLiveData.value!!.num} to your bookmark")

                }, {
                    messageToShow.postValue(it.message)
                })
        }
    }

    fun onPreviousComicClicked(view: View) {
        if (comicNumber.value!! > 1) {
            comicNumber.value = comicNumber.value?.minus(1)
            browseComic()
        }
    }

    fun onNextComicClicked(view: View) {
        if (comicNumber.value != null && comicNumber.value != currentComicNumber.value) {
            comicNumber.value = comicNumber.value?.plus(1)
            browseComic()
        }
    }
}