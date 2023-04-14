package in.nareshtech.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MyJobService extends JobService {

    // True - When the work is offloaded to a worker thread
    // False - When the job is finished.
    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(this, "Job Is running!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Toast.makeText(this, "Job is stopped!", Toast.LENGTH_SHORT).show();
        return false;
    }
}
