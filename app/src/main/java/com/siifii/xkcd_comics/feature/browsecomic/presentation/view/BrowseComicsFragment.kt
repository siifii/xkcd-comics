package com.siifii.xkcd_comics.feature.browsecomic.presentation.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.siifii.xkcd_comics.R
import com.siifii.xkcd_comics.core.Constants.COMIC_EXPLANATION_URL
import com.siifii.xkcd_comics.core.base.BindingFragment
import com.siifii.xkcd_comics.core.extension.*
import com.siifii.xkcd_comics.databinding.FragmentBrowseComicsBinding
import com.siifii.xkcd_comics.feature.browsecomic.domain.entity.ComicModelEntity
import com.siifii.xkcd_comics.feature.browsecomic.presentation.viewmodel.BrowseComicsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BrowseComicsFragment :
    BindingFragment<FragmentBrowseComicsBinding>(R.layout.fragment_browse_comics) {

    @Inject
    lateinit var viewModel: BrowseComicsViewModel

    override fun initializeViews() {
        viewModel.browseComic()
        viewModel.browseComicResource.observe(this, { onBrowsingNewComic(it) })
        viewModel.messageToShow.observe(
            this,
            { if (!it.isNullOrEmpty()) requireContext().longToast(it) })
        mBinding.FBShare.setOnClickListener { shareComic() }
        mBinding.FBBookMark.setOnClickListener { findNavController().navigate(R.id.bookmarkedComicsFragment) }
        mBinding.TVExplanation.setOnClickListener { browseExplanation(COMIC_EXPLANATION_URL + { viewModel.comicNumber.value }) }
        invokeSearch()

    }


    override fun initializeDataBinding() {
        mBinding.comicVM = viewModel
        mBinding.lifecycleOwner = viewLifecycleOwner
    }

    private fun invokeSearch() {
        mBinding.SVComic.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.comicNumber.value = query?.toInt()
                viewModel.browseComic()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun shareComic() {
        if (viewModel.comicModelLiveData.value != null) {
            shareContent(
                viewModel.comicModelLiveData.value!!.title,
                viewModel.comicModelLiveData.value!!.alt
            )
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun browseExplanation(url: String) {
        val explanationPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, explanationPage)
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun onBrowsingNewComic(resource: Resource<ComicModelEntity>) {
        resource.let { response ->
            when (response.state) {
                ResourceState.LOADING -> mBinding.PBComic.visible()
                ResourceState.SUCCESS -> mBinding.PBComic.gone()
                ResourceState.ERROR -> {
                    mBinding.PBComic.gone()
                    Toast.makeText(context, response.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}