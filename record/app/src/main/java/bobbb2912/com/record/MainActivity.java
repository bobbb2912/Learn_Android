package bobbb2912.com.record;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStartRecord, btnStopRecord, btnPlayFile, btnStopFile;

    public MediaRecorder mediaRecorder;
    public MediaPlayer mediaPlayer;
    public String outputFile = null;
String[]arrayOf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        btnStartRecord = findViewById(R.id.btnStartRecord);
        btnStopRecord = findViewById(R.id.btnStopRecord);
        btnPlayFile = findViewById(R.id.btnPlayFile);
        btnStopFile = findViewById(R.id.btnStopFile);

        btnStartRecord.setOnClickListener(this);
        btnStopRecord.setOnClickListener(this);
        btnPlayFile.setOnClickListener(this);
        btnStopFile.setOnClickListener(this);

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        // this method is called when user will
//        // grant the permission for audio recording.
//        switch (requestCode) {
//            case REQUEST_AUDIO_PERMISSION_CODE:
//                if (grantResults.length > 0) {
//                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    boolean permissionToStore = grantResults[1] == PackageManager.PERMISSION_GRANTED;
//                    if (permissionToRecord && permissionToStore) {
//                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_LONG).show();
//                    }
//                }
//                break;
//        }
//    }
//
//    public boolean CheckPermissions() {
//        // this method is used to check permission
//        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
//        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
//        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
//    }
//
//    private void RequestPermissions() {
//        // this method is used to request the
//        // permission for audio recording and storage.
//        ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, REQUEST_AUDIO_PERMISSION_CODE);
//    }

    public void XuLy(){

//        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(MainActivity.this, arrayOf(Manifest.permission.RECORD_AUDIO) ,0);
//            return;
//        }
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/hien.3gpp";
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(outputFile);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartRecord:
                StartRecord();
                break;
            case R.id.btnStopRecord:
                StopRecord();
                break;
            case R.id.btnPlayFile:
                PlayFile();

                break;
            case R.id.btnStopFile:
                StopFile();
                break;

        }
    }

    public void StopFile() {
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
            Toast.makeText(this, "ngung play gile ghi am", Toast.LENGTH_SHORT).show();
        }
    }

    public void PlayFile() {

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(outputFile);
            mediaPlayer.start();
            Toast.makeText(this, "bat du play file", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StopRecord() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        Toast.makeText(this, "ngung ghi am", Toast.LENGTH_SHORT).show();


    }

    public void StartRecord() {
        XuLy();
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
            Toast.makeText(this, "bat dau ghi am", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}