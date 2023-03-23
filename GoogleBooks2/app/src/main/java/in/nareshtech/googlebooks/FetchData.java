package in.nareshtech.googlebooks;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * First Data Type -> input type of doInBackground(...)
 * Second Data Type -> for onProgressUpdate(...)
 * Third Data Type -> for onPostExecute(...)*/
public class FetchData extends AsyncTask<String,Void,String> {

    ProgressBar progressBar;
    TextView tv;

    public FetchData(ProgressBar progressBar, TextView tv) {
        this.progressBar = progressBar;
        this.tv = tv;
    }

    // This is the only mandatory method that needs to be overrided.
    @Override
    protected String doInBackground(String... strings) {
        // We perform the task here
        // We will receive the URL into the first argument of the strings[]
        String link = strings[0];
        // We are going to convert this link to URL
        try {
            URL url = new URL(link);
            // Open the connection
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            // Read the input Stream
            InputStream is = connection.getInputStream();
            // Read the data
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        // publish the results to the user
        tv.setText(s);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
