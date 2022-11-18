package bobbb2912.com.countdowntime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCountDown;
    TextView txtKQ;
    int dem=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        btnCountDown=findViewById(R.id.btnCountdown);
        txtKQ=findViewById(R.id.txtKQ);

        btnCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDown();
            }
        });
    }

    private void CountDown() {
        //1s=1000 mili giay
        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            //moi mot giay thi thuc hien cong viec
            // l = millisUntilFinished: thoi gian con lai
            public void onTick(long l) {
//                dem+=1;
//                txtKQ.setText(String.valueOf(dem));
                txtKQ.setText("Thoi gian con lai: " + l/1000);
                btnCountDown.setVisibility(View.INVISIBLE);
                txtKQ.setVisibility(View.VISIBLE);
            }

            @Override
            //khi hoan thanh cong viec gi do
            public void onFinish() {
                Toast.makeText(MainActivity.this, "xong", Toast.LENGTH_SHORT).show();
                btnCountDown.setVisibility(View.VISIBLE);
                txtKQ.setVisibility(View.GONE);
            }
        }.start();
    }
}