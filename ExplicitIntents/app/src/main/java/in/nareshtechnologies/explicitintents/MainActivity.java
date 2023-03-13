package in.nareshtechnologies.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect this object to the real view on the xml file
        name = findViewById(R.id.person_name);

    }

    public void openNext(View view) {
        //get the data
        String n = name.getText().toString();
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        // we are supposed to attach this value to the intent object before it is being sent out through startActivity(...)
        i.putExtra("KEY1", n);
        startActivity(i);
    }
}