package bobbb2912.com.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtKQ1, txtKQ2;
    Button btnRandom1, btnRandom2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        btnRandom1=findViewById(R.id.btnRandom1);
        btnRandom2=findViewById(R.id.btnRandom2);
        txtKQ1=findViewById(R.id.txtKQ1);
        txtKQ2=findViewById(R.id.txtKQ2);

        btnRandom1.setOnClickListener(this);
        btnRandom2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRandom1:
                //random tu 0 den 99
                int r1=getRandom(100);
                txtKQ1.setText(String.valueOf(r1));
                break;
            case R.id.btnRandom2:
                int r2=getRandomMinMax(10, 20);
                txtKQ2.setText(String.valueOf(r2));
                break;
        }
    }

    public int getRandom(int max) {
        return (int) (Math.random()*max);
    }

    public int getRandomMinMax(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min))+min;
    }
}