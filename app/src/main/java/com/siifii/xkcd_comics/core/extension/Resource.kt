package com.siifii.xkcd_comics.core.extension


data class Resource<out T>(
    val state: ResourceState,
    val data: T? = null,
    val exception: Throwable? = null
)
