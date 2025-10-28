package ntu.nguyentruong.thithu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLamThem extends AppCompatActivity {
    ImageButton btnBack;
    void TimDK(){
        btnBack = findViewById(R.id.btnBack);
    }
    void SuKien(){
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(ActivityLamThem.this, MainActivity.class));
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_them);
    }
}