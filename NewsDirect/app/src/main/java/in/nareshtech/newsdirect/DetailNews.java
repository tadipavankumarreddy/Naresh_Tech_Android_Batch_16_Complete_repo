package in.nareshtech.newsdirect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailNews extends AppCompatActivity {

    private ImageView iv;
    private TextView title, date,content;
    Datum d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        iv = findViewById(R.id.detail_news_image);
        title = findViewById(R.id.detail_news_title);
        date = findViewById(R.id.detail_news_date);
        content = findViewById(R.id.detail_news_content);

        d = (Datum) getIntent().getSerializableExtra("DATATA");
        Glide.with(this).load(d.getImageUrl()).into(iv);
        title.setText(d.getTitle());
        date.setText(d.getDate()+"\n"+d.getAuthor());
        content.setText(d.getContent());
    }

    public void readMore(View view) {
        showcontent(d.getReadMoreUrl());
    }

    public void showOriginal(View view) {
        showcontent(d.getUrl());
    }

    public void showcontent(String url){
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}