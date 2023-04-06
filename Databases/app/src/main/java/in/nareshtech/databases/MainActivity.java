package in.nareshtech.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;

    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMyViews();
        helper = new DatabaseHelper(this);

    }

    public void saveData(View view) {
        Toast.makeText(this, "Data stored Successfully", Toast.LENGTH_SHORT).show();
        String n = person_name.getText().toString();
        int a = Integer.parseInt(person_age.getText().toString());
        // tODO 3: Map the values that you want to insert with the exact coloumn names of the table
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_2,n);
        values.put(DatabaseHelper.COL_3, a);
        helper.insertData(values);
        person_name.getText().clear();
        person_age.getText().clear();
    }

    public void loadData(View view) {
        Cursor c = helper.readData();
        result.setText("");
        c.moveToFirst();
        do{
            int id = c.getInt(0);
            String n = c.getString(1);
            int age = c.getInt(2);
            result.append(id+"  "+n+"  "+age+"\n");
        }while(c.moveToNext());
    }

    private void initMyViews() {
        person_age = findViewById(R.id.person_age);
        person_name = findViewById(R.id.person_name);
        result = findViewById(R.id.result);
    }

    // TODO 1: Create a class and extend it to SQLiteOpenHelper (This is a class that eases the use of SQliteDatabase)
}