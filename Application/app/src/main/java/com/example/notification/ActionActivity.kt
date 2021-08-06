package com.example.notification

import android.os.Bundle
import com.example.notification.databinding.ActivityActionBinding

class ActionActivity : BaseActivity<ActivityActionBinding>(ActivityActionBinding::inflate)  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.actionId.setOnClickListener { finish() }
    }


}