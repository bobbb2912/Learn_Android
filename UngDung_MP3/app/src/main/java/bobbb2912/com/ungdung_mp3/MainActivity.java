package bobbb2912.com.ungdung_mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView lvDanhSach;


    ArrayList<MP3> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach);


        Data data = new Data();
        Collections.addAll(list, data.arr);

        CustomAdapter adapter = new CustomAdapter(list, MainActivity.this);
        lvDanhSach.setAdapter(adapter);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Play.class);
                intent.putExtra("id", i);
                startActivity(intent);
            }
        });

    }
}