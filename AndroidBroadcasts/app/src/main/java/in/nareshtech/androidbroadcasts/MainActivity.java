package in.nareshtech.androidbroadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    // We need to create a constant so that the receiver and sender can come to an agreement with
    public static final String ACTION_CUSTOM = "pavankumar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        //register for the broadcast of our interest
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(ACTION_CUSTOM);
        // Register the broadcast with registerReceiver(..) method
        registerReceiver(new PowerReceiver(imageView),filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // unregister is how the broadcast can be unregistered.
        unregisterReceiver(new PowerReceiver(imageView));
    }

    public void sendBroadcast(View view) {
        sendBroadcast(new Intent(ACTION_CUSTOM));
    }
}