package com.example.notification

import android.os.Bundle
import com.example.notification.databinding.ActivityActionBinding
import com.example.notification.ui.base.BaseActivity

class ActionActivity : BaseActivity<ActivityActionBinding>(ActivityActionBinding::inflate)  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.actionId.setOnClickListener { finish() }
    }


}