package in.nareshtechnologies.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBrowser(View view) {
        // TODO: Use the Common Intents page (Implicit Intents) & Open a browser.
        // Step 1: get the url data entered on the edit Text box
        EditText editText = findViewById(R.id.browse_url);
        if(editText.getText().toString().equals("")){
            // This means that the editText box does not have any data
            editText.setError("Please enter a URL");
        }else{
            // This means that you have some data on the EditText Box
            String link = editText.getText().toString();

            // Step 2: Create an Implicit Intent Object with Action to ACTION_VIEW & Data to this link
            Intent i = new Intent();
            // Set the action
            i.setAction(Intent.ACTION_VIEW);
            // set the data
            i.setData(Uri.parse("https://"+link));

            // Step 3: start the activity
            startActivity(i);

            // Step 4: reset the edit text box
            editText.getText().clear();
        }
    }

    public void openMaps(View view) {
        // TODO: Use the Common Intents page (Implicit Intents) & Open a Map.
        // Step 1: get the address data entered on the edit Text box
        EditText editText = findViewById(R.id.maps_address);
        if(editText.getText().toString().equals("")){
            // This means that the editText box does not have any data
            editText.setError("Please enter an Address");
        }else{
            // This means that the address is present in the edittext
            // Step 1: get the address
            String address = editText.getText().toString();

            // Step 2: Create an Intent with action set to ACTION_VIEW and provide the data to be opened
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:0,0?q="+address));

            // Step 3: Start the activity
            startActivity(i);

            // Step 4: reset the values on the EdiTText box
            editText.getText().clear();
        }
    }

    public void openDailer(View view) {
        // Step 1: get the address data entered on the edit Text box
        EditText editText = findViewById(R.id.phone_number);
        if(editText.getText().toString().equals("")){
            // This means that the editText box does not have any data
            editText.setError("Please enter an Address");
        }else{
            String phone = editText.getText().toString();
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+phone));
            startActivity(i);
        }
    }
}