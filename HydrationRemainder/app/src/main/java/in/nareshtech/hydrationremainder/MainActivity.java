package in.nareshtech.hydrationremainder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private AlarmManager manager;
    private PendingIntent pi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        pi = PendingIntent.getBroadcast(this,22,new Intent(this,HydrationReceiver.class),
                PendingIntent.FLAG_IMMUTABLE);

    }

    public void startAlarm(View view) {
        long firstTriggerTime = SystemClock.elapsedRealtime() + (1000 * 60);
        long intervalTime = 2*60*1000;
        manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,firstTriggerTime,intervalTime,pi);
    }

    public void stopAlarm(View view) {
        manager.cancel(pi);
    }

    //todo: Inorder to define the task when the alarm is triggered, the logic can be written inside the
    //  Broadcast receiver -> because we want to invoke a local broadcast when the alarm fires

    // Todo: To manage the alarm we need to use Alarm Manager

}