package bobbb2912.com.learnchronometerphaohoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    int timCountDown;
    Button btnDem;
    EditText edtThoiGian;
    TextView txtSo;
    Chronometer chnThoiGian;
    ConstraintLayout layout;
    int []mangHinh={
            R.drawable.anh1,
            R.drawable.anh2,
            R.drawable.anh3,
            R.drawable.anh4,
            R.drawable.anh5,
            R.drawable.anh6,
            R.drawable.anh7,
            R.drawable.anh8,
            R.drawable.anh9,
            R.drawable.anh10,
            R.drawable.anh11
    };
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        btnDem = findViewById(R.id.btnDem);
        edtThoiGian = findViewById(R.id.edtThoiGian);
        txtSo = findViewById(R.id.txtSo);
        chnThoiGian = findViewById(R.id.chnThoiGian);
        layout = findViewById(R.id.layout);

        chnThoiGian.setVisibility(View.INVISIBLE);
        btnDem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLy();
            }
        });

    }

    private void XuLy() {
        if(edtThoiGian.getText().toString().trim().length() <= 0) {
            Toast.makeText(this, "Vui long nhap thoi gian", Toast.LENGTH_SHORT).show();
        } else {
            timCountDown = Integer.parseInt(edtThoiGian.getText().toString().trim());
            if(timCountDown > 0) {
                chnThoiGian.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if(timCountDown>0) {
                            timCountDown--;
                            txtSo.setText(String.valueOf(timCountDown));
                        }else {
                            FireWork();
                            chnThoiGian.stop();
                        }

                    }
                });
                chnThoiGian.start();
            }else {
                Toast.makeText(this, "thoi gian phai lon hon 0", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void FireWork() {
        timer = new Timer();
        Animate animate = new Animate(layout, mangHinh);
        timer.scheduleAtFixedRate(animate, 100, 100);
        StopAnimate();
    }

    private void StopAnimate() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                AnHienDoiTuong(View.INVISIBLE);
            }

            @Override
            public void onFinish() {
                AnHienDoiTuong(View.VISIBLE);
                timer.cancel();
                CountDownTimer countDownTimer1 = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long l) {
                        layout.setBackgroundResource(0);
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();

            }
        }.start();
    }

    private void AnHienDoiTuong(int visible) {
        edtThoiGian.setVisibility(visible);
        txtSo.setVisibility(visible);
        btnDem.setVisibility(visible);
    }

    public class Animate extends TimerTask {
        ConstraintLayout layout;
        int []mangHinh={};

        public Animate(ConstraintLayout layout, int[] mangHinh) {
            this.layout = layout;
            this.mangHinh = mangHinh;
        }

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    layout.setBackgroundResource(mangHinh[i]);
                    i=i+1;
                    if(i>10) {
                        i=0;
                    }
                }
            });
        }
    }
}