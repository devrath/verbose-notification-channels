package com.example.notification

import android.os.Bundle
import com.example.notification.databinding.ActivityActionBinding
import androidx.core.app.RemoteInput


class ActionActivity : BaseActivity<ActivityActionBinding>(ActivityActionBinding::inflate)  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.actionId.setOnClickListener { finish() }

        handleIntent();
    }

    private fun handleIntent() {
        val intent = this.intent
        val remoteInput: Bundle = RemoteInput.getResultsFromIntent(intent)
        val inputString = remoteInput.getCharSequence("KEY_TEXT_REPLY").toString()
        binding.actionId.text = inputString
    }

}