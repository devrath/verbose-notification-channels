package com.example.notification.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notification.R
import com.example.notification.databinding.FragmentHomeBinding
import com.example.notification.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) , View.OnClickListener {

    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.declareArraysId.setOnClickListener(this@HomeFragment)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.declareArraysId -> {
                //viewModel.buildingCustomArray()
            }
        }
    }
}