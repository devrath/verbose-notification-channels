<img src="https://github.com/devrath/devrath/blob/master/images/kotlin_logo.png" align="right" title="Kotlin Logo" width="120">

# verbose-notification-channels 🧞‍
<p align="center">
<a><img src="https://img.shields.io/badge/Built%20Using-Kotlin-silver?style=for-the-badge&logo=kotlin"></a>
<a><img src="https://img.shields.io/badge/Built%20By-Android%20Studio-red?style=for-the-badge&logo=android%20studio"></a>  
<a><img src="https://img.shields.io/badge/API-Notification%20Channels-teal?style=for-the-badge&logo=tools"></a>  
</p>

## **`𝙸𝚗𝚝𝚛𝚘𝚍𝚞𝚌𝚝𝚒𝚘𝚗`** 💡
:label: This repository contains demonstrations on how to use notifications in android. </br>
:label: Notifications are used to display a `message` outside the `UI` of the application. Each notification contains an option to add a action for it, which can be used to navigate into the application. </br>



![Banner](https://github.com/devrath/verbose-notification-channels/blob/main/assets/notification_channel.jpeg)




| **`Content`** |
| ------- |
| [**`Notifications before Oreo`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#notifications-before-oreo) |
| [**`Notification channel on Oreo and Higher`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#notification-channel-on-oreo-and-higher) |
| [**`What happens what the code of Notification channels are invoked prior to Oreo devices`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#what-happens-what-the-code-of-notification-channels-are-invoked-prior-to-oreo-devices) |
| [**`How notifications work`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#how-notifications-work) |
| [**`Output of the demo`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#output-of-demo) |


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
![blockdiagram](https://github.com/devrath/verbose-notification-channels/blob/main/assets/notificationflow.png)

#### `Output of demo`
![output](https://github.com/devrath/verbose-notification-channels/blob/main/assets/output.jpg)


-----

<p align="center">
<a><img src="https://forthebadge.com/images/badges/built-for-android.svg"></a>
</p>
