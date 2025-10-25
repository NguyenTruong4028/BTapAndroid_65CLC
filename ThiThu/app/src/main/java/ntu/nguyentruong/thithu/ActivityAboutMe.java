package ntu.nguyentruong.thithu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityAboutMe extends AppCompatActivity {

    private CircleImageView profileImage;
    private TextView tvName, tvTitle, tvBio, tvEmail, tvPhone, tvFacebook;
    private LinearLayout layoutEmail, layoutPhone, layoutFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        // Khởi tạo views
        initViews();

        // Thiết lập dữ liệu
        setData();

        // Thiết lập sự kiện click
        setClickListeners();
    }

    private void initViews() {
        profileImage = findViewById(R.id.profileImage);
        tvName = findViewById(R.id.tvName);
        tvTitle = findViewById(R.id.tvTitle);
        tvBio = findViewById(R.id.tvBio);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvFacebook = findViewById(R.id.tvFacebook);

        layoutEmail = findViewById(R.id.layoutEmail);
        layoutPhone = findViewById(R.id.layoutPhone);
        layoutFacebook = findViewById(R.id.layoutFacebook);
    }

    private void setData() {
        // Cập nhật thông tin của bạn ở đây
        tvName.setText("Nguyễn Văn A");
        tvTitle.setText("Android Developer");
        tvBio.setText("Xin chào! Tôi là một lập trình viên Android đam mê công nghệ " +
                "và luôn học hỏi những điều mới mỗi ngày. Tôi thích xây dựng những " +
                "ứng dụng hữu ích và có giao diện đẹp mắt.");
        tvEmail.setText("email@example.com");
        tvPhone.setText("+84 123 456 789");
        tvFacebook.setText("facebook.com/nguyen.truong.808900");
    }

    private void setClickListeners() {
        // Click vào email để gửi email
        layoutEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tvEmail.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Liên hệ từ ứng dụng");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Gửi email qua..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ActivityAboutMe.this,
                            "Không tìm thấy ứng dụng email",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Click vào số điện thoại để gọi
        layoutPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = tvPhone.getText().toString();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + phone));

                try {
                    startActivity(dialIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ActivityAboutMe.this,
                            "Không thể thực hiện cuộc gọi",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Click vào website để mở trình duyệt
        layoutFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = tvFacebook.getText().toString();
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "https://" + url;
                }

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                try {
                    startActivity(browserIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ActivityAboutMe.this,
                            "Không thể mở trình duyệt",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}