package ntu.nguyentruong.thithu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityCN2 extends AppCompatActivity {
    ImageButton btnBack;
    EditText edtDGK, edtDCK;
    Button btnDTB;
    TextView tvDTB, tvKetQua;
    void TimDK(){
        btnBack = findViewById(R.id.btnBackcn2);
        edtDGK = findViewById(R.id.edtDGK);
        edtDCK = findViewById(R.id.edtDCK);
        btnDTB = findViewById(R.id.mbTinhTB);
        tvDTB = findViewById(R.id.tvDTB);
        tvKetQua = findViewById(R.id.tvKQ);
    }
    void SuKien(){
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(ActivityCN2.this, MainActivity.class));
        });
    }
    void TinhDTB(){
        btnDTB.setOnClickListener(view -> {
            double diemGK = Double.parseDouble(edtDGK.getText().toString());
            double diemCK = Double.parseDouble(edtDCK.getText().toString());
            double dtb = (diemGK + diemCK) / 2;
            tvDTB.setText(String.valueOf(dtb));
            if (dtb >= 5) {
                tvKetQua.setText("Bạn đã đạt");
                tvKetQua.setTextColor(Color.GREEN);
            } else {
                tvKetQua.setText("Bạn đã rớt");
                tvKetQua.setTextColor(Color.RED);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn2);
        TimDK();
        SuKien();
        TinhDTB();
    }
}