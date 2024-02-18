package com.ascoding.shark_architecture.presentation.fragment.featureOptions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ascoding.shark_architecture.R

class MainFeatureOptionsFragment : Fragment() {

    companion object {
        fun newInstance() = MainFeatureOptionsFragment()
    }

    private lateinit var viewModel: MainFeatureOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_feature_options, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainFeatureOptionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}