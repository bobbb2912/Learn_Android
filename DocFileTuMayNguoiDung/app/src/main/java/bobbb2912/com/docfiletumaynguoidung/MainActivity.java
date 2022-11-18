package bobbb2912.com.docfiletumaynguoidung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtNhap;
    Button btnRead, btnWrite;
    TextView txtNoiDung;
    boolean w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        edtNhap = findViewById(R.id.edtNhap);
        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);
        txtNoiDung = findViewById(R.id.txtNoiDung);

        btnRead.setOnClickListener(this);
        btnWrite.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRead:
                XuLyRead();
                break;
            case R.id.btnWrite:
                XuLyWrite();
                break;
        }
    }

    public void XuLyWrite() {
        try {
            String url = "/sdcard/testGhiFile.txt";
            File file = new File(url);
            w = file.createNewFile();
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);

            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.append(edtNhap.getText());
            fos.close();
            osw.close();
            Toast.makeText(MainActivity.this, "Ghi file vao SD thanh cong", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            System.out.println("LOI: " + e.getMessage());
            e.printStackTrace();
        }


    }

    public void XuLyRead() {

        try {
            String url = "/sdcard/testGhiFile.txt";
            File file = new File(url);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            String data;
            while ((data=bufferedReader.readLine()) != null) {
                builder.append(data);
            }
            fis.close();
            inputStreamReader.close();
            bufferedReader.close();
            txtNoiDung.setText(builder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}