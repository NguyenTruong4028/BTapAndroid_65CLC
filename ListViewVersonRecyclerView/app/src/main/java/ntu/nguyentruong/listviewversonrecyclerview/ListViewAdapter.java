package ntu.nguyentruong.listviewversonrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ItemListHolder>{
    Context context;
    ArrayList<ListView> lsDatas;

    public ListViewAdapter(Context _context, ArrayList<ListView> _lsDatas) {
        this.context = _context;
        this.lsDatas = _lsDatas;
    }

    @NonNull
    @Override
    public ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.textview,parent,false);
        ItemListHolder holder =new ItemListHolder(vItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListHolder holder, int position) {
        ListView listView =lsDatas.get(position);
        String caption = String.valueOf(listView.getTvSubject());
        holder.tvSubject.setText(caption);
    }

    @Override
    public int getItemCount() {
        return lsDatas.size();
    }

    class ItemListHolder extends RecyclerView.ViewHolder{
        TextView tvSubject;
        public ItemListHolder(@NonNull View itemView) {
            super(itemView);
            tvSubject =itemView.findViewById(R.id.tvRecycler);
        }
    }
}
