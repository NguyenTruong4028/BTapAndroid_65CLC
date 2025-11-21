package ntu.nguyentruong.vieccanlam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_task);
        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data
                EditText edtName = findViewById(R.id.edtName);
                EditText edtDate = findViewById(R.id.edtDate);
                EditText edtMessage = findViewById(R.id.edtMessage);
                EditText edtPriority = findViewById(R.id.edtPriority);

                String tenCV = edtName.getText().toString();
                String ngayCV = edtDate.getText().toString();
                String noidungCV = edtMessage.getText().toString();
                String mucdoCV = edtPriority.getText().toString();

                // insert data
                TASK task = new TASK(tenCV, ngayCV, noidungCV, mucdoCV);
                // Connect db
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("TASK");
                String key = myRef.push().getKey();
                HashMap<String, Object> item = new HashMap<String, Object>();
                item.put(key,task.toFireBaseObject());
                myRef.updateChildren(item,new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError error, DatabaseReference ref){
                        if(error == null){
                            finish();
                        }
                    }

                });
            }

        });
    }
}