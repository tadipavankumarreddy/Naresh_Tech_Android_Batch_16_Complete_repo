package in.nareshtech.fruitslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Step 1: create a Listview object
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2: connect the ListView (listview) to the original view on the activity_main.xml
        listView = findViewById(R.id.fruits_list_view);

        // Step 3: get the data ready
        String[] fruits = new String[]{"Apple","Banana","Grapes","Guava","Water melon",
                "Pineapple","Kiwi","Lichi","Mango","Orange","Promogranate"};

        // Step 4: you need to show this array on the listview.
            // Step 4.1 -> you need to create an Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, fruits);
            // Step 4.2 -> set this adapter on ListView
        listView.setAdapter(adapter);

        // Step 5: get the ListView items into action
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, parent.getItemAtPosition(position).toString()
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}