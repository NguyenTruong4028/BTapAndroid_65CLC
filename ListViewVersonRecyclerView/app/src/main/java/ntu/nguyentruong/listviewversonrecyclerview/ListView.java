package ntu.nguyentruong.listviewversonrecyclerview;

import android.widget.TextView;

public class ListView {
    String tvSubject;

    public ListView(String tvSubject) {
        this.tvSubject = tvSubject;
    }

    public String getTvSubject() {
        return tvSubject;
    }

    public void setTvSubject(String tvSubject) {
        this.tvSubject = tvSubject;
    }
}
