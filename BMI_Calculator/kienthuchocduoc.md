# Về giao diện
- Sử dụng RadioGroup để đưa ra lựa chọn 1 trong 2.
- Sự khác biệt giữa tools:text và android:text
    + tools:text: đây là thuộc tính xem trước, nội dung mà mình ghi chỉ hiển thị ở cửa sổ preview
    + android:text: là thuộc tính hiển thị thật, người dùng cuối sẽ thấy.
# Về cài đặt chương trình
- Sử dụng lắng nghe ẩn danh cho button
- setError là một phương thức của đối tượng EditText trong Android dùng để hiển thị thông báo lỗi nhỏ ngay trên ô nhập liệu đó.
    + Cú pháp: tenbien.setError("")
    + Thường được sử dụng cùng với requestFocus() để tự động di chuyển con trỏ đến chỗ bị lỗi.
- Thuộc tính getCheckedRadioButtonId() của đối tượng RadioGroup dùng để trả về id của radiobutton nào được chọn. 
    + Nhờ vào thuộc tính này để biết được là radiobutton người Châu Á có được chọn không bằng cách so sánh chúng với nhau -> boolean isAsianStandard = radioGroupStandard.getCheckedRadioButtonId() == R.id.radioButtonAsian;
- Định dạng số thập phân: DecimalFormat("#.#") -> Hiển thị 1 số sau dấu phẩy.
    + Mỗi dấu # sau dấu phẩy đại diện hiển thị bao nhiêu số sau dấu phẩy.
- Muốn định dạng một số theo ý muốn:
    + Đầu tiên: tạo khuôn định dạng [DecimalFormat df = new DecimalFormat("#.#")]
    + Áp dụng khuôn vào số mình thay đổi định dạng [String bmiText = "Chỉ số BMI của bạn là: " + df.format(bmi);] -> sử dụng format()
- Để lấy màu và thay đổi màu sắc tùy thuộc vào kết quả ta có 2 cách
    + Color.RED (Có thể thay RED bằng tên các màu cơ bản như BLUE, BLACK, YELLOW...)
    + ContextCompat.getColor(this, android.R.id.xxx): nếu bạn muốn dùng các màu khác các màu cơ bản đã được định dạng sẵn. Trong đó phương thức getColor() có 2 tham sôs context và id của màu trả vể int.

