package in.nareshtech.networkingwithexecutors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.chucknorris.io/jokes/random";
    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void getRandomJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        final StringBuilder[] builder = new StringBuilder[1];
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {

            // This run method runs in the background
            @Override
            public void run() {
                try {
                    URL url = new URL(BASE_URL);
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line = "";
                    builder[0] = new StringBuilder();
                    while((line = br.readLine())!=null){
                        builder[0].append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // This transfers the control over to the UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Parsing of JSON response can happen here
                        progressBar.setVisibility(View.GONE);
                        textView.setText(builder[0].toString());
                    }
                });
            }
        });
    }
}