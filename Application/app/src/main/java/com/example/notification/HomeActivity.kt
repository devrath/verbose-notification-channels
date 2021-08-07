package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityHomeBinding
import kotlin.random.Random

class HomeActivity : BaseActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate), View.OnClickListener  {

    companion object {
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel2"
        const val CHANNEL_3_ID = "channel3"
        const val CHANNEL_4_ID = "channel4"
        const val CHANNEL_5_ID = "channel5"
        const val CHANNEL_6_ID = "channel6"

        const val CHANNEL_1_NAME = "Channel 1"
        const val CHANNEL_2_NAME = "Channel 2"
        const val CHANNEL_3_NAME = "Channel 3"
        const val CHANNEL_4_NAME = "Channel 4"
        const val CHANNEL_5_NAME = "Channel 5"
        const val CHANNEL_6_NAME = "Channel 6"

        const val CHANNEL_1_DESCRIPTION = "This is Channel 1"
        const val CHANNEL_2_DESCRIPTION = "This is Channel 2"
        const val CHANNEL_3_DESCRIPTION = "This is Channel 3"
        const val CHANNEL_4_DESCRIPTION = "This is Channel 4"
        const val CHANNEL_5_DESCRIPTION = "This is Channel 5"
        const val CHANNEL_6_DESCRIPTION = "This is Channel 6"
    }

