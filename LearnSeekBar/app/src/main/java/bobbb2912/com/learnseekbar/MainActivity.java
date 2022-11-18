package bobbb2912.com.learnseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar skHinh;
    ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        skHinh = findViewById(R.id.skHinh);
        imgHinh = findViewById(R.id.imgHinh);

        int minVal = 1;
        int maxVal = 5;
        skHinh.setMax(maxVal-minVal);

        String imgcurrent = "a"+(skHinh.getProgress()+1);
        imgHinh.setImageResource(getResources().getIdentifier(imgcurrent, "drawable", getPackageName()));
        skHinh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i+minVal;
                String tenHinh = "a"+i;
                int resID = getResources().getIdentifier(tenHinh, "drawable", getPackageName());
                imgHinh.setImageResource(resID);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}