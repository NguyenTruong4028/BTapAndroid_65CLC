package ntu.nguyentruong.vidulistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvHocPhan;
    //(1)Chuẩn bị nguồn dữ liệu hiển thị
    ArrayList<String> lstHP;
    //(2) Tạo Adapter
    ArrayAdapter<String> adapterHP;
    void TimDK(){
        lvHocPhan = findViewById(R.id.lvhocPhan);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDK();
        //Lấy dữ liệu đưa vào listHP từ file, database, internet
        lstHP = new ArrayList<>();
        lstHP = getData();
        //(3) Gắn Adapter
        adapterHP = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lstHP);
        lvHocPhan.setAdapter(adapterHP);
        //(4) Xử lý sự kiện
        lvHocPhan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //(4.1) Lấy giá trị phần tử đã chon
                //Cách 1: lấy gián tiep từ adapter
                String value = adapterHP.getItem(position).toString();
                //Cách 2: Lấy trực tiếp tù nguồn dữ liệu
                String value2 = lstHP.get(position);
                String thongBao = "Bạn đang chọn môn: " + value;
                Toast.makeText(MainActivity.this,thongBao,Toast.LENGTH_LONG).show();
            }
        });
    }
    ArrayList<String> getData(){
        //Code đọc dữ liệu và cất vào bien tam, trước khi return cho lsHP
        ArrayList<String> dsTam = new ArrayList<String>();
        //Bài này ta fake dữ liệu
        dsTam.add("Lập trình di động");
        dsTam.add("Mẫu thiết kế");
        dsTam.add("Thiết kế web 1");
        dsTam.add("Quản lý dự án");
        dsTam.add("Lập trình Python");

        return dsTam;
    }
}