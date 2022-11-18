package bobbb2912.com.listview_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    EditText edtTimKiem;
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
        edtTimKiem = findViewById(R.id.edtTimKiem);

        Collections.addAll(hocSinhList, hocSinhArray);

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, hocSinhList);
        lvDanhSach.setAdapter(customAdapter);

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                customAdapter.filter(edtTimKiem.getText().toString().toLowerCase(Locale.getDefault()));
            }
        });
    }

}