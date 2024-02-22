package com.ascoding.shark_architecture.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel, VB : ViewDataBinding> : Fragment() , View.OnClickListener  {

    protected var baseViewModel: VM? = null
    lateinit var baseViewBinding : VB

    protected abstract fun getContentView(): Int
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        baseViewBinding = DataBindingUtil.inflate(inflater , getContentView() , container , false)
        return baseViewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel()
        baseViewModel?.start()
    }
    protected abstract fun initializeViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        subscribeLiveData()
    }
    protected abstract fun initView()
    protected abstract fun subscribeLiveData()

    //region life cycle
    override fun onDestroy() {
        super.onDestroy()
        baseViewModel?.stop()
    }
    //endregion

}