package bobbb2912.com.json_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        JsonParser jsonParser = new JsonParser(MainActivity.this);

        jsonParser.execute("http://jsonviewer.stack.hu/");
    }
}