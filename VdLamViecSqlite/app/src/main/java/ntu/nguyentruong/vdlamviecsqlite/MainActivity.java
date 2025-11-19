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
        // Create CSDL
        db = openOrCreateDatabase("books",MODE_PRIVATE,null);
        // Create table
//        String sqlXoaBang = "DROP TABLE IF EXISTS BOOKS";
//        String sqlTaoBang = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY, BookName text, Page integer, Price Float, Description text)";
//
//        db.execSQL(sqlXoaBang);
//        db.execSQL(sqlTaoBang);
//
//        // Add data
//        String sqlThem1 = "INSERT INTO BOOKS VALUES(1,'Toán',100,9.9,'sách về toán')";
//        db.execSQL(sqlThem1);
        // Test

        // Truy van DL
        String sqlSelectAll = "SELECT * FROM BOOKS";
        Cursor resultSet = db.rawQuery(sqlSelectAll,null);
        ArrayList<String> lsName = new ArrayList<>();
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
            lsName.add(nameBook);
            // Move to next
            resultSet.moveToNext();
            if (resultSet.isAfterLast()){
                break;
            }
        }
        db.close();
        // Set data to listview
        ListView listView = findViewById(R.id.lvNameB);
        ArrayAdapter<String> adapterNameBook = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lsName);
        listView.setAdapter(adapterNameBook);
    }
}