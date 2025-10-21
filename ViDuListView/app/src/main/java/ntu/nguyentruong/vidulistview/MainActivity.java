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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvHocPhan;
    //(1)Chuẩn bị nguồn dữ liệu hiển thị
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
        // (1) Đọc nội dung file JSON
        String jsonString = Utils.getJsonFromAsset(this,"subjects.json");
        // (2) Dùng Gson để chuyển JSON thành String
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<String>>(){}.getType();
        List<String> subjects = gson.fromJson(jsonString,listUserType);
        //(3) Gắn Adapter
        adapterHP = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,subjects);
        lvHocPhan.setAdapter(adapterHP);
        //(4) Xử lý sự kiện
        lvHocPhan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //(4.1) Lấy giá trị phần tử đã chon
                //Cách 1: lấy gián tiep từ adapter
                String value = adapterHP.getItem(position).toString();
                //Cách 2: Lấy trực tiếp tù nguồn dữ liệu
                String value2 = subjects.get(position);
                String thongBao = "Bạn đang chọn môn: " + value;
                Toast.makeText(MainActivity.this,thongBao,Toast.LENGTH_LONG).show();
            }
        });

    }

}