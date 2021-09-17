package com.siifii.xkcd_comics.core.extension

import androidx.lifecycle.MutableLiveData


fun <T> MutableLiveData<T>.setData(data: T? = null) =
    postValue(
        data
    )

fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T? = null) =
    postValue(
        Resource(
            ResourceState.SUCCESS,
            data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setLoading(data: T? = null) =
    postValue(
        Resource(
            ResourceState.LOADING, data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setError(throwable: Throwable? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            throwable
        )
    )
