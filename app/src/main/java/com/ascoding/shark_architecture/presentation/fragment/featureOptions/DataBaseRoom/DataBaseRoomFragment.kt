package com.ascoding.shark_architecture.presentation.fragment.featureOptions.DataBaseRoom

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ascoding.shark_architecture.R

class DataBaseRoomFragment : Fragment() {

    companion object {
        fun newInstance() = DataBaseRoomFragment()
    }

    private lateinit var viewModel: DataBaseRoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data_base_room, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DataBaseRoomViewModel::class.java)
        // TODO: Use the ViewModel
    }

}