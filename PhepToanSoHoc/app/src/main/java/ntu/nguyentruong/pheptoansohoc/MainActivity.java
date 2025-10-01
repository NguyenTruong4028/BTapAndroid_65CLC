package ntu.nguyentruong.pheptoansohoc;

import android.annotation.SuppressLint;
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
    TextView tvKq;
    EditText edtSo1, edtSo2;
    Button btnCong, btnTru, btnNhan, btnChia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtSo1 = findViewById(R.id.edtA);
        edtSo2 = findViewById(R.id.edtB);
        tvKq = findViewById(R.id.tvKetqua);

    }
    public void TinhTong(View v){
        String strSo1 = edtSo1.getText().toString();
        String strSo2 = edtSo2.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);

        int tong = soA + soB;

        tvKq.setText(String.valueOf(tong));
    }

    public void TinhTru(View v){
        String strSo1 = edtSo1.getText().toString();
        String strSo2 = edtSo2.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);

        int tru = soA - soB;

        tvKq.setText(String.valueOf(tru));

    }

    public void TinhNhan(View v){
        String strSo1 = edtSo1.getText().toString();
        String strSo2 = edtSo2.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);

        int nhan = soA * soB;

        tvKq.setText(String.valueOf(nhan));
    }

    @SuppressLint("SetTextI18n")
    public void TinhChia(View v){
        String strSo1 = edtSo1.getText().toString();
        String strSo2 = edtSo2.getText().toString();

        int soA = Integer.parseInt(strSo1);
        int soB = Integer.parseInt(strSo2);


        float chia = (float) soA / soB;

        tvKq.setText(String.valueOf(chia));
    }
}