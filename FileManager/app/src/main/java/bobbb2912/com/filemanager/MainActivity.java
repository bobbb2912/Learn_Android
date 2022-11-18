package bobbb2912.com.filemanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnHinh, btnPhim, btnNhac;
    ImageView imgHinh;
    VideoView vdPhim;

    public final int RSESULT_IMG=1;
    public final int RSESULT_MP3=2;
    public final int RSESULT_VIDEO=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        btnHinh = findViewById(R.id.btnHinh);
        btnPhim = findViewById(R.id.btnPhim);
        btnNhac = findViewById(R.id.btnNhac);
        imgHinh = findViewById(R.id.imgHinh);
        vdPhim = findViewById(R.id.vdPhim);

        btnHinh.setOnClickListener(this);
        btnNhac.setOnClickListener(this);
        btnPhim.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnHinh:
                Intent intentGetImg = new Intent();
                intentGetImg.setAction(Intent.ACTION_PICK);
                intentGetImg.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGetImg, RSESULT_IMG);

                break;
            case R.id.btnNhac:
                Intent intentGetMP3 = new Intent();
                intentGetMP3.setAction(Intent.ACTION_PICK);
                intentGetMP3.setData(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGetMP3, RSESULT_MP3);
                break;
            case R.id.btnPhim:
                Intent intentGetVideo = new Intent();
                intentGetVideo.setAction(Intent.ACTION_PICK);
                intentGetVideo.setData(MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGetVideo, RSESULT_VIDEO);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK && data!=null) {
            if(requestCode==RSESULT_IMG) {
                try {
                    Uri imgdata = data.getData();
                    imgHinh.setImageURI(imgdata);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(requestCode==RSESULT_MP3) {
                try {
                    Uri mp3data = data.getData();
                    MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, mp3data);
                    mediaPlayer.start();

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }if(requestCode==RSESULT_VIDEO) {
                try {
                    Uri videodata = data.getData();
                    vdPhim.setVideoURI(videodata);
                    vdPhim.start();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}