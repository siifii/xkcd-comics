package com.siifii.xkcd_comics.feature.browsecomic.data.model

import com.google.gson.annotations.SerializedName
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity

data class ComicModel(

    @field:SerializedName("news") val news: String? = null,
    @field:SerializedName("img") val img: String? = null,
    @field:SerializedName("transcript") val transcript: String? = null,
    @field:SerializedName("month") val month: String? = null,
    @field:SerializedName("year") val year: String? = null,
    @field:SerializedName("num") val num: Int? = null,
    @field:SerializedName("link") val link: String? = null,
    @field:SerializedName("alt") val alt: String? = null,
    @field:SerializedName("title") val title: String? = null,
    @field:SerializedName("day") val day: String? = null,
    @field:SerializedName("safe_title") val safeTitle: String? = null
)

fun ComicModel.translate() =
    ComicModelEntity(news, img, transcript, month, year, num, link, alt, title, day, safeTitle)
