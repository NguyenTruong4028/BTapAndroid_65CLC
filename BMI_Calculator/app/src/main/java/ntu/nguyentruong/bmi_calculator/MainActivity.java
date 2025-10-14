package ntu.nguyentruong.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import ntu.nguyentruong.bmi_calculator.R;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private RadioGroup radioGroupStandard;
    private RadioButton radioButtonAsian;
    private Button buttonCalculate;
    private TextView textViewResult, textViewClassification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        radioGroupStandard = findViewById(R.id.radioGroupStandard);
        radioButtonAsian = findViewById(R.id.radioButtonAsian);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);
        textViewClassification = findViewById(R.id.textViewClassification);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();
            }
        });
    }

    private void calculateBmi() {
        // Lấy dữ liệu người dùng nhập vào
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        // Kiểm tra xem người dùng đã nhập đủ thông tin chưa?
        if (weightStr.isEmpty()) {
            editTextWeight.setError("Vui lòng nhập cân nặng");
            editTextWeight.requestFocus();
            return;
        }

        if (heightStr.isEmpty()) {
            editTextHeight.setError("Vui lòng nhập chiều cao");
            editTextHeight.requestFocus();
            return;
        }

        // Chuyển đổi dữ liệu sang dạng số
        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // Đổi cm sang m

        // Kiểm tra chiều cao phải lớn hơn 0
        if (height == 0) {
            editTextHeight.setError("Chiều cao phải lớn hơn 0");
            editTextHeight.requestFocus();
            return;
        }

        // Tính toán chỉ số BMI
        float bmi = weight / (height * height);

        // Lấy tiêu chuẩn được chọn
        boolean isAsianStandard = radioGroupStandard.getCheckedRadioButtonId() == R.id.radioButtonAsian;

        // Phân loại và hiển thị kết quả
        displayResult(bmi, isAsianStandard);
    }

    private void displayResult(float bmi, boolean isAsianStandard) {
        // Định dạng số BMI để hiển thị 1 chữ số sau dấu phẩy
        DecimalFormat df = new DecimalFormat("#.#");
        String bmiText = "Chỉ số BMI của bạn là: " + df.format(bmi);
        textViewResult.setText(bmiText);

        String classification;
        int color;

        // Phân loại dựa trên tiêu chuẩn đã chọn
        if (isAsianStandard) {
            // Tiêu chuẩn IDI & WPRO cho người Châu Á
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
            // Tiêu chuẩn của WHO
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
        textViewClassification.setText(classification);
        textViewClassification.setTextColor(color);
        textViewResult.setTextColor(color);
    }
}
