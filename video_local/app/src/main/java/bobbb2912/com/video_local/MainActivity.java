package bobbb2912.com.video_local;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        video = findViewById(R.id.video);

        video.setMediaController(new MediaController(MainActivity.this));
//        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        video.start();
    }
}