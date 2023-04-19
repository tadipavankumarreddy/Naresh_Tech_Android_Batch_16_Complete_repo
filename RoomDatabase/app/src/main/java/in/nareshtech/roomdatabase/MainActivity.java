package in.nareshtech.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText person_name;
    private EditText person_age;
    private TextView result;

    private PersonDatabase personDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = findViewById(R.id.person_name);
        person_age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);

        personDatabase = Room.databaseBuilder(this,PersonDatabase.class,"pavan")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        String name = person_name.getText().toString();
        int age = Integer.parseInt(person_age.getText().toString());
        personDatabase.personDAO().insertData(new Person(name,age));
        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
        person_name.getText().clear();
        person_age.getText().clear();
    }

    public void loadData(View view) {
        List<Person> persons = personDatabase.personDAO().getData();
        result.setText("");
        for(Person p: persons){
            result.append(p.getId()+" "+p.getPerson_name()+" "+p.getPerson_age()+"\n");
        }
    }
}