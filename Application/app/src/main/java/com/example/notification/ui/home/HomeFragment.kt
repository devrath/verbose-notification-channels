package com.example.notification.ui.home

import android.app.*
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notification.ActionActivity
import com.example.notification.MainActivity
import com.example.notification.R
import com.example.notification.databinding.FragmentHomeBinding
import com.example.notification.recievers.NotificationReceiver
import com.example.notification.ui.base.BaseFragment
import com.example.notification.utils.NotificationManager.getNotificationManager
import kotlin.random.Random


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) , View.OnClickListener {

    private lateinit var viewModel: HomeViewModel

    companion object {
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel2"
        const val CHANNEL_3_ID = "channel3"

        const val CHANNEL_1_NAME = "Channel 1"
        const val CHANNEL_2_NAME = "Channel 2"
        const val CHANNEL_3_NAME = "Channel 3"

        const val CHANNEL_1_DESCRIPTION = "This is Channel 1"
        const val CHANNEL_2_DESCRIPTION = "This is Channel 2"
        const val CHANNEL_3_DESCRIPTION = "This is Channel 3"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.simpleNotificationId.setOnClickListener(this@HomeFragment)
        binding.simpleCategoryNotificationId.setOnClickListener(this@HomeFragment)
        binding.addingActionId.setOnClickListener(this@HomeFragment)
        createNotificationChannels()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.simpleNotificationId -> {
                val title = binding.editTextTitle.text.toString()
                val message = binding.editTextMessage.text.toString()

                simpleNotification(title, message)
            }
            R.id.simpleCategoryNotificationId -> {
                val title = binding.editTextTitle.text.toString()
                val message = binding.editTextMessage.text.toString()
                notificationInCategory(title, message)
            }
            R.id.addingActionId -> {
                val title = binding.editTextTitle.text.toString()
                val message = binding.editTextMessage.text.toString()
                addingActionForNotification(title, message)
            }
        }
    }

    /**
     * Prepare the notification and notify using the notification manager
     */
    private fun simpleNotification(title: String, message: String) {
        activity?.let {
            // Prepare each notification
            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build()
            // Notify the prepared notification to the manager
            getNotificationManager(activity)?.apply { notify(Random.nextInt(), notification) }
        }
    }


    /**
     * Prepare the notification
     */
    private fun notificationInCategory(title: String, message: String) {
        activity?.let {
            // Prepare each notification
            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_EMAIL)
                .build()
            // Notify the prepared notification to the manager
            getNotificationManager(activity)?.apply { notify(Random.nextInt(), notification) }
        }
    }

    fun addingActionForNotification(title: String, message: String) {
        activity?.let {
             /** NOTE: -> We can use the Pending intent to
             *  *** Start the activity
             *  *** Trigger a broadcast receiver,
             *  *** Start the service */

            /*
            * Activity to open on click of the content of the notification
            * */
            val activityIntent = Intent(it, ActionActivity::class.java)
            /*
             * DESCRIPTION: Pending Intent is just a wrapper around the Intent used to have a action to be initiated in future
             * PARAMETERS:
             * *********** Context: From the launching screen
             * *********** RequestCode: Used as a reference so pending intent can be cancelled in future
             * *********** Intent: Used to launch the destination
             * *********** Flag: This is used to define what happens when our Intent is recreated, since the intent remains same, we can add zero
             * */
            val contentIntent = PendingIntent.getActivity(it, 0, activityIntent, 0)

            /*
             * Broadcast Receiver:  As a intent in action click
             * **** This is the intent triggered when we initiate a action */
            val broadcastIntent = Intent(it, NotificationReceiver::class.java)
            broadcastIntent.putExtra("toastMessage", message)
            /*
             * DESCRIPTION: Pending Intent is just a wrapper around the Intent used to have a action to be initiated in future
             * PARAMETERS:
             * *********** Context: From the launching screen
             * *********** RequestCode: Used as a reference so pending intent can be cancelled in future
             * *********** Intent: Used to launch the destination
             * *********** Flag: This is used to define what happens when our Intent is recreated, since the intent remains same, we can add zero
             * */
            val actionIntent = PendingIntent.getBroadcast(it, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT)

            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_3_ID)
                .setSmallIcon(R.drawable.ic_pokemon)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                // When notification is popped for the first time, it will make sound, next subsequent notifications will not make the sound in this channel
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
                .build()

            getNotificationManager(activity)?.apply { notify(Random.nextInt(), notification) }
        }

    }


    /**
     * Create the notification channels
     */
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

            val channel3 = NotificationChannel(
                CHANNEL_3_ID, CHANNEL_3_NAME,
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_3_DESCRIPTION
            }

            getNotificationManager(activity)?.apply {
                // Use the notification manager to create the channel with attributes
                channel1.apply { createNotificationChannel(this) }
                channel2.apply { createNotificationChannel(this) }
                channel3.apply { createNotificationChannel(this) }
            }

        }
    }


}