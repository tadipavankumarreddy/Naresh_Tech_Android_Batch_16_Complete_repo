package in.nareshtech.androidbroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

public class PowerReceiver extends BroadcastReceiver {

    // As I need to update the imageview based on the broadcast that arrives
    // we need to get the instance of ImageView
    ImageView imageView;

    public PowerReceiver(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
       // We take action here
        switch (intent.getAction())
        {
            case Intent.ACTION_POWER_CONNECTED:
                // action
                imageView.setImageResource(R.drawable.baseline_battery_charging_full_24);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                //action
                imageView.setImageResource(R.drawable.baseline_battery_alert_24);
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                imageView.setImageResource(R.drawable.baseline_airplanemode_active_24);
                break;
            case MainActivity.ACTION_CUSTOM:
                imageView.setImageResource(R.drawable.ic_launcher_background);
                break;
        }
    }
}