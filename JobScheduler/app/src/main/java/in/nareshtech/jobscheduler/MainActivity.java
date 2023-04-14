package in.nareshtech.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler scheduler;
    JobInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JobScheduler is a System Service
        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        // Now its time to set the conditions
        info = new JobInfo.Builder(123,
                new ComponentName(this,MyJobService.class.getName()))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setRequiresCharging(true)
                .build();
    }

    public void scheduleTask(View view) {
        scheduler.schedule(info);
    }
}