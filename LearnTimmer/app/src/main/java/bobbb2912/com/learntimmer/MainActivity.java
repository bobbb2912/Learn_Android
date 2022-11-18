package bobbb2912.com.learntimmer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    ImageView imgHinh;
    Timer timer;
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
        imgHinh = findViewById(R.id.imgHinh);
        timer=new Timer();
        MyTask myTask = new MyTask(imgHinh, mangHinh);
        timer.scheduleAtFixedRate(myTask, 1000, 300);
    }

    public class MyTask extends TimerTask {

        ImageView imgHinh;
        int []mangHinh={};

        public MyTask(ImageView imgHinh, int[] mangHinh) {
            this.imgHinh = imgHinh;
            this.mangHinh = mangHinh;
        }

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imgHinh.setImageResource(mangHinh[i]);
                    i+=1;
                    if(i>10) {
                        i=0;
                    }
                }
            });
        }
    }
}