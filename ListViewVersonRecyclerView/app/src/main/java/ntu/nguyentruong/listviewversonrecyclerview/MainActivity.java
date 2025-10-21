package ntu.nguyentruong.listviewversonrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListViewAdapter listViewAdapter;
    ArrayList<ListView> list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = getDataRecyclerView();
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        listViewAdapter = new ListViewAdapter(this,list);
        recyclerView.setAdapter(listViewAdapter);

    }
    ArrayList<ListView> getDataRecyclerView(){
        ArrayList<ListView> dsDls = new ArrayList<>();
        dsDls.add(new ListView("Lập trình di động"));
        dsDls.add(new ListView("Mẫu thiết kế!"));
        dsDls.add(new ListView("Thiết kế giao diện web 1!"));
        dsDls.add(new ListView("Quản lý dự án phần mềm!"));
        dsDls.add(new ListView("Lập trình Python!"));
        return dsDls;
    }
}