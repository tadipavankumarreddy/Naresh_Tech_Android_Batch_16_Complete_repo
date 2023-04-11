package in.nareshtech.androidnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // To send a Notification we need three components
    // 1. We need a Notification Manager to Manage the notifications (Sending, creating notification channels,
    // cancelling etc.,)
    private NotificationManager manager;
    private static final String CHANNEL_ID = "pavanschannel";
    private static final String CHANNEL_NAME = "Pavans Channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NotificationManager is a System Service.
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // NotificationChannels are introduced in Android API 26 (oreo). NotificationChannels
        // Give power to the user to enable or disable certain kinds of Notifications
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // You need to create a NotificationChannel as Must
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH);
            // to create the channel take the help of NotificationManager Object
            manager.createNotificationChannel(channel);
        }
    }

    public void sendNotification(View view) {
        // Create a notification commonly for all the android versions
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        // to create a small Icon (Required)
        builder.setSmallIcon(R.drawable.notification_icon);
        // to create title of the notification
        builder.setContentTitle("This is my first Notification");
        // to create Text for the notification
        builder.setContentText("This is my sample message");
        // if you want to make (which you should) the notifications cancellable
        builder.setAutoCancel(true);
        // to set priority (for all the lower end devices that run android 7.0 and below
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        // When the notification is tapped, we need to perform an action
        /**
         * Pending Intent is a description of an Intent and the action to perform with it
         * Pending Intent can be used to raise an Acitivty, deliver a broadcast and
         * raise a Service
         * */
        PendingIntent pi = PendingIntent.getActivity(this,123,
                new Intent(this,MainActivity.class),
                PendingIntent.FLAG_IMMUTABLE);
        // now you should attach this pending intent to the notification
        builder.setContentIntent(pi);

        // to display the image on the notifications, you need to convert the format of the image
        // to bitmap
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.android);
        // Show the image on the notification when it is expanded
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(b));
        // You can send a notification
        manager.notify(23,builder.build());
    }


    public void cancelNotification(View view) {

    }
}