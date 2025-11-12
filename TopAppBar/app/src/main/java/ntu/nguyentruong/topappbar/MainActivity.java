package ntu.nguyentruong.topappbar;


import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    private MaterialToolbar topAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topAppBar = findViewById(R.id.topAppBar);
        // Navigation icon (hamburger/menu)
        topAppBar.setNavigationOnClickListener(v ->
                Toast.makeText(this, "Mở menu điều hướng", Toast.LENGTH_SHORT).show()
        );
        // Action menu item click
        topAppBar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_search:
                    Toast.makeText(this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_settings:
                    Toast.makeText(this, "Cài đặt", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });
    }
}