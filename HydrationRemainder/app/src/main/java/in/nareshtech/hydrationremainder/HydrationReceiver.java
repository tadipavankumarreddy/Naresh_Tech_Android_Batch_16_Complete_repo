package in.nareshtech.hydrationremainder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class HydrationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // What ever has to happen as the alarm triggers, the task should be defined here
        NotificationManager manager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // create a notification channel
            NotificationChannel channel = new NotificationChannel("hydration_id",
                    "Hydration Reminder",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "hydration_id");
        builder.setSmallIcon(R.drawable.baseline_water_drop_24);
        builder.setContentTitle("Have a glass of water!");
        builder.setContentText("Drinking a glass of water every one hour will keep you hydrated");
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        manager.notify(24,builder.build());
    }

    // todo: The task of this app is to send a notification reminding the user to have
    //  to have some water in the form of a notification every time the alarm fires.
}