package com.siifii.xkcd_comics.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragment<B : ViewDataBinding>(@LayoutRes val layoutRes: Int) : Fragment() {

    protected lateinit var mBinding: B

    abstract fun initializeViews()

    abstract fun initializeDataBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)

        initializeDataBinding()
        initializeViews()

        return mBinding.root
    }
}
