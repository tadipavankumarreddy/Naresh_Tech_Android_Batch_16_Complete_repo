package in.nareshtech.internalstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

// ctrl + alt + o -> removes the unused packages
public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;

    private static final String FILE_NAME = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMyViews();

    }

    public void saveData(View view) {
        Toast.makeText(this, "Data stored Successfully", Toast.LENGTH_SHORT).show();
        String n = person_name.getText().toString();
        String a = person_age.getText().toString();
        // Logic to save data on internal storage goes here
        FileOutputStream fos;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write((n+"\n").getBytes());
            fos.write(a.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        person_name.getText().clear();
        person_age.getText().clear();
    }

    public void loadData(View view) {
        // The logic for loading the data will go here
        FileInputStream fis;

        try {
            fis = openFileInput(FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            result.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initMyViews() {
        person_age = findViewById(R.id.person_age);
        person_name = findViewById(R.id.person_name);
        result = findViewById(R.id.result);
    }
}