# Android Interview Questions and Answers

### what is Android?
*Android is an open-source Linux-based operating system commonly used on mobile devices such as smartphones and tablets. It is a kernel-based system that gives developers the ability to develop and deploy simple and/or advanced applications.*

### What database is used for the Android OS?
*SQLite, a standalone open-source serverless database, is built into Android by default.*

### What is the architecture of an Android application?
*The android has a 5 layered architecture*
* Application Layer where we have system apps and user apps
* Java API Framework - example View system Library, notification Managers and etc
* Hardware Abstraction Layer where we have Drivers for hardware
* Linux kernel - Where we have core system libraries and Memory Management related things

### What are the main tools for developing applications for Android?
* JDK
* SDK tools
* Android Studio

### Explain the Android SDK.
*It is a set of tools that Android developers use to develop or write applications. It has a graphical user interface that mimics a portable Android environment, making it easier for devs to create, test, and debug their code.*

Tools include:

* Dalvik Debug Monitor Services
* Android emulator
* Android Asset Wrapping Tool
* Android Debug Bridge

### Speaking of emulators, why is it so crucial for devs to have access to one of them?
*Because emulators function like real handheld devices, developers have a nice dedicated sandbox to create safely, edit, test, and debug new applications to see how they work on a real device without risking the real device.*

### What languages ​​does Android use?
*Android mainly uses Java and Kotlin but also supports C / C ++, which will run faster when used with the Android SDK.*

### What is intent in the context of Android? Describe the different types.?
*It is the intent to perform an action, a message that is passed between components. Intents request actions from another component, such as sending an email, opening a web page, or launching a given action.*
There are two types:

- Implicit intent - Here, the intent does not define the target component, requiring the Android system to evaluate the components.
- Explicit intent - Explicit intent, on the other hand, directly identifies the target component.*

### What are activities?
*These are the parts of the mobile application that the user sees and interacts with. It is a graphical user interface (GUI) representing a single Android screen.*

### What are the four basic states of an activity?

* Active: The action is at the top of the stack, running in the foreground.
* Suspended: The activity is still displayed but cannot receive user input events. it's in the background
* Stopped: The action is invisible and therefore paused and hidden or hidden by another action.
* Destroyed: The action process has been terminated, completed, or terminated.

### What is a content provider?
*Content providers exchange information between different Android applications. They allow users to access data in the application. Examples include contact information, images, video, and audio.*

### Explain what Android Toast is.
*a toast is a pop-up window (hence the word) giving feedback on a user-initiated operation, informing the user about the current status of said operation. For example, when a smartphone user sends a message to a friend, a toast is displayed with the words “send a message.”*

### Can bytecode written in Java work on Android?
*No*

### What is AAPT?
*It is an abbreviation for Android Asset Packaging Tool. This tool gives developers the ability to work with zip-compatible archives, including viewing, creating, and extracting content.*

### What is ADB?
*This acronym stands for Android Debug Bridge (a tool included with the SDK). It is a command-line tool used to exchange data between emulator instances.*

### What does APK mean?
*It is short for Android Packaging Kit. Each file in the Android packaging key is compressed into one file - the APK.*

### Explain ANR.
*It is an acronym for Application Not Responding, a pop-up or notification that is triggered when an application experiences a delay for the user due to too many functions running concurrently.*

### How do you host layouts in Android? Where are they located?
*They are placed as XML files in the layout folder of Res Folder*

### Describe different types of Services in Android
*A Service is an application component that can perform long-running operations in the background, and it doesn't provide a user interface. It can run in the background, even when the user is not interacting with your application. These are the three different types of services:*

* Foreground Service: A foreground service performs some operation that is noticeable to the user. For example, we can use a foreground service to play an audio track.
* Background Service: A background service performs an operation that isn’t directly noticed by the user. In Android API level 26 and above, there are restrictions to using background services and it is recommended to use WorkManager in these cases.
* Bound Service: A service is bound when an application component binds to it by calling bindService(). A bound service offers a client-server interface that allows components to interact with the service, send requests, receive results. A bound service runs only as long as another application component is bound to it.

### How would you communicate between two Fragments?
All Fragment-to-Fragment communication is done either through a shared ViewModel or through the associated Activity. Two Fragments should never communicate directly.

