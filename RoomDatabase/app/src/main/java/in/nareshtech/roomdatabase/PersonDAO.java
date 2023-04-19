package in.nareshtech.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDAO {

    @Insert
    void insertData(Person person);

    @Query("Select * from person")
    List<Person> getData();

}
