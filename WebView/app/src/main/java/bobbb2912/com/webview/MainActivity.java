package bobbb2912.com.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

//bai 75: https://drive.google.com/drive/folders/1ZK-XFP_DVqpepibgxG86U6qeySvW5HUs
public class MainActivity extends AppCompatActivity {

    ArrayList<RSSItem> data = new ArrayList<>();
    ListView lvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        lvDanhSach = findViewById(R.id.lvDanhSach);

        XMLParse parse = new XMLParse(data, MainActivity.this, lvDanhSach);
        parse.execute("https://vnexpress.net/rss/du-lich.rss");
    }
}