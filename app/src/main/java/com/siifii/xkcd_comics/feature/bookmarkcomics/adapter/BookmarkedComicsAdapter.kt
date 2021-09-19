package com.siifii.xkcd_comics.feature.bookmarkcomics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siifii.xkcd_comics.core.extension.SingleLiveEvent
import com.siifii.xkcd_comics.databinding.ListItemBookmarkedComicBinding
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity

/*
Created by Kareem Alsaifi for  on 9/18/2021.
Copyright (c) 2021 . All rights reserved.
*/

class BookmarkedComicsAdapter :
    RecyclerView.Adapter<BookmarkedComicsAdapter.BookmarkedComicsHolder>() {
    var bookmarkedComicsList: List<ComicModelEntity> = emptyList()
    var deleteBookmark = SingleLiveEvent<Pair<Boolean, ComicModelEntity>>()

    fun submitList(bookmarkedComicsList: List<ComicModelEntity>) {
        this.bookmarkedComicsList = bookmarkedComicsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkedComicsHolder =
        BookmarkedComicsHolder(
            ListItemBookmarkedComicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BookmarkedComicsHolder, position: Int) {
        val bookmarkedComicsItem = bookmarkedComicsList[position]
        holder.bind(bookmarkedComicsItem, position)
    }

    override fun getItemCount(): Int = bookmarkedComicsList.size

    inner class BookmarkedComicsHolder(private val mBinding: ListItemBookmarkedComicBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item: ComicModelEntity, position: Int) {
            mBinding.item = item
            mBinding.IVDelete.setOnClickListener {
                deleteBookmark.value = true to item
                bookmarkedComicsList.toMutableList().removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }
}