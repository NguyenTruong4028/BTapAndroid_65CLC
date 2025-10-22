package ntu.nguyentruong.viduintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code chuyen man hinh
                //1. Tao intent
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //2. Goi du lieu vao intent
                //2.1 Lay du lieu
                etName = findViewById(R.id.etSend);
                String data= etName.getText().toString();
                //2.2 Goi vao intent, dung put..Extra(key,value)
                intent.putExtra("HT",data);
                intent.putExtra("Copyright","NHT");
                //3. Chuyen man hinh
                startActivity(intent);
            }
        });
    }
}