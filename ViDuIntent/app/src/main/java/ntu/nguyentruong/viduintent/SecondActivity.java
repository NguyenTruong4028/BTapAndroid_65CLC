package ntu.nguyentruong.viduintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView tvNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent iNhanDuoc = getIntent();
        String htNhanDuoc = iNhanDuoc.getStringExtra("HT");
        tvNhan = findViewById(R.id.tvBack);
        tvNhan.setText(htNhanDuoc);
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(iBack);
            }
        });
    }
}