package ntu.nguyentruong.thithu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    Button btnAbout, btnCN2, btnCN3, btnCN4;
    void TimDK(){
        btnAbout = findViewById(R.id.btnAbout);
        btnCN2 = findViewById(R.id.btnCN2);
        btnCN3 = findViewById(R.id.btnCN3);
        btnCN4 = findViewById(R.id.btnCN4);
    }
    void SuKien(){
        btnAbout.setOnClickListener(v ->  {
           startActivity(new Intent(MainActivity.this,ActivityAboutMe.class));
        });
        btnCN2.setOnClickListener(v ->  {
            startActivity(new Intent(MainActivity.this,ActivityCN2.class));
        });
        btnCN3.setOnClickListener(v ->  {
            startActivity(new Intent(MainActivity.this,ActivityCN3.class));
        });
        btnCN4.setOnClickListener(v ->  {
            startActivity(new Intent(MainActivity.this,ActivityCN4.class));
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        TimDK();
        SuKien();
    }
}