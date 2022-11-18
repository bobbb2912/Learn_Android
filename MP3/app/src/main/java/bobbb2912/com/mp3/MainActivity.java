package bobbb2912.com.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStop, btnPlay, btnPause;
    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        btnStop = findViewById(R.id.btnStop);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);

        btnStop.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);

        song = MediaPlayer.create(MainActivity.this, R.raw.tothemoon);
//
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStop:
                song.pause();
                song = MediaPlayer.create(MainActivity.this, R.raw.tothemoon);
                break;
            case R.id.btnPlay:
                song.start();
                break;
            case R.id.btnPause:
                song.pause();
                break;
        }
    }
}