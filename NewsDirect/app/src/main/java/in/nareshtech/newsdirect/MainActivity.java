package in.nareshtech.newsdirect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] categories = new String[]{"all", "national", "business", "sports", "world", "politics", "technology", "startup", "entertainment", "miscellaneous", "hatke", "science",
                "automobile"};
        lv = findViewById(R.id.categories_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                categories);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, NewsActivity.class);
                i.putExtra("cate", parent.getItemAtPosition(position).toString());
                if (isNetworkConnected()) {
                    startActivity(i);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setTitle("No Internet Connection!");
                    builder.setMessage("Please revisit the app when there is internet connection!");
                    builder.setPositiveButton("Yes", (dialog, which) -> {
                        finish();
                    });
                    builder.setNegativeButton("No", (dialog, which) -> Toast.makeText(MainActivity.this, "Sorry! you cannot proceed without internet", Toast.LENGTH_SHORT).show());
                    builder.setNeutralButton("Retry", (dialog, which) -> {
                        if (isNetworkConnected()) {
                            startActivity(i);
                        }
                    });

                    builder.show();

                }

            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}