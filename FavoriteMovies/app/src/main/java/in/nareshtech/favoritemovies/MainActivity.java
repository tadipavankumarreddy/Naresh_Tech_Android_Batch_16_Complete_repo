package in.nareshtech.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int movie_posters[];
    private String movie_names[];
    private String actor_names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        movie_posters = new int[]{R.drawable.a,R.drawable.b,R.drawable.c, R.drawable.d,
        R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h, R.drawable.i, R.drawable.j};

        movie_names = new String[]{"Avatar","Bahubali","Challenge","Don","Eega","F2","Gang Leader",
        "Happy","I","Jalsa"};

        actor_names = new String[]{"Sam","Prabhas","Chiranjeevi","Shiva karthikeyan","Nani","Venkatesh",
        "Nani","Arjun","Vikram","Pawan Kalyan"};

        MoviesAdapter adapter = new MoviesAdapter(this,movie_posters,movie_names,actor_names);
        recyclerView.setAdapter(adapter);

        /*recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2,RecyclerView.VERTICAL,false));
    }

    // Step 1: Create a recyclerview and connect it in java code
    // Step 2: Prepare data
    // Step 3: Create an Adapter
    // Step 4: attach the created adapter to the recyclerview
    // Step 5: Set up a layout Manager

}