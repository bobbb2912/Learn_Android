package bobbb2912.com.pulltorefresh_listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    ListView lvDanhSach;
    SwipeRefreshLayout swipeLayout;

    ArrayList<String> list = new ArrayList<>();
    String[] nameOld = {
            "hien", "linh", "uyen" , "trang"
    };
    String[] nameNew = {
            "hien1", "linh1", "uyen1" , "trang1"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
        swipeLayout = findViewById(R.id.swipeLayout);

        Collections.addAll(list, nameOld);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lvDanhSach.setAdapter(adapter);

        //mau refresh
        swipeLayout.setColorSchemeColors(Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW, Color.CYAN);
        swipeLayout.setDistanceToTriggerSync(100);
        swipeLayout.setSize(SwipeRefreshLayout.LARGE);

        swipeLayout.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                swipeLayout.setRefreshing(false);

                list.clear();
                Collections.addAll(list, nameNew);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                lvDanhSach.setAdapter(adapter);

            }
        }.start();
    }
}