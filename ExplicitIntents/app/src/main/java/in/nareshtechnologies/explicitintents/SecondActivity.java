package in.nareshtechnologies.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result = findViewById(R.id.result);
        //get the data from the intent object that is sent by the mainAcitivity

        String name = getIntent().getStringExtra("KEY1");
        result.setText(name);
    }
}