package ntu.nguyentruong.thithu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityCN3 extends AppCompatActivity {
    ImageButton btnBack;
    RecyclerView rcvMonHoc;
    MonHocAdapter adapter;
    ArrayList<MonHoc> dsMon;

    void TimDK(){
        btnBack = findViewById(R.id.btnBackcn3);
        rcvMonHoc = findViewById(R.id.rcCN3);
        dsMon = new ArrayList<>();

    }
    void SuKien(){
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(ActivityCN3.this, MainActivity.class));
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn3);
        TimDK();
        dsMon = getData();
        rcvMonHoc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MonHocAdapter(this, getData());
        rcvMonHoc.setAdapter(adapter);
        SuKien();

    }
    ArrayList<MonHoc> getData(){
        ArrayList<MonHoc> ls = new ArrayList<>();
        ls.add(new MonHoc("Tin học đại cương"));
        ls.add(new MonHoc("Lập trình Java"));
        ls.add(new MonHoc("Lập trình C++"));
        ls.add(new MonHoc("Lập trình C#"));
        ls.add(new MonHoc("Lập trình Python"));
        ls.add(new MonHoc("Lập trình Ruby"));
        ls.add(new MonHoc("Lập trình PHP"));
        ls.add(new MonHoc("Lập trình JavaScript"));
        ls.add(new MonHoc("Lập trình Swift"));
        return ls;


    }
}
class MonHocAdapter extends RecyclerView.Adapter<MonHocAdapter.ItemDSMon> {
    Context context;
    ArrayList<MonHoc> dsMon;

    public MonHocAdapter(Context context, ArrayList<MonHoc> dsMon) {
        this.context = context;
        this.dsMon = dsMon;
    }

    @NonNull
    @Override
    public ItemDSMon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cn3_item, parent, false);
        return new ItemDSMon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDSMon holder, int position) {
        MonHoc monHoc = dsMon.get(position);
        holder.tvMonHoc.setText(monHoc.getMonHoc());
    }

    @Override
    public int getItemCount() {
        return dsMon.size();
    }

    class ItemDSMon extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvMonHoc;
        public ItemDSMon(@NonNull View itemView) {
            super(itemView);
            tvMonHoc = itemView.findViewById(R.id.tvItem3);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int positionClicked = getAbsoluteAdapterPosition();
            MonHoc itemChosen = dsMon.get(positionClicked);
            String name = itemChosen.getMonHoc();
            String tbao = "Bạn vừa click vào: " + name;
            Toast.makeText(v.getContext(),tbao,Toast.LENGTH_LONG).show();

        }
    }

}
class MonHoc{
    String monHoc;
    public MonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }
}