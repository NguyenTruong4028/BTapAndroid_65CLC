package ntu.nguyentruong.viewpager_rv;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> listData;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3
        listData = getDataForRecyclerView();
        //4
        viewPager2 = findViewById(R.id.viewPager2);
        //5
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        //6
        landScapeAdapter = new LandScapeAdapter(this,listData);
        viewPager2.setAdapter(landScapeAdapter);
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