    val title = "This is the title "
    val message = "This is the message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.simpleNotificationId.setOnClickListener(this@HomeActivity)
        binding.simpleCategoryNotificationId.setOnClickListener(this@HomeActivity)
        binding.addingActionId.setOnClickListener(this@HomeActivity)
        binding.bigMsgId.setOnClickListener(this@HomeActivity)
        binding.imageInNotificationId.setOnClickListener(this@HomeActivity)
        binding.progressNotificationId.setOnClickListener(this@HomeActivity)
        createNotificationChannels()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.simpleNotificationId -> {
                simpleNotification(title, message)
            }
            R.id.simpleCategoryNotificationId -> {
                notificationInCategory(title, message)
            }
            R.id.addingActionId -> {
                addingActionForNotification(title, message)
            }
            R.id.bigMsgId -> {
                bigMessageNotification(title, message)
            }
            R.id.imageInNotificationId -> {
                imageInNotification(title, message)
            }
            R.id.progressNotificationId -> {
                progressInNotification(title, message)
            }
        }
    }

    private fun progressInNotification(title: String, message: String) {
        this.let {

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

            val progressMax = 100
            val notification: NotificationCompat.Builder =
                NotificationCompat.Builder(it, CHANNEL_6_ID)
                    .setSmallIcon(R.drawable.ic_pokemon)
                    .setContentTitle("Download")
                    .setContentText("Download in progress")
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setOngoing(true)
                    .setOnlyAlertOnce(true)
                    // Add the action click behavior
                    .addAction(R.drawable.ic_action, "Toast", actionIntent)
                    .setProgress(progressMax, 0, true)

            NotificationManager.getNotificationManager(this)?.apply { notify(2, notification.build()) }

            Thread {
                SystemClock.sleep(2000)
                var progress = 0
                while (progress <= progressMax) { SystemClock.sleep(1000)
                    progress += 20
                }
                notification.setContentText("Download finished")
                    .setProgress(0, 0, false)
                    .setOngoing(false)

                NotificationManager.getNotificationManager(this)?.apply { notify(2, notification.build()) }

            }.start()
        }
    }

    /**
     * Prepare the notification which has a large text
     */
    private fun bigMessageNotification(title: String, message: String) {
        this.let {
            val activityIntent = Intent(it, HomeActivity::class.java)
            val contentIntent = PendingIntent.getActivity(it, 0, activityIntent, 0)

            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_4_ID)
                .setSmallIcon(R.drawable.ic_pokemon)
                .setContentTitle(title)
                .setContentText(message)
                // Set the type specifying the big text message
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        // Entire big text
                        .bigText(getString(R.string.long_text_message))
                        // Header title for the big text
                        .setBigContentTitle("Large text title")
                        // Summary title text in the collapsed state
                        .setSummaryText("Large text summary")
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .build()

            // Notify the prepared notification to the manager
            NotificationManager.getNotificationManager(this)?.apply { notify(Random.nextInt(), notification) }
        }
    }



    /**
     * Prepare the notification which has a Image
     */
    private fun imageInNotification(title: String, message: String) {
        this.let {
            val activityIntent = Intent(it, HomeActivity::class.java)
            val contentIntent = PendingIntent.getActivity(it, 0, activityIntent, 0)

            val largeIcon = BitmapFactory.decodeResource(resources, R.drawable.ic_profile)

            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_5_ID)
                .setSmallIcon(R.drawable.ic_pokemon)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(largeIcon)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .build()

            // Notify the prepared notification to the manager
            NotificationManager.getNotificationManager(this)?.apply { notify(Random.nextInt(), notification) }
        }
    }

    /**
     * Prepare the notification and notify using the notification manager
     */
    private fun simpleNotification(title: String, message: String) {
        this.let {
            // Prepare each notification
            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build()
            // Notify the prepared notification to the manager
            NotificationManager.getNotificationManager(this)?.apply { notify(Random.nextInt(), notification) }
        }
    }


    /**
     * Prepare the notification
     */
    private fun notificationInCategory(title: String, message: String) {
        this.let {
            // Prepare each notification
            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_EMAIL)
                .build()
            // Notify the prepared notification to the manager
            NotificationManager.getNotificationManager(this)?.apply { notify(Random.nextInt(), notification) }
        }
    }

    private fun addingActionForNotification(title: String, message: String) {
        this.let {
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
            val actionIntent = PendingIntent.getBroadcast(
                    it,
                    0,
                    broadcastIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
            )

            val notification: Notification = NotificationCompat.Builder(it, CHANNEL_3_ID)
                    .setSmallIcon(R.drawable.ic_pokemon)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLUE)
                    // Add the content on click behavior
                    .setContentIntent(contentIntent)
                    // User cannot cancel the notification by swiping but can only by performing an action
                    .setAutoCancel(false)
                    // When notification is popped for the first time, it will make sound, next subsequent notifications will not make the sound in this channel
                    .setOnlyAlertOnce(true)
                    // Add the action click behavior
                    .addAction(R.drawable.ic_action, "Toast", actionIntent)
                    .build()

            NotificationManager.getNotificationManager(this)?.apply { notify(Random.nextInt(), notification) }
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
                    android.app.NotificationManager.IMPORTANCE_HIGH
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_1_DESCRIPTION
            }

            val channel2 = NotificationChannel(
                    CHANNEL_2_ID, CHANNEL_2_NAME,
                    android.app.NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_2_DESCRIPTION
            }

            val channel3 = NotificationChannel(
                    CHANNEL_3_ID, CHANNEL_3_NAME,
                    android.app.NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_3_DESCRIPTION
            }

            val channel4 = NotificationChannel(
                    CHANNEL_4_ID, CHANNEL_4_NAME,
                    android.app.NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_4_DESCRIPTION
            }

            val channel5 = NotificationChannel(
                    CHANNEL_5_ID, CHANNEL_5_NAME,
                    android.app.NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_5_DESCRIPTION
            }

            val channel6 = NotificationChannel(
                    CHANNEL_6_ID, CHANNEL_6_NAME,
                    android.app.NotificationManager.IMPORTANCE_LOW
            ).apply {
                // Set properties that applies to all the notifications in this channel
                description = CHANNEL_6_DESCRIPTION
            }

            NotificationManager.getNotificationManager(this)?.apply {
                // Use the notification manager to create the channel with attributes
                channel1.apply { createNotificationChannel(this) }
                channel2.apply { createNotificationChannel(this) }
                channel3.apply { createNotificationChannel(this) }
                channel4.apply { createNotificationChannel(this) }
                channel5.apply { createNotificationChannel(this) }
                channel6.apply { createNotificationChannel(this) }
            }

        }
    }

}