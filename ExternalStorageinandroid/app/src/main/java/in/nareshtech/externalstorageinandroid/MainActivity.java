package in.nareshtech.externalstorageinandroid;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;

    private static final String FILE_NAME = "my_data_ext.txt";

    // in some devices, the external storage might not be available. some devices will not have write access.
    boolean isAvailable = false, isWritable = false, isReadable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMyViews();
        // To check if the exeternal storage is available, is readale and is writable.
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            isAvailable = isReadable = isWritable = true;
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            isAvailable = isReadable = true;
        }

        // request the user to grant the write permission on the external storage
        if(checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission is granted!", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissions(new String[]{READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE},78);
        }
    }

    public void saveData(View view) {
        Toast.makeText(this, "Data stored Successfully", Toast.LENGTH_SHORT).show();
        String n = person_name.getText().toString();
        int a = Integer.parseInt(person_age.getText().toString());
       // The actual logic of saving data goes here

        // Step 1: is to choose a folder of your interest
        String folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/myfiles/";
        // Step 2: inside this "folder", we can create a file
        File file = new File(FILE_NAME);
        // Step 3: is to write data to it using FileOutputStream
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write((n+"\n"+a).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        person_name.getText().clear();
        person_age.getText().clear();
    }

    public void loadData(View view) {
        // Step 1: is to choose a folder of your interest
        String folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/myfiles/";
        // Step 2: inside this "folder", we can create a file
        /*File file = new File(folder,FILE_NAME);*/

        FileInputStream fis;
        try {
            fis = new FileInputStream(FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder sb = new StringBuilder();
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