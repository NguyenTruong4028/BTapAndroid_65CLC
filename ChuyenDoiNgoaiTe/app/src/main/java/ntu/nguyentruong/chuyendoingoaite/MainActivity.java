package ntu.nguyentruong.chuyendoingoaite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ntu.nguyentruong.chuyendoingoaite.R;

public class MainActivity extends AppCompatActivity {
    EditText edtFrom;
    TextView tvResult;
    Button btnConvert;
    final double USD_TO_VND = 26000.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFrom = findViewById(R.id.etFrom);
        tvResult  = findViewById(R.id.tvKq);
        btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }
    private void convertCurrency(){
        String usdStr = edtFrom.getText().toString().trim();
        if(usdStr.isEmpty()){
            Toast.makeText(MainActivity.this,"Vui lòng nhập số tiền muốn chuyển đổi!",Toast.LENGTH_LONG).show();
            return;
        }
        try {
            double usd = Double.parseDouble(usdStr);
            double vnd = usd * USD_TO_VND;

            tvResult.setText(String.valueOf(vnd));
        }
        catch (NumberFormatException ex){
            Toast.makeText(MainActivity.this,"Giá trị nhập phải là số!",Toast.LENGTH_LONG).show();
        }
    }


}
