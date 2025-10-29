package gk1.nguyenhongtruong.appqlcannang;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAbout, btnCN2, btnCN3, btnCN4;
    void TimDK(){
        btnAbout = findViewById(R.id.btnAbout);
        btnCN2 = findViewById(R.id.btnCN2);
        btnCN3 = findViewById(R.id.btnCN3);
        btnCN4 = findViewById(R.id.btnCN4);
    }
    void SuKien(){
        btnAbout.setOnClickListener(v ->  {
            startActivity(new Intent(MainActivity.this,Activity_AboutMe.class));
        });
        btnCN2.setOnClickListener(v ->  {
            startActivity(new Intent(MainActivity.this,Activity_BMI.class));
        });
        btnCN3.setOnClickListener(v ->  {
            startActivity(new Intent(MainActivity.this,Activity_MonAn.class));
        });
        btnCN4.setOnClickListener(v ->  {
            startActivity(new Intent(MainActivity.this,Activity_BaiThuoc.class));
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDK();
        SuKien();
    }
}