package bobbb2912.com.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
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

        song = MediaPlayer.create(MainActivity.this, Uri.parse(
                "https://mp3-320s1-zmp3.zmdcdn.me/38ef74ebd1af38f161be/8398526085473003844?authen=exp=1651493690~acl=/38ef74ebd1af38f161be/*~hmac=9573cac08ed018d3d4030db734ffe65a&fs=MTY1MTMyMDg5MDAyM3x3ZWJWNnwxMDQ2NzkyNTM4fDExOC43MS4xNjUdUngOA"
        ));
//
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStop:
                song.pause();
                song = MediaPlayer.create(MainActivity.this, Uri.parse(
                        "https://mp3-320s1-zmp3.zmdcdn.me/38ef74ebd1af38f161be/8398526085473003844?authen=exp=1651493690~acl=/38ef74ebd1af38f161be/*~hmac=9573cac08ed018d3d4030db734ffe65a&fs=MTY1MTMyMDg5MDAyM3x3ZWJWNnwxMDQ2NzkyNTM4fDExOC43MS4xNjUdUngOA"
                ));                break;
            case R.id.btnPlay:
                song.start();
                break;
            case R.id.btnPause:
                song.pause();
                break;
        }
    }
}