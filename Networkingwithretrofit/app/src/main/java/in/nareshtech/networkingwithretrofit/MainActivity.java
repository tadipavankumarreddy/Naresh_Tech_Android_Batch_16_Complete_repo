package in.nareshtech.networkingwithretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobService;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ProgressBar progressBar;

    private static final String BASE_URL = "https://api.chucknorris.io/jokes/";

    Retrofit retrofit;
    JokesService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(JokesService.class);
    }

    public void getRandomJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);

        service.getData().enqueue(new Callback<Source>() {
            @Override
            public void onResponse(Call<Source> call, Response<Source> response) {
                textView.setText(response.body().getValue());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Source> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to get data!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}