package gk1.nguyenhongtruong.appqlcannang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Activity_BMI extends AppCompatActivity {
    private EditText edtWeight, edtHeight;
    private RadioGroup rdgrStandard;
    private Button btnBMI;
    private TextView tvBMI, tvKQ;
    void TimDK(){
       edtWeight = findViewById(R.id.edtWeight);
       edtHeight = findViewById(R.id.edtHeight);
       rdgrStandard = findViewById(R.id.rdoBMI);
       btnBMI = findViewById(R.id.btnTinhBMI);
       tvBMI = findViewById(R.id.tvBMI);
       tvKQ = findViewById(R.id.tvKQ);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorBMI();
            }
        });

    }
    void CalculatorBMI(){
        String textWeight = edtWeight.getText().toString();
        String textHeight = edtHeight.getText().toString();

        if(textWeight.isEmpty() || textHeight.isEmpty()){
            tvBMI.setError("Vui lòng nhập đầy đủ thông tin");
            edtHeight.requestFocus();
            return;
        }
        float weight = Float.parseFloat(textWeight);
        float height = Float.parseFloat(textHeight) / 100;
        if (height == 0) {
            edtHeight.setError("Chiều cao phải lớn hơn 0");
            edtHeight.requestFocus();
            return;
        }
        float bmi = weight / (height * height);
        boolean isAsianStandard = rdgrStandard.getCheckedRadioButtonId() == R.id.radioBtnAsian;
        displayResult(bmi, isAsianStandard);

    }
    private void displayResult(float bmi, boolean isAsianStandard) {

        DecimalFormat df = new DecimalFormat("#.#");
        String bmiText = "Chỉ số BMI của bạn là: " + df.format(bmi);
        tvBMI.setText(bmiText);

        String classification;
        int color;

        if (isAsianStandard) {
            if (bmi < 18.5) {
                classification = "Tình trạng: Gầy";
                color = Color.BLUE;
            } else if (bmi < 23) {
                classification = "Tình trạng: Bình thường";
                color = ContextCompat.getColor(this, android.R.color.holo_green_dark);
            } else if (bmi < 25) {
                classification = "Tình trạng: Thừa cân";
                color = ContextCompat.getColor(this, android.R.color.holo_orange_dark);
            } else if (bmi < 30) {
                classification = "Tình trạng: Béo phì độ I";
                color = Color.RED;
            } else {
                classification = "Tình trạng: Béo phì độ II";
                color = ContextCompat.getColor(this, android.R.color.holo_red_dark);
            }
        } else {
            if (bmi < 18.5) {
                classification = "Tình trạng: Gầy";
                color = Color.BLUE;
            } else if (bmi < 25) {
                classification = "Tình trạng: Bình thường";
                color = ContextCompat.getColor(this, android.R.color.holo_green_dark);
            } else if (bmi < 30) {
                classification = "Tình trạng: Thừa cân";
                color = ContextCompat.getColor(this, android.R.color.holo_orange_dark);
            } else if (bmi < 35) {
                classification = "Tình trạng: Béo phì độ I";
                color = Color.RED;
            } else if (bmi < 40){
                classification = "Tình trạng: Béo phì độ II";
                color = ContextCompat.getColor(this, android.R.color.holo_red_dark);
            } else {
                classification = "Tình trạng: Béo phì độ III";
                color = ContextCompat.getColor(this, android.R.color.holo_red_dark);
            }
        }

        // Hiển thị kết quả phân loại và đặt màu chữ tương ứng
        tvKQ.setText(classification);
        tvKQ.setTextColor(color);
        tvBMI.setTextColor(color);
    }
}