package com.siifii.xkcd_comics.feature.browsecomic.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity

@Entity(tableName = "comic")
data class ComicModel(
    @PrimaryKey @field:SerializedName("num") val num: Int? = null,
    @field:SerializedName("news") val news: String? = null,
    @field:SerializedName("img") val img: String? = null,
    @field:SerializedName("transcript") val transcript: String? = null,
    @field:SerializedName("month") val month: String? = null,
    @field:SerializedName("year") val year: String? = null,
    @field:SerializedName("link") val link: String? = null,
    @field:SerializedName("alt") val alt: String? = null,
    @field:SerializedName("title") val title: String? = null,
    @field:SerializedName("day") val day: String? = null,
    @field:SerializedName("safe_title") val safeTitle: String? = null,
    val isFavourite: Boolean? = false
)

fun ComicModel.translate() = ComicModelEntity(
    num,
    news,
    img,
    transcript,
    month,
    year,
    link,
    alt,
    title,
    day,
    safeTitle,
    isFavourite
)

fun ComicModelEntity.translate() = ComicModel(
    num,
    news,
    img,
    transcript,
    month,
    year,
    link,
    alt,
    title,
    day,
    safeTitle,
    isBookmarked
)

fun List<ComicModel>.translate(): List<ComicModelEntity> = map { it.translate() }
