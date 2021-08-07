# verbose-notification-channels
Demo on how to use notifications on android 
![Banner](https://github.com/devrath/verbose-notification-channels/blob/main/assets/notification_channel.jpeg)

| **`Content`** |
| ------- |
| [**`Notifications before Oreo`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#notifications-before-oreo) |
| [**`Notification channel on Oreo and Higher`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#notification-channel-on-oreo-and-higher) |
| [**`What happens what the code of Notification channels are invoked prior to Oreo devices`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#what-happens-what-the-code-of-notification-channels-are-invoked-prior-to-oreo-devices) |
| [**`How notifications work`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#how-notifications-work) |


#### `Notifications before Oreo`
* User could disable notifications per application basis and this was not useful for the user. If he ends up doing this, we would not be able to show any notifications at all.
* Based on the channel we can make the user categorize the notifications. 

#### `Notification channel on Oreo and Higher`
* From Oreo which is API-26 displaying a notification became a little complex
* Now we define a notification channel, purpose of using the notification channel is to give the user more control on notifications displayed and have access to the noise they make 

#### `What happens what the code of Notification channels are invoked prior to Oreo devices`
* There wont be any effect since the notification channels only work on oreo and higher versions.
* There will not appear any crash as such.

#### `How notifications work`
![Banner](https://github.com/devrath/verbose-notification-channels/blob/main/assets/notificationflow.png)

-----

<p align="center">
<a><img src="https://forthebadge.com/images/badges/built-for-android.svg"></a>
</p>
