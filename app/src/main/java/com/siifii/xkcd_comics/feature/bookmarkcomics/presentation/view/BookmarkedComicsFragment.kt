package com.siifii.xkcd_comics.feature.bookmarkcomics.presentation.view

import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.siifii.xkcd_comics.R
import com.siifii.xkcd_comics.core.base.BindingFragment
import com.siifii.xkcd_comics.core.extension.gone
import com.siifii.xkcd_comics.core.extension.longToast
import com.siifii.xkcd_comics.core.extension.visible
import com.siifii.xkcd_comics.core.widget.SeparatorItemDecorator
import com.siifii.xkcd_comics.databinding.FragmentBookmarkedComicsBinding
import com.siifii.xkcd_comics.feature.bookmarkcomics.adapter.BookmarkedComicsAdapter
import com.siifii.xkcd_comics.feature.bookmarkcomics.presentation.viewmodel.BookmarkedComicsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookmarkedComicsFragment :
    BindingFragment<FragmentBookmarkedComicsBinding>(R.layout.fragment_bookmarked_comics) {

    private val adapter = BookmarkedComicsAdapter()

    @Inject
    lateinit var viewModel: BookmarkedComicsViewModel

    override fun initializeViews() {
        viewModel.getBookmarkedComics()
        mBinding.BTBack.setOnClickListener { findNavController().navigateUp() }

        observeOnDeleteBookmark()
        observeOnFavouriteComics()
        observeOnMessageToShow()
    }

    private fun observeOnMessageToShow() {
        viewModel.messageToShow.observe(
            this,
            { if (!it.isNullOrEmpty()) requireContext().longToast(it) })
    }

    private fun observeOnDeleteBookmark() {
        adapter.deleteBookmark.observe(
            this,
            {
                if (it.first) viewModel.deleteBookmarkedComic(it.second.num!!)
//                viewModel.favouriteComics.value?.toMutableList()?.remove(it.second)
            })
    }

    private fun observeOnFavouriteComics() {
        viewModel.favouriteComics.observe(this, { comic ->
            if (comic.isNullOrEmpty()) {
                mBinding.apply {
                    rvBookmarkedComics.gone()
                    TVNoBookmarkData.visible()
                }
            } else {
                mBinding.apply {
                    rvBookmarkedComics.visible()
                    TVNoBookmarkData.gone()
                    rvBookmarkedComics.adapter = adapter
                }
                setItemSeparatorDecoration()?.let { mBinding.rvBookmarkedComics.addItemDecoration(it) }
                adapter.submitList(comic)
            }
        })
    }

    private fun setItemSeparatorDecoration(): SeparatorItemDecorator? =
        ContextCompat.getDrawable(requireContext(), R.drawable.item_seperation)
            ?.let { SeparatorItemDecorator(it) }

    override fun initializeDataBinding() {
        mBinding.bookmarkVM = viewModel
        mBinding.lifecycleOwner = viewLifecycleOwner
    }
}