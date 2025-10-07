package ntu.nguyentruong.lamthemtnpheptoancong;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvQuestion, tvCoin, tvTimer;
    Button[] buttons = new Button[4];
    int correctAns;
    int correctIndex;
    int coin = 0;
    Random random = new Random();
    CountDownTimer timer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvCoin = findViewById(R.id.tvCoin);
        tvTimer = findViewById(R.id.tvTimer);
        buttons[0]=findViewById(R.id.btn1);
        buttons[1]=findViewById(R.id.btn2);
        buttons[2]=findViewById(R.id.btn3);
        buttons[3]=findViewById(R.id.btn4);
        for(Button btn : buttons){
                btn.setOnClickListener(this::checkAnswer);
        }
        generateQuestion();



    }
    private void generateQuestion(){
        resetButtonColors();

        int a = random.nextInt(50) + 1;
        int b = random.nextInt(50) + 1;

        correctAns = a + b;
        correctIndex = random.nextInt(4);

        tvQuestion.setText(a+" + "+b);
        buttons[correctIndex].setText(String.valueOf(correctAns));

        for(int i = 0; i < 4;i++){
            if (i == correctIndex) continue;
            int m = random.nextInt(6) + 1; // lệch 1-6
            int wrong = correctAns + (random.nextBoolean() ? m : -m);
            if (wrong < 0) wrong = 0;
            if (wrong > 99) wrong = 99;
            buttons[i].setText(String.valueOf(wrong));
        }
        startTimer();
    }
    private void startTimer(){
        if(timer != null) timer.cancel();
        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("⏱ " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                // Hết thời gian → hiện đáp án đúng
                buttons[correctIndex].setBackgroundColor(Color.parseColor("#4CAF50"));
                Toast.makeText(MainActivity.this, "Hết thời gian! Đáp án: " + correctAns, Toast.LENGTH_SHORT).show();

                new android.os.Handler().postDelayed(() -> generateQuestion(), 1500);
            }
        }.start();
    }
    private void checkAnswer(View view){
        timer.cancel();

        Button clicked = (Button) view;
        int chosen = Integer.parseInt(clicked.getText().toString());

        if (chosen == correctAns) {
            clicked.setBackgroundResource(R.drawable.btn_correct); // xanh lá
            coin += 100;
            tvCoin.setText("+ " + coin);
            Toast.makeText(this, "Chính xác!", Toast.LENGTH_SHORT).show();
        } else {
            clicked.setBackgroundResource(R.drawable.btn_wrong); // đỏ
            coin -= 100;
            buttons[correctIndex].setBackgroundResource(R.drawable.btn_correct);
            Toast.makeText(this, "Sai rồi!", Toast.LENGTH_SHORT).show();
        }

        // Sau 1,5 giây chuyển sang câu mới
        new android.os.Handler().postDelayed(() -> generateQuestion(), 1500);
    }
    private void resetButtonColors(){
        for (Button btn : buttons) {
            btn.setBackgroundResource(R.drawable.btn_quiz); // trả lại màu gốc
        }
    }
}