*The recommended way to communicate between fragments is to create a shared ViewModel object. Both fragments can access the ViewModel through their containing Activity. The Fragments can update data within the ViewModel and if the data is exposed using LiveData the new state will be pushed to the other fragment as long as it is observing the LiveData from the ViewModel.*
*Another way is to define an interface in your Fragment A, and let your Activity implement that Interface. Now you can call the interface method in your Fragment, and your Activity will receive the event. Now in your activity, you can call your second Fragment to update the textview with the received value.*

###  What is Android Data Binding?
*The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.*
The pros of using Android Data Binding:

* Reduces boilerplate code which in turns brings
* Less coupling
* Stronger readability
* Powerful, easy to implement custom attribute and custom view
* Even faster than findViewById - The binding does a single pass on the View hierarchy, extracting the Views with IDs. This mechanism can be faster than calling findViewById for several Views.

###  What is a JobScheduler?
* The JobScheduler API performs an operation for your application when a set of predefined conditions are met (such as when a device is plugged into a power source or connected to a Wi-Fi network). This allows your app to perform the given task while being considerate of the device's battery at the cost of timing control.*
*Unlike the AlarmManager class, the timing isn't exact. Compared to the AlarmManager, the JobScheduler supports batch scheduling of jobs. The Android system can combine jobs so that battery consumption is reduced. JobManager makes handling uploads easier as it handles automatically the unreliability of the network. It also survives application restarts. Here are example when you would use this job scheduler:

* Tasks that should be done once the device is connect to a power supply
* Tasks that require network access or a Wi-Fi connection.
* Task that are not critical or user facing
* Tasks that should be running on a regular basis as batch where the timing is not critical

### What is the difference between compileSdkVersion and targetSdkVersion?

*The compileSdkVersion is the version of the API the app is compiled against. This means you can use Android API features included in that version of the API (as well as all previous versions, obviously). If you try and use API 16 features but set compileSdkVersion to 15, you will get a compilation error. If you set compileSdkVersion to 16 you can still run the app on a API 15 device as long as your app's execution paths do not attempt to invoke any APIs specific to API 16.*

*The targetSdkVersion has nothing to do with how your app is compiled or what APIs you can utilize. The targetSdkVersion is supposed to indicate that you have tested your app on (presumably up to and including) the version you specify. This is more like a certification or sign off you are giving the Android OS as a hint to how it should handle your app in terms of OS features.*

### Explain the difference between MVC and MVVM ?

[Read this explaination](https://www.guru99.com/mvc-vs-mvvm.html)

### What are the launch modes available for the activity in Android?
*Launch modes help you launch activities with specific sets of instructions and attendant navigation requirements. There are four launch modes that you should reference if asked this interview question:*
- Standard
- SingleTop
- SingleTask
- SingleInstance
*Each launch mode has its own role to play in allowing navigation across any possible configuration, so compare and contrast the benefits and drawbacks to achieve full marks.*

### What additional libraries do you use in Android app development?
*Libraries let you take advantage of the work of other developers for better performance as you create apps. There are several popular libraries that you can talk about (Glide, Retrofit, Picasso, Volley, Retrofit etc), but take the opportunity to explain the library you prefer or have used in the past with great success.*

### What is PendingIntent in Android?
*A PendingIntent passes a future intent to a different application that will perform execution. PendingIntents are a crucial part of the Android framework because they can specify actions to another app. It is good if your answer to this Android coding interview question touches upon implementation details and the new changes within Android 12 regarding mutability.*

### Explain flavors in Android
*With this question, the interviewer wants to know if you can differentiate between product flavors and build types, as they are often mixed up. Also, convey how developer customization to apps across different codebases is tedious and causes errors, so using product flavors is ideal since you can create app variants with a single code base. Mention these details in addition to explaining Gradle, as it creates build type variants.*

### How do you handle a long-running process in an Android app?
* Processes are defined as long-running by Android if they take longer than 10 minutes to complete (such as large uploads and downloads or user-specified tasks). In such cases, you must create a long-running worker with Threads, AsyncTask, Handlers etc (assuming you can’t chunk workloads).*\

### What is Android Jetpack and what are its libraries?
*Android Jetpack is a suite of tools and libraries that can help you build high-quality apps. While the software offers many benefits regarding build complexity and writing boilerplate code, it also addresses several challenges such as limiting memory leaks or managing configuration changes. Jetpack offers four categories of components (Foundation, Architecture, Behavior, and UI) and a host of libraries.*

***Note to my Students*** This is not the end of your research and learning. These are just a few frequently asked questions in the mid level android developer roles. There are good chances of getting other questions. so, keep an eye on the online resources





