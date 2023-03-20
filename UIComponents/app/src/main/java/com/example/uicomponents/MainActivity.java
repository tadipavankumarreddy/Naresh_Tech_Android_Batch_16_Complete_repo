package com.example.uicomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText person_name,person_age;
    private RadioGroup rg;
    private CheckBox telugu, hindi, english;
    private Spinner spinner;
    private SwitchCompat switchCompat;
    private TextView results;

    String gender = "Not Selected";
    String languages = "";

    String country = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId() == R.id.male){
                    gender = "Male";
                }else{
                    gender = "Female";
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if(position!=0){
                    country = item;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initViews() {
        person_name = findViewById(R.id.person_name);
        person_age = findViewById(R.id.person_age);
        rg = findViewById(R.id.gender);
        telugu = findViewById(R.id.telugu);
        hindi = findViewById(R.id.hindi);
        english = findViewById(R.id.english);
        spinner = findViewById(R.id.spinner);
        switchCompat = findViewById(R.id.switch1);
        results = findViewById(R.id.results);
    }

    public void getData(View view) {
        String n = person_name.getText().toString();
        int a = Integer.parseInt(person_age.getText().toString());
        if(telugu.isChecked()) {
            languages += "Telugu\n";
        }
        if(hindi.isChecked(

        )){
            languages += "Hindi\n";
        }
        if(english.isChecked()){
            languages += "English\n";
        }

        boolean onoroff = switchCompat.isChecked();
        String isOn = "Off";
        if(onoroff){
            isOn = "On";
        }else{
            isOn = "Off";
        }

        results.setText(n+"\n"+a+"\n"+gender+"\n"+languages+"\n"+country+"\n"+isOn);
    }
}