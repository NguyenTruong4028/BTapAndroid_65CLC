package ntu.nguyentruong.tinhtong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtSo1, edtSo2;
    TextView tvKq;
    Button btnTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSo1 = findViewById(R.id.edtA);
        edtSo2 = findViewById(R.id.edtB);
        tvKq = findViewById(R.id.tvResult);
        btnTinh = findViewById(R.id.btnTinhTong);
    }
    public void HamTinhTong(View v){
        String strS1 = edtSo1.getText().toString();
        String strS2 = edtSo2.getText().toString();

        int soA = Integer.parseInt(strS1);
        int soB = Integer.parseInt(strS2);

        int tong = soA + soB;

        String strTong = String.valueOf(tong);

        tvKq.setText(strTong);
    }
}