package com.siifii.xkcd_comics.feature.browsecomic.domain.entity

data class ComicModelEntity(
    val num: Int? = null,
    val news: String? = null,
    val img: String? = null,
    val transcript: String? = null,
    val month: String? = null,
    val year: String? = null,
    val link: String? = null,
    val alt: String? = null,
    val title: String? = null,
    val day: String? = null,
    val safeTitle: String? = null,
    var isBookmarked: Boolean? = true
)
