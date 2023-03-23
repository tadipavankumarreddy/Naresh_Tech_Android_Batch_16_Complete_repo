package in.nareshtech.googlebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText search_query;
    TextView results;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_query = findViewById(R.id.search_et);
        results = findViewById(R.id.result);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.INVISIBLE);
    }

    /**
     * We need to do networking and fetch the whole json object
     * to the mobile application.
     * */
    public void fetchData(View view) {
        // TODO 1: when you do networking, add INTERNET Permission to android_manifest.xml with out fail
        // TODO 2: Create a java file extend the class to AsyncTask<Void, Void, Void>
        // TODO 3: Show the progress bar till the data is loaded

        progressBar.setVisibility(View.VISIBLE);
        // TODO 4: Trigger the task
        String search = search_query.getText().toString();
        // This execute(..) calls the doInBackground() method
        new FetchData(progressBar,results).execute("https://www.googleapis.com/books/v1/volumes?q="+search);

    }
}