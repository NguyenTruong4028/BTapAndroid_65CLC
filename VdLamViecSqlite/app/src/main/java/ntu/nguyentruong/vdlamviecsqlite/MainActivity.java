package ntu.nguyentruong.vdlamviecsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getBookData();
        ArrayList<String> lsName = getNameBook();
        // Set data to listview
        ListView listView = findViewById(R.id.lvNameB);
        ArrayAdapter<String> adapterNameBook = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lsName);
        listView.setAdapter(adapterNameBook);
    }
    ArrayList<Book> getBookData(){
        // Create CSDL
        db = openOrCreateDatabase("books",MODE_PRIVATE,null);
        // Truy van
        String sqlSelectAll = "SELECT * FROM BOOKS";
        Cursor resultSet = db.rawQuery(sqlSelectAll,null);
        ArrayList<Book> lsBook = new ArrayList<Book>();

        resultSet.moveToFirst();
        while (true){
            // Get data
            int idBook = resultSet.getInt(0);
            String nameBook = resultSet.getString(1);
            int page = resultSet.getInt(2);
            float price = resultSet.getFloat(3);
            String description = resultSet.getString(4);
            // Package object ==> create module class
            Book book = new Book(idBook,nameBook,page,price,description);
            // Add to list
            lsBook.add(book);
            // Move to next
            resultSet.moveToNext();
            if (resultSet.isAfterLast()){
                break;
            }
        }
        db.close();
        return lsBook;
    }
    ArrayList<String> getNameBook(){
        // Create CSDL
        db = openOrCreateDatabase("books",MODE_PRIVATE,null);
        // Truy van
        String sqlSelectAll = "SELECT * FROM BOOKS";
        Cursor resultSet = db.rawQuery(sqlSelectAll,null);
        ArrayList<String> lsNameBook = new ArrayList<>();

        resultSet.moveToFirst();
        while (true){
            // Get data
            String nameBook = resultSet.getString(1);
            // Add to list
            lsNameBook.add(nameBook);
            // Move to next
            resultSet.moveToNext();
            if (resultSet.isAfterLast()){
                break;
            }
        }
        db.close();
        return lsNameBook;
    }

}