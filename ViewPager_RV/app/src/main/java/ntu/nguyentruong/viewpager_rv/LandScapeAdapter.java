package ntu.nguyentruong.viewpager_rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder>{
    Context context;
    ArrayList<LandScape> lsDatas;

    public LandScapeAdapter(Context _context, ArrayList<LandScape> _lsDatas) {
        this.context = _context;
        this.lsDatas = _lsDatas;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.landscap_item,parent,false);
        ItemLandHolder holderCreated = new ItemLandHolder(vItem);
        return holderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //Lấy đối tượng hiển thị
        LandScape landScape = lsDatas.get(position);
        //Trích thông tin
        String caption = landScape.getLandscapeName();
        String image = landScape.getLandscapeImage();
        //Đặt vào các trường thông tin cuar holder
        holder.tvCaption.setText(caption);
        //Đặt ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(image,"mipmap",packageName);
        holder.ivLandScape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lsDatas.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.tvland);
            ivLandScape = itemView.findViewById(R.id.imland);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int positionClicked = getAbsoluteAdapterPosition();
            LandScape itemChosen = lsDatas.get(positionClicked);
            String name = itemChosen.getLandscapeName();
            String nameImg = itemChosen.getLandscapeImage();
            String tbao = "Bạn vừa click vào: " + name;
            Toast.makeText(v.getContext(),tbao,Toast.LENGTH_LONG).show();
        }
    }
}
