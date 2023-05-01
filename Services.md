**Services Notes**

**Important Methods**
When the ***startService()*** method is called ***onStartCommand()*** is called. this onStartCommand() has the logic
to start the service
By default, your service does not run in the background thread
to Stop a service that is running, you should call ***stopService() or stopSelf()***


***onBind()*** is called when the call for ***bindService()*** is there -> this is the method involved in **Bound Services**


***onCreate()*** is called to perform one-time setup procedures when the service is initially created (before it calls either onStartCommand() or onBind())

***onDestroy()*** when the service is no longer used and is being destroyed. Your service should implement this to clean up any resources such as threads, registered listeners, or receivers. This is the last call that the service receives.

Every service that you create for your app must be declared in the manifest file.

```
<service android:name=".ExampleService" />
```

**see the service lifecycle**

![Service](https://developer.android.com/static/images/service_lifecycle.png)






