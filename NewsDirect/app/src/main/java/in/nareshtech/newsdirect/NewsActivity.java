package in.nareshtech.newsdirect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.net.URL;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);

        String cate = getIntent().getStringExtra("cate");

        // Convert your Uri to string
        String url = "https://inshorts.deta.dev/news?category="+cate;

        RequestQueue queue = Volley.newRequestQueue(this);


        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> {
                    Gson gson = new Gson();
                    Source s = gson.fromJson(response,Source.class);
                    NewsAdapter adapter = new NewsAdapter(NewsActivity.this,s.getData());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(NewsActivity.this, "Success", Toast.LENGTH_SHORT).show();
                },
                error -> {
                    progressBar.setVisibility(View.INVISIBLE);

                });

        queue.add(request);
    }
}