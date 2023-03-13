package in.nareshtechnologies.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button plusBtn, minusBtn;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        plusBtn = findViewById(R.id.plus_btn);
        minusBtn = findViewById(R.id.minus_btn);

        if(savedInstanceState!=null && savedInstanceState.containsKey("KEY")){
            score = savedInstanceState.getInt("KEY");
            result.setText(String.valueOf(score));
        }


        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You can write the logic related to PlusBtn on the xml file
                score++;
                result.setText(String.valueOf(score));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score--;
                result.setText(String.valueOf(score));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY",score);
    }


    /*public void incrementScore(View view) {
        // We perform the logic to increase the score by 1 and display it on the textview (result)
        score++;
        result.setText(String.valueOf(score));
    }

    public void decrementScore(View view) {
        // We perform the logic to decrease the score by 1 and display it on the textview (result)
        score--;
        result.setText(String.valueOf(score));
    }*/

    // TODO 1: Create the XML file with menu options
    //  goto Res (Right Click)-> choose "Android Resource File"

    // TODO 2: override onCreateOptionsMenu(..) method to attach the menu file to the activity

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // We are going to attach the menu file to the activity
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // Todo 3: override onOptionsItemSelected(...) to get the menu items into action

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.reset:
                // perform some operation
                score = 0;
                result.setText(String.valueOf(score));
                break;
            case R.id.second:
                // perform some operation
                Toast.makeText(this, "Sample Message", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                // perform some operation
                Toast.makeText(this, "Sample Messge", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fourth:
                // perform some operation
                Toast.makeText(this, "Sample Messe", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fifth:
                // perform some operation
                Toast.makeText(this, "Sample essage", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}