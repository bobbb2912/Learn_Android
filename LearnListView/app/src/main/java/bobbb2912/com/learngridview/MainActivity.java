package bobbb2912.com.learngridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView lvMonAn;
    ArrayList<String> list = new ArrayList<>();
    String ds[] = {"pho", "cha ca", "banh xeo", "cao lau", "rau muong", "nem ran", "goi cuon", "bun bo hue", "banh khot", "ga tan", "nom hoa chuoi", "bun bo nam bo", "hoa qua dam", "pho cuon", "ga nuong", "pho xao", "ca phe trung", "bo la lot", "xoi", "banh cuon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        lvMonAn = findViewById(R.id.lvMonAn);

        Collections.addAll(list, ds);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lvMonAn.setAdapter(adapter);

        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String monan = list.get(i);
                Toast.makeText(MainActivity.this, monan, Toast.LENGTH_SHORT).show();
            }
        });

    }
}