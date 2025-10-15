package ntu.nguyentruong.landscape_rv;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> listData;
    RecyclerView recyclerViewLands;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3
        listData = getDataForRecyclerView();
        //4
        recyclerViewLands = findViewById(R.id.recyclerLand);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLands.setLayoutManager(layoutLinear);
        //6
        landScapeAdapter = new LandScapeAdapter(this,listData);
        recyclerViewLands.setAdapter(landScapeAdapter);

    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDl = new ArrayList<LandScape>();
        dsDl.add(new LandScape("Mùa thu Canada","lands1"));
        dsDl.add(new LandScape("Mùa đông Thụy Sĩ","lands2"));
        dsDl.add(new LandScape("Rừng cô đơn","lands3"));
        dsDl.add(new LandScape("Bình minh buổi sớm","lands4"));
        dsDl.add(new LandScape("Cánh buồm hoàng hôn","lands5"));
        return dsDl;
    }
}