package ntu.nguyentruong.thithu;

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

public class ActivityCN4 extends AppCompatActivity {
    ImageButton btnBack;
    RecyclerView rvHD;
    ArrayList<HoatDong> lsHD;
    HoatDongAdapter adapter;

    void TimDK(){
        btnBack = findViewById(R.id.btnBackcn4);
        rvHD = findViewById(R.id.rvCN4);

    }
    void SuKien(){
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(ActivityCN4.this, MainActivity.class));
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn4);
        TimDK();
        lsHD = getLS();
        rvHD.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HoatDongAdapter(this, lsHD);
        rvHD.setAdapter(adapter);
        SuKien();
    }
    ArrayList<HoatDong> getLS(){
        ArrayList<HoatDong> ls = new ArrayList<>();
        ls.add(new HoatDong("Lễ kỷ niệm 60 năm năm 2","20/10/2025","hd_1"));
        ls.add(new HoatDong("Tổ chức chia sẻ kinh nghiệm học tại trường","20/10/2025","hd_2"));
        ls.add(new HoatDong("Hội nghị tổng kết công tác tuyển sinh","20/10/2025","hd_3"));
        ls.add(new HoatDong("Hội nghị tổng kết công tác tuyển sinh","20/10/2025","hd_4"));
        ls.add(new HoatDong("Trường đại học tổ chức tọa đàm","20/10/2025","hd_5"));
        return ls;
    }
}
class HoatDongAdapter extends RecyclerView.Adapter<HoatDongAdapter.ItemHoatDong> {
    Context context;
    ArrayList<HoatDong> lsHD;

    public HoatDongAdapter(Context context, ArrayList<HoatDong> lsHD) {
        this.context = context;
        this.lsHD = lsHD;
    }

    @NonNull
    @Override
    public ItemHoatDong onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cn4_item, parent, false);
        return new ItemHoatDong(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHoatDong holder, int position) {
        HoatDong hd = lsHD.get(position);
        holder.tvHD.setText(hd.getTieuDe());
        holder.tvTime.setText(hd.getTime());
        String image = hd.getImage();
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(image,"mipmap",packageName);
        holder.ivAnh.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lsHD.size();
    }

    class ItemHoatDong extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvHD, tvTime;
        ImageView ivAnh;
        public ItemHoatDong(@NonNull View itemView) {
            super(itemView);
            tvHD = itemView.findViewById(R.id.tvHD);
            tvTime = itemView.findViewById(R.id.tvTime);
            ivAnh = itemView.findViewById(R.id.ivAnh);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int positonClicked = getAbsoluteAdapterPosition();
            HoatDong hd = lsHD.get(positonClicked);
            Toast.makeText(context, hd.getTieuDe(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(context, ActivityHD.class);
//            intent.putExtra("HD", hd);
//            context.startActivity(intent);
        }
    }
}
class HoatDong{
    String tieuDe, time, image;

    public HoatDong(String tieuDe, String time, String image) {
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