package com.example.notification.ui.home

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notification.R
import com.example.notification.databinding.FragmentHomeBinding
import com.example.notification.ui.base.BaseFragment
import com.example.notification.utils.NotificationManager.getNotificationManager


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) , View.OnClickListener {

    private lateinit var viewModel: HomeViewModel



    companion object {
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel2"

        const val CHANNEL_1_NAME = "Channel 1"
        const val CHANNEL_2_NAME = "Channel 2"

        const val CHANNEL_1_DESCRIPTION = "This is Channel 1"
        const val CHANNEL_2_DESCRIPTION = "This is Channel 2"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.sendOnChannelOneId.setOnClickListener(this@HomeFragment)
        binding.sendOnChannelTwoId.setOnClickListener(this@HomeFragment)
        createNotificationChannels()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.sendOnChannelOneId -> {
                val title = binding.editTextTitle.text.toString()
                val message = binding.editTextMessage.text.toString()
                sendOnChannel1(title,message)
            }
            R.id.sendOnChannelTwoId -> {
                val title = binding.editTextTitle.text.toString()
                val message = binding.editTextMessage.text.toString()
                sendOnChannel2(title,message)
            }
        }
    }


    /**
     * Prepare the notification
     */
    private fun sendOnChannel1(title: String, message: String) {
        activity?.let {
            // Prepare each notification
            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build()
            // Notify the prepared notification to the manager
            getNotificationManager(activity)?.apply { notify(1, notification) }
        }
    }

    /**
     * Prepare the notification and notify using the notification manager
     */
    private fun sendOnChannel2(title: String, message: String) {
        activity?.let {
            // Prepare each notification
            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build()
            // Notify the prepared notification to the manager
            getNotificationManager(activity)?.apply { notify(2, notification) }
        }
    }


    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Set up the channels
                
            val channel1 = NotificationChannel(
                CHANNEL_1_ID, CHANNEL_1_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_1_DESCRIPTION
            }

            val channel2 = NotificationChannel(
                CHANNEL_2_ID, CHANNEL_2_NAME,
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_2_DESCRIPTION
            }

            getNotificationManager(activity)?.apply {
                // Use the notification manager to create the channel with attributes
                channel1.apply { createNotificationChannel(this) }
                channel2.apply { createNotificationChannel(this) }
            }

        }
    }



}