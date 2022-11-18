package bobbb2912.com.listview_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    ArrayList<HocSinh> hocSinhList = new ArrayList<>();
    HocSinh[] hocSinhArray = {
            new HocSinh(R.drawable.s1, "Nguyen Thi Hien", 20),
            new HocSinh(R.drawable.s2, "Nguyen Thi Hien1", 20),
            new HocSinh(R.drawable.s3, "Nguyen Thi Hien2", 20),
            new HocSinh(R.drawable.s4, "Nguyen Thi Hien4", 20),
            new HocSinh(R.drawable.s5, "Nguyen Thi Hien5", 20),
            new HocSinh(R.drawable.s1, "Nguyen Thi Hien", 20),
            new HocSinh(R.drawable.s2, "Nguyen Thi Hien1", 20),
            new HocSinh(R.drawable.s3, "Nguyen Thi Hien2", 20),
            new HocSinh(R.drawable.s4, "Nguyen Thi Hien4", 20),
            new HocSinh(R.drawable.s5, "Nguyen Thi Hien5", 20)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
        Collections.addAll(hocSinhList, hocSinhArray);

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, hocSinhList);
        lvDanhSach.setAdapter(customAdapter);
    }
}