package ntu.nguyentruong.chatbotai;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewChat;
    EditText edtMessage;
    ImageButton btnSend;
    ChatAdapter adapter;
    ArrayList<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ĐÃ SỬA: Dùng ADJUST_PAN để tránh resize làm mất focus
        getWindow().setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        recyclerViewChat = findViewById(R.id.recyclerViewChat);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        messages = new ArrayList<>();
        adapter = new ChatAdapter(this, messages);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewChat.setAdapter(adapter);

        // Xử lý nút Send trên bàn phím ảo
        edtMessage.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                btnSend.performClick();
                return true;
            }
            return false;
        });

        btnSend.setOnClickListener(v -> {
            String text = edtMessage.getText().toString().trim();
            if (text.isEmpty()) return;

            // Ẩn bàn phím
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtMessage.getWindowToken(), 0);
            edtMessage.clearFocus();

            String reply = getBotReply(text);

            // Thêm tin nhắn người dùng trước
            addMessage(text, true);

            // XÓA SAU KHI ĐÃ THÊM TIN NHẮN (rất quan trọng!)
            edtMessage.setText("");

            // Thêm phản hồi bot
            addMessage(reply, false);

            // Cuộn xuống cuối
            recyclerViewChat.smoothScrollToPosition(messages.size() - 1);
        });
    }

    void addMessage(String text, boolean isUser) {
        messages.add(new Message(text, isUser));
        adapter.notifyItemInserted(messages.size() - 1);
        recyclerViewChat.post(() ->
                recyclerViewChat.smoothScrollToPosition(messages.size() - 1)
        );
    }

    // Bot trả lời đơn giản
    String getBotReply(String userInput) {
        userInput = userInput.toLowerCase();
        if (userInput.contains("hi") || userInput.contains("hello"))
            return "Hello! I'm your virtual assistant 🌸";
        else if (userInput.contains("courses") || userInput.contains("subjects"))
            return "You can view the list of courses in the 'Course List' section!";
        else if (userInput.contains("ai") || userInput.contains("artificial intelligence"))
            return "AI (Artificial Intelligence) is the field that enables computers to 'learn' like humans 🤖";
        else if (userInput.contains("thanks") || userInput.contains("thank you"))
            return "You're welcome! 💙";
        else
            return "Sorry, I don't understand your request 😅";
    }
}

class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_USER = 1;
    private static final int TYPE_BOT = 2;

    Context context;
    ArrayList<Message> messages;

    public ChatAdapter(Context context, ArrayList<Message> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        return messages.get(position).isUser() ? TYPE_USER : TYPE_BOT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TYPE_USER) {
            View view = inflater.inflate(R.layout.item_chat_user, parent, false);
            return new UserViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_chatbot, parent, false);
            return new BotViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message msg = messages.get(position);
        if (holder instanceof UserViewHolder) {
            ((UserViewHolder) holder).tvMessage.setText(msg.getText());
        } else {
            ((BotViewHolder) holder).tvMessage.setText(msg.getText());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
        }
    }

    static class BotViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;

        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
        }
    }
}

class Message {
    private String text;
    private boolean isUser;

    public Message(String text, boolean isUser) {
        this.text = text;
        this.isUser = isUser;
    }

    public String getText() { return text; }
    public boolean isUser() { return isUser; }
}