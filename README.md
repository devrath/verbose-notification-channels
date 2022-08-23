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
| [**`𝚂𝚞𝚙𝚙𝚘𝚛𝚝 𝚏𝚘𝚛 𝚊𝚗𝚍𝚛𝚘𝚒𝚍-𝟷𝟹`**](https://github.com/devrath/verbose-notification-channels/blob/main/README.md#support-for-android-13) |



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
![blockdiagram](https://github.com/devrath/verbose-notification-channels/blob/main/assets/sematic.png)

#### `Output of demo`

`𝚂𝚒𝚖𝚙𝚕𝚎 𝚗𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗` | `𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗 𝚠𝚒𝚝𝚑 𝚊 𝚋𝚒𝚐 𝚖𝚎𝚜𝚜𝚊𝚐𝚎` | `𝙰𝚍𝚍𝚒𝚗𝚐 𝚊𝚌𝚝𝚒𝚘𝚗`
--- | --- | --- |
<img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/simple_notification.gif" width="220" height="460"/> | <img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/big_message.gif" width="220" height="460"/> | <img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/add_action.gif" width="220" height="460"/>|

`𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗 𝚠𝚒𝚝𝚑 𝚐𝚛𝚘𝚞𝚙𝚒𝚗𝚐` | `𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗 𝚠𝚒𝚝𝚑 𝚒𝚖𝚊𝚐𝚎` | `𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗 𝚠𝚒𝚝𝚑 𝚙𝚛𝚘𝚐𝚛𝚎𝚜𝚜` 
--- | --- | --- |
<img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/category.gif" width="220" height="460"/>| <img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/img.gif" width="220" height="460"/>| <img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/progress.gif" width="220" height="460"/>|

`𝙽𝚘𝚝𝚒𝚏𝚒𝚌𝚊𝚝𝚒𝚘𝚗 𝚠𝚒𝚝𝚑 𝚌𝚑𝚊𝚝 𝚊𝚌𝚝𝚒𝚘𝚗` |
--- |
<img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/reply_action_chat.gif" width="220" height="460"/>|


-----

#### `Support for android-13`

#### `𝙱𝚊𝚌𝚔𝚐𝚛𝚘𝚞𝚗𝚍`
* There is a new change that android is bringing for `android-13` which is also called `Tiramisu` and `API-33` where there is a runtime permission, user has to approve before the notification has to be posted from a app in device.
* This is different that the already existing permissions where user can turn `on`/`off` on per each notification channel.

#### `𝙾𝚋𝚜𝚎𝚛𝚟𝚊𝚝𝚒𝚘𝚗𝚜`

| `𝙲𝚘𝚗𝚍𝚒𝚝𝚒𝚘𝚗` | `𝙾𝚋𝚜𝚎𝚛𝚟𝚊𝚝𝚒𝚘𝚗` | `𝙾𝚞𝚝𝚙𝚞𝚝` |
| ---------- | ------------ | -------- |
| When the app is built with `compile-SDK` and `target-SDK` is `API-31` which is `android-12` also known as `snow-clone` |  🏷️ When you run this on `android-Pie` which is `API-28` device, no notification permission is displayed. </br> 🏷️ We don't need to handle the runtime permission, instead just create the notification channels |  |
| When the app is built with `compile-SDK` and `target-SDK` is `API-31` which is `android-12` also known as `snow-clone` |  🏷️ When you run this on `android-13` which is `API-33` device, even though we have not asked the app to display runtime permission, android device forcefully displays it if the code executes any lines that involve creation of channels. </br> 🏷️ If the user approves it, application can post the notification. </br> 🏷️ If the user denies it, this is dangerous since not only user will not be able to post notification also this dialog will never again unless you reinstall the app.  | <img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/demo/without_manifest_permission.gif" width="220" height="460"/> |
| When the app is built with `compile-SDK` and `target-SDK` is `API-33` which is `android-13` also known as `Tiramisu`. After adding manifest permission and handeling the runtime permission | 🏷️ Notifications appear only when the user approves the permission </br> 🏷️ If the user dosen't approve it, the notifications will not appear. | <img src="https://github.com/devrath/verbose-notification-channels/blob/main/assets/permission_settings.png" /> |


-----

<p align="center">
<a><img src="https://forthebadge.com/images/badges/built-for-android.svg"></a>
</p>
