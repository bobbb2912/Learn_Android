package bobbb2912.com.ungdungjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtToaDo, txtNhietDo, txtApSuat, txtGio, txtMay;
    ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        txtToaDo = findViewById(R.id.txtToaDo);
        txtNhietDo = findViewById(R.id.txtNhietDo);
        txtApSuat = findViewById(R.id.txtApSuat);
        txtGio = findViewById(R.id.txtGio);
        txtMay = findViewById(R.id.txtMay);
        imgIcon = findViewById(R.id.imgIcon);

        JSONParser parser = new JSONParser(MainActivity.this, txtToaDo, txtNhietDo, txtApSuat, txtGio, txtMay, imgIcon);
        parser.execute("https://api.openweathermap.org/data/2.5/weather?id=1581130&appid=d3d4cbc3735fc13c78014d90480c07b3");

    }
}