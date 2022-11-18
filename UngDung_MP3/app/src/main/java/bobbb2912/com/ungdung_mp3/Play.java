package bobbb2912.com.ungdung_mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class Play extends AppCompatActivity implements View.OnClickListener{
    TextView txtBaiHat, txtTimeStart, txtTimeEnd;
    ImageView imgDisc;
    SeekBar skTimer;
    ImageButton btnPlay, btnNext, btnPrev;
    ArrayList<MP3> list = new ArrayList<>();
    int position;
    MediaPlayer song;
    Boolean flag;
    Timer timer;
    RunTimer runTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        init();

        xuLy(position);

        rotateDisc();
    }

    public void init() {
        txtBaiHat = (TextView) findViewById(R.id.txtBaiHat_Play);
        txtTimeStart = (TextView) findViewById(R.id.txtTimeStart);
        txtTimeEnd = (TextView) findViewById(R.id.txtTimeEnd);
        imgDisc = (ImageView) findViewById(R.id.imgDisc);
        skTimer = (SeekBar) findViewById(R.id.skTimer);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnPrev = (ImageButton) findViewById(R.id.btnPrev);

        imgDisc.setImageResource(R.drawable.dianhac);
        btnPlay.setImageResource(R.drawable.pause60px);
        btnNext.setImageResource(R.drawable.fastforward60px);
        btnPrev.setImageResource(R.drawable.rewind60px);

        flag=false;

        btnPlay.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);

        Data data = new Data();
        Collections.addAll(list, data.arr);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            position = bundle.getInt("id");
        }
    }

    public void xuLy(int pos) {
        if(flag) {
            song.stop();
            timer.cancel();
        }

        String tenBH = list.get(pos).baiHat;
        String link = list.get(pos).url;
        txtBaiHat.setText(tenBH);
        getSong(link);
        flag=true;
    }

    public void getSong(String link) {
        song = MediaPlayer.create(Play.this, Uri.parse(link));

        song.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                song.start();
                int timeDuration = song.getDuration();
                convertTime(txtTimeEnd, timeDuration);

                skTimer.setMax(timeDuration);
                skTimer.setProgress(0);
                skTimer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        song.seekTo(seekBar.getProgress());
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        song.seekTo(seekBar.getProgress());
                    }
                });
                timer = new Timer();
                runTimer = new RunTimer();
                timer.scheduleAtFixedRate(runTimer, 0, 1);
            }
        });
    }

    public class RunTimer extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    skTimer.incrementProgressBy(1);
                    convertTime(txtTimeStart, skTimer.getProgress());
                }
            });
        }
    }

    public void convertTime(TextView tv, int time) {
        NumberFormat f = new DecimalFormat("00");
        long timeMinutes = TimeUnit.MILLISECONDS.toMinutes((long) time);
        long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(timeMinutes);
        String result = f.format(timeMinutes) + " : " + f.format(timeSeconds);
        tv.setText(result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                if(flag) {
                    btnPlay.setImageResource(R.drawable.play60px);
                    song.pause();
                    runTimer.cancel();
                    runTimer = new RunTimer();
                    timer.scheduleAtFixedRate(runTimer, 0, 1);
                    flag=false;
                } else {
                    btnPlay.setImageResource(R.drawable.pause60px);
                    song.start();
                    flag=true;
                }
                break;
            case R.id.btnNext:
                if(position==(list.size()-1)) {
                    position = 0;
                } else {
                    position = position+1;
                    xuLy(position);
                }

                break;
            case R.id.btnPrev:
                if(position == 0) {
                    position=(list.size()-1);
                }else {
                    position = position-1;
                    xuLy(position);
                }

                break;
        }
    }

    public void rotateDisc() {
        RotateAnimation rotate = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5F, RotateAnimation.RELATIVE_TO_SELF, 0.5F);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setDuration(5000);
        imgDisc.startAnimation(rotate);
    }
}