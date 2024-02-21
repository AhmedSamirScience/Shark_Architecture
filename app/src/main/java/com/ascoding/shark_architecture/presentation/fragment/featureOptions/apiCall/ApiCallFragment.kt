package com.ascoding.shark_architecture.presentation.fragment.featureOptions.apiCall

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ascoding.shark_architecture.R

class ApiCallFragment : Fragment() {

    companion object {
        fun newInstance() = ApiCallFragment()
    }

    private lateinit var viewModel: ApiCallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_api_call, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApiCallViewModel::class.java)
        // TODO: Use the ViewModel
    }

}