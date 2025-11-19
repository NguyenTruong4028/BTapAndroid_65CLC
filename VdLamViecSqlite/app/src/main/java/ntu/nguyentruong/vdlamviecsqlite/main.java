package clc65.hoangluu.vdlamviecsqlite;

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
        getBookData();
        //tạo cơ sở dữ lệu
        db = openOrCreateDatabase("books.db",MODE_PRIVATE,null);
//

        //Hiện ListView
        ArrayList<String> dsTenSach = new ArrayList<String>();

        ListView lvSach = findViewById(R.id.lvSach);
        ArrayAdapter<String> adapterSach = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTenSach);
        lvSach.setAdapter(adapterSach);
    }
    ArrayList<BOOKS> getBookData() {
        ArrayList<BOOKS> dsSach = new ArrayList<>();

        // Truy vấn lấy toàn bộ sách
        String sqlSelectAll = "SELECT * FROM BOOKS";
        Cursor resultSet = db.rawQuery(sqlSelectAll, null);

        // Kiểm tra có dữ liệu hay không
        if (resultSet.moveToFirst()) {
            do {
                int maSach = resultSet.getInt(0);
                String tenSach = resultSet.getString(1);
                int soTrang = resultSet.getInt(2);
                float gia = resultSet.getFloat(3);
                String moTa = resultSet.getString(4);

                BOOKS book = new BOOKS(maSach, tenSach, soTrang, gia, moTa);
                dsSach.add(book);
            } while (resultSet.moveToNext());
        }

        resultSet.close();
        return dsSach;
    }
}