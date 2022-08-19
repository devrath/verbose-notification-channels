<img src="https://github.com/devrath/devrath/blob/master/images/kotlin_logo.png" align="right" title="Kotlin Logo" width="120">

# verbose-notification-channels 🧞‍
<p align="left">
<a><img src="https://img.shields.io/badge/Built%20Using-Kotlin-silver?style=for-the-badge&logo=kotlin"></a>
<a><img src="https://img.shields.io/badge/Built%20By-Android%20Studio-red?style=for-the-badge&logo=android%20studio"></a>  
<a><img src="https://img.shields.io/badge/API-Notification%20Channels-teal?style=for-the-badge&logo=tools"></a>  
</p>

## **`𝙸𝚗𝚝𝚛𝚘𝚍𝚞𝚌𝚝𝚒𝚘𝚗`** 💡
:label: This repository contains demonstrations on how to use notifications in android. </br>
:label: Notifications are used to display a `message` outside the `UI` of the application. Each notification contains an option to add a action for it, which can be used to navigate into the application. </br>



![Banner](https://github.com/devrath/verbose-notification-channels/blob/main/assets/notification_channel.jpeg)




| **`𝙲𝚘𝚗𝚝𝚎𝚗𝚝`** |
| ------- |
| [**`𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗𝚜 𝚋𝚎𝚏𝚘𝚛𝚎 𝙾𝚛𝚎𝚘`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#notifications-before-oreo) |
| [**`𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗 𝚌𝚑𝚊𝚗𝚗𝚎𝚕 𝚘𝚗 𝙾𝚛𝚎𝚘 𝚊𝚗𝚍 𝙷𝚒𝚐𝚑𝚎𝚛`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#notification-channel-on-oreo-and-higher) |
| [**`𝚆𝚑𝚊𝚝 𝚑𝚊𝚙𝚙𝚎𝚗𝚜 𝚠𝚑𝚎𝚗 𝚝𝚑𝚎 𝚌𝚘𝚍𝚎 𝚘𝚏 𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗 𝚌𝚑𝚊𝚗𝚗𝚎𝚕𝚜 𝚒𝚜 𝚒𝚗𝚟𝚘𝚔𝚎𝚍 𝚙𝚛𝚒𝚘𝚛 𝚝𝚘 𝙾𝚛𝚎𝚘 𝚍𝚎𝚟𝚒𝚌𝚎𝚜`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#what-happens-what-the-code-of-notification-channels-are-invoked-prior-to-oreo-devices) |
| [**`𝙷𝚘𝚠 𝚗𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗𝚜 𝚠𝚘𝚛𝚔`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#how-notifications-work) |
| [**`𝙾𝚞𝚝𝚙𝚞𝚝 𝚘𝚏 𝚝𝚑𝚎 𝚍𝚎𝚖𝚘`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#output-of-demo) |
| [**`𝚂𝚞𝚙𝚙𝚘𝚛𝚝 𝚏𝚘𝚛 𝚊𝚗𝚍𝚛𝚘𝚒𝚍-𝟷𝟹`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#how-notifications-work) |



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

#### `Support for android-13`


-----

<p align="center">
<a><img src="https://forthebadge.com/images/badges/built-for-android.svg"></a>
</p>
