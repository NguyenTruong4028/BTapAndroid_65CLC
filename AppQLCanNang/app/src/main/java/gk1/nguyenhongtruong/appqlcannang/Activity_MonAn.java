package gk1.nguyenhongtruong.appqlcannang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Activity_MonAn extends AppCompatActivity {
    ImageButton btnBack;
    RecyclerView rcvMonAn;
    MonAnAdapter adapter;

    void TimDK(){
        btnBack = findViewById(R.id.btnBack);
        rcvMonAn = findViewById(R.id.rcCNMonAn);
    }

    void SuKien(){
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(Activity_MonAn.this, MainActivity.class));
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_an);
        TimDK();

        String jsonString = Utils.getJsonFromAsset(this, "mon_an.json");
        ArrayList<MonAn> monAns = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("mon_an_bo_duong");

            for (int i = 0; i < jsonArray.length(); i++) {
                monAns.add(new MonAn(jsonArray.getString(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        rcvMonAn.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MonAnAdapter(this, monAns);
        rcvMonAn.setAdapter(adapter);

        SuKien();
    }
}

class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ItemDSMon> {
    Context context;
    ArrayList<MonAn> dsMon;

    public MonAnAdapter(Context context, ArrayList<MonAn> dsMon) {
        this.context = context;
        this.dsMon = dsMon;
    }

    @NonNull
    @Override
    public ItemDSMon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mon_an, parent, false);
        return new ItemDSMon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDSMon holder, int position) {
        MonAn monAn = dsMon.get(position);
        holder.tvMonAn.setText(monAn.getMonAn());
    }

    @Override
    public int getItemCount() {
        return dsMon.size();
    }

    class ItemDSMon extends RecyclerView.ViewHolder {
        TextView tvMonAn;
        public ItemDSMon(@NonNull View itemView) {
            super(itemView);
            tvMonAn = itemView.findViewById(R.id.tvItemMA);
        }
    }
}

class MonAn {
    String monAn;
    public MonAn(String monAn) {
        this.monAn = monAn;
    }
    public String getMonAn() {
        return monAn;
    }
    public void setMonAn(String monAn) {
        this.monAn = monAn;
    }
}

class Utils {
    public static String getJsonFromAsset(Context context, String fileName){
        String jsonString;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }
}
