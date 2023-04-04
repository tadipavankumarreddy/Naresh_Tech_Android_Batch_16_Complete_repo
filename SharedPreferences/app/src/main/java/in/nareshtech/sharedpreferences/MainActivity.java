package in.nareshtech.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;

    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMyViews();
        // Initializing shared preferences - always open your file in Private mode.
        preferences = getSharedPreferences("my_file_shared", MODE_PRIVATE);
    }

    public void saveData(View view) {
        Toast.makeText(this, "Data stored Successfully", Toast.LENGTH_SHORT).show();
        String n = person_name.getText().toString();
        int a = Integer.parseInt(person_age.getText().toString());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("PERSON_NAME",n);
        editor.putInt("PERSON_AGE",a);
        editor.apply();
        person_name.getText().clear();
        person_age.getText().clear();
    }

    public void loadData(View view) {
        if(preferences!=null && preferences.contains("PERSON_NAME")){
            String n = preferences.getString("PERSON_NAME","Default");
            int a = preferences.getInt("PERSON_AGE",0);
            result.setText(n+" "+a);
        }
    }

    private void initMyViews() {
        person_age = findViewById(R.id.person_age);
        person_name = findViewById(R.id.person_name);
        result = findViewById(R.id.result);
    }
}