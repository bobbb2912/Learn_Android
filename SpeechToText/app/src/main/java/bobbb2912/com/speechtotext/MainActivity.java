package bobbb2912.com.speechtotext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//bai 70: https://drive.google.com/drive/folders/1ZK-XFP_DVqpepibgxG86U6qeySvW5HUs
    Button btnSpeech;
    TextView txtContent;
    String str;

    public static final int RESULT_SPEECH = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        btnSpeech = findViewById(R.id.btnSpeech);
        txtContent = findViewById(R.id.txtContent);

        btnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLy();
            }
        });
    }

    public void XuLy() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-Us");
        try {

//            startActivityForResult(intent, RESULT_SPEECH); //du lieu dung de ban di kiem tra tien trinh
            txtContent.setText("");
        }catch (ActivityNotFoundException a) {
            Toast.makeText(this, a+"thiet bi khong ho tro", Toast.LENGTH_SHORT).show();
            System.out.println(a.getMessage());
        }
        

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data!=null) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    str = text.get(0);
                    txtContent.setText(str);
                }
                break;
        }
    }
}