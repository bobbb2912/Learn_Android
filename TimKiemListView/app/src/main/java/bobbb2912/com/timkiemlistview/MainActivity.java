package bobbb2912.com.timkiemlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.EGLExt;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    EditText edtTimKiem;
    ListView lvDanhSach;
    ArrayAdapter<String> adapter;
    String[] monAn= {
            "pho", "cha ca", "banh xeo", "cao lau", "rau muong", "nem ran", "goi cuon",
            "bun bo hue", "banh khot", "ga tan", "nom hoa chuoi", "bun bo nam bo",
            "hoa qua dam", "pho cuon", "ga nuong", "pho xao", "ca phe trung",
            "bo la lot", "xoi", "banh cuon"
    };
    ArrayList<String> listMonAn = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        edtTimKiem = findViewById(R.id.edtTimKiem);
        lvDanhSach = findViewById(R.id.lvDanhSach);

        Collections.addAll(listMonAn, monAn);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listMonAn);
        lvDanhSach.setAdapter(adapter);

        TimKiem();

    }

    public void TimKiem() {
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(editable.toString());
            }
        });
    }
}