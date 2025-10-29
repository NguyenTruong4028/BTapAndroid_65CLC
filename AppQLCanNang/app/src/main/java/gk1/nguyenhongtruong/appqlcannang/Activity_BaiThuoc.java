package gk1.nguyenhongtruong.appqlcannang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
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

public class Activity_BaiThuoc extends AppCompatActivity {

    ImageButton btnBack;
    RecyclerView rvBaiThuoc;
    ArrayList<BaiThuoc> lsBT;
    BaiThuocAdapter adapter;

    void TimDK(){
        btnBack = findViewById(R.id.btnBack);
        rvBaiThuoc = findViewById(R.id.rcCNBaiThuoc);

    }
    void SuKien(){
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(Activity_BaiThuoc.this, MainActivity.class));
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_thuoc);
        TimDK();
        lsBT = getLS();
        rvBaiThuoc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaiThuocAdapter(this, lsBT);
        rvBaiThuoc.setAdapter(adapter);
        SuKien();
    }
    ArrayList<BaiThuoc> getLS(){
        ArrayList<BaiThuoc> ls = new ArrayList<>();
        ls.add(new BaiThuoc("Thập Toàn Đại Bổ Thang","20/10/2025","thuoc_1"));
        ls.add(new BaiThuoc("Bát Trân Thang","21/10/2025","thuoc_2"));
        ls.add(new BaiThuoc("Sâm Linh Bạch Truật Tán","22/10/2025","thuoc_3"));
        ls.add(new BaiThuoc("Lục Vị Địa Hoàng Hoàn","23/10/2025","thuoc_4"));
        ls.add(new BaiThuoc("Quy Tỳ Thang","24/10/2025","thuoc_5"));
        return ls;
    }
}
class BaiThuocAdapter extends RecyclerView.Adapter<BaiThuocAdapter.ItemBaiThuoc> {
    Context context;
    ArrayList<BaiThuoc> lsBT;

    public BaiThuocAdapter(Context context, ArrayList<BaiThuoc> lsBT) {
        this.context = context;
        this.lsBT = lsBT;
    }

    @NonNull
    @Override
    public ItemBaiThuoc onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_bai_thuoc, parent, false);
        return new ItemBaiThuoc(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemBaiThuoc holder, int position) {
        BaiThuoc hd = lsBT.get(position);
        holder.tvHD.setText(hd.getTieuDe());
        holder.tvTime.setText(hd.getTime());
        String image = hd.getImage();
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(image,"mipmap",packageName);
        holder.ivAnh.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lsBT.size();
    }

    class ItemBaiThuoc extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvHD, tvTime;
        ImageView ivAnh;
        public ItemBaiThuoc(@NonNull View itemView) {
            super(itemView);
            tvHD = itemView.findViewById(R.id.tvtenThuoc);
            tvTime = itemView.findViewById(R.id.tvTime);
            ivAnh = itemView.findViewById(R.id.ivAnh);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int positonClicked = getAbsoluteAdapterPosition();
            BaiThuoc bt = lsBT.get(positonClicked);
            Toast.makeText(context, bt.getTieuDe(), Toast.LENGTH_SHORT).show();
        }
    }
}
class BaiThuoc{
    String tieuDe, time, image;

    public BaiThuoc(String tieuDe, String time, String image) {
        this.tieuDe = tieuDe;
        this.time = time;
        this.image = image;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
