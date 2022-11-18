package bobbb2912.com.docfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button btnDocFile;
    TextView txtNoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        btnDocFile = findViewById(R.id.btnDocFile);
        txtNoiDung = findViewById(R.id.txtNoiDung);

        btnDocFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLy();
            }
        });
    }

    public void XuLy() {
        InputStream in = this.getResources().openRawResource(R.raw.noteandroid);
        InputStreamReader inputStreamReader = new InputStreamReader(in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String data;
        try {

            while((data = bufferedReader.readLine()) != null) {
                builder.append(data);
            }
            in.close();
            txtNoiDung.setText(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
