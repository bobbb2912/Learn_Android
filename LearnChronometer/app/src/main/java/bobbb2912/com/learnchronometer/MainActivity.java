package bobbb2912.com.learnchronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Chronometer chnDem;
    Button btnStart, btnPause, btnStop;
    Boolean flag=false;
    long timeWhenPause = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        chnDem=findViewById(R.id.chnDem);
        btnStart=findViewById(R.id.btnStart);
        btnPause=findViewById(R.id.btnPause);
        btnStop=findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                if(!flag) {
                    long currentTime = SystemClock.elapsedRealtime()+timeWhenPause;
                    chnDem.setBase(currentTime);
                    chnDem.start();
                    flag = true;
                }

                break;
            case R.id.btnPause:
                if (flag) {
                    chnDem.stop();
                    timeWhenPause = chnDem.getBase()-SystemClock.elapsedRealtime();
                    flag=false;
                }
                break;
            case R.id.btnStop:
                if(flag){
                    chnDem.stop();
                    timeWhenPause=0;
                    flag=false;
                }

                break;
        }
    }
}