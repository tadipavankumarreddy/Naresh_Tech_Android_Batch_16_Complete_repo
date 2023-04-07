package in.nareshtech.contentresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    String authorities = "in.nareshtech.databases.CONTENT_URI";
    public static final String COL_2 = "person_name";
    public static final String COL_3 = "person_age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Build the URI Authority
        Uri uri = Uri.parse("content://"+authorities);

        ContentValues values = new ContentValues();
        values.put(COL_2,"Shiva");
        values.put(COL_3,56);

        ContentResolver resolver = getContentResolver();
        resolver.insert(uri,values);
        Cursor c = resolver.query(uri,null,null,null,null);

        textView.setText("");
        c.moveToFirst();
        do{
            int id = c.getInt(0);
            String n = c.getString(1);
            int a = c.getInt(2);
            textView.append(id+"  "+n+"  "+a+"\n");
        }while(c.moveToNext());
    }
}