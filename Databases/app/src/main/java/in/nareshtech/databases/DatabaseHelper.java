package in.nareshtech.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pavans";
    private static final int DATABASE_VERSION = 1;

    // to create a table -> lets have the following constants
    public static final String TABLE_NAME = "person";
    public static final String COL_1 = "person_id";
    public static final String COL_2 = "person_name";
    public static final String COL_3 = "person_age";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // the job of this method is to create as many number of tables as required
        String query = "create TABLE "+TABLE_NAME+"("+COL_1+" INTEGER PRIMARY key AUTOINCREMENT, "+COL_2+" text, "+COL_3+" integer);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The job of this method is to update the database when there is a version change
        db.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(db);
    }

    // TODO 2: Implement logic for inserting data and retrieving data
    public void insertData(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
    }

    public Cursor readData(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("Select * from "+TABLE_NAME, null);
    }
}
