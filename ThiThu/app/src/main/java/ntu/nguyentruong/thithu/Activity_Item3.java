package ntu.nguyentruong.thithu;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Item3 extends AppCompatActivity {
    TextView tvCourseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);
        tvCourseName = findViewById(R.id.tvCourseName);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String courseName = bundle.getString("tenMonHoc","");
            tvCourseName.setText(courseName);
        }

    }
}