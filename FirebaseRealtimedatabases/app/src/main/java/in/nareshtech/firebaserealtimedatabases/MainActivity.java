package in.nareshtech.firebaserealtimedatabases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText person_name, person_age;
    private TextView result;

    private ProgressBar progressBar;

    private DatabaseReference dbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_age = findViewById(R.id.person_age);
        person_name = findViewById(R.id.person_name);
        result = findViewById(R.id.result);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        dbr = FirebaseDatabase.getInstance().getReference("Person");
    }

    public void saveData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        String n = person_name.getText().toString();
        int a = Integer.parseInt(person_age.getText().toString());
        // Code to push data to the firebaseRealtimeDatabases
        Person p = new Person(n,a);
        dbr.push().setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(MainActivity.this, "Data inserted Successfully!", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Data is not saved", Toast.LENGTH_SHORT).show();
            }
        });
        person_name.getText().clear();
        person_age.getText().clear();
    }

    public void loadData(View view) {
        progressBar.setVisibility(View.VISIBLE);

        dbr.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.GONE);
                result.setText("");
                for(DataSnapshot d: snapshot.getChildren()){
                    Person p = d.getValue(Person.class);
                    result.append(p.getPerson_name()+"  "+p.getPerson_age()+"\n\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Log.v("Error", error.getMessage());
            }
        });
    }
}