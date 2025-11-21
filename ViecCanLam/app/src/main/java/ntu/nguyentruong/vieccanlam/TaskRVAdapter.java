package ntu.nguyentruong.vieccanlam;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<TASK> dataSource;

    public TaskRVAdapter(List<TASK> dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskItemViewHolder viewHolder = new TaskItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        TaskItemViewHolder viewHolder = (TaskItemViewHolder) holder;
        viewHolder.position = position;
        TASK task = dataSource.get(position);
        viewHolder.tvVCL.setText(task.getName());
        viewHolder.tvTime.setText(task.getDate());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvVCL, tvTime;
        public int position;

        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvVCL = itemView.findViewById(R.id.tvVCL);
            tvTime = itemView.findViewById(R.id.tvTime);
        }

        @Override
        public void onClick(View v) {
            // get position
            int vtClicked = getAbsoluteAdapterPosition();
            // dataSource
            TASK taskClicked = dataSource.get(vtClicked);
            // Toast
            Toast.makeText(v.getContext(),"You choose: "+ taskClicked.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
