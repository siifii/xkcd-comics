package com.siifii.xkcd_comics.core.extension

import androidx.lifecycle.MutableLiveData

/*
Created by Kareem Alsaifi for  on 9/15/2021.
Copyright (c) 2021 . All rights reserved.
*/
fun <T> MutableLiveData<Resource<T>>.setSuccess(data: T) =
    postValue(
        Resource(
            ResourceState.SUCCESS,
            data
        )
    )


fun <T> MutableLiveData<Resource<T>>.setLoading() =
    postValue(
        Resource(
            ResourceState.LOADING,
            value?.data
        )
    )

fun <T> MutableLiveData<Resource<T>>.setError(message: String? = null) =
    postValue(
        Resource(
            ResourceState.ERROR,
            value?.data,
            message
        )
    )