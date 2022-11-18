package bobbb2912.com.learnimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imgHinh;
    Button btnOk;
    EditText edtLink;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout) findViewById(R.id.layout);
        layout.setBackgroundResource(R.drawable.ic_launcher_background);
        init();
    }

    public void init() {
        //idea.max.intellisense.filesize=10500
        imgHinh = findViewById(R.id.imgHInh);
        btnOk = findViewById(R.id.btnOk);
        edtLink = findViewById(R.id.edtLink);



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtLink.getText().toString().length()  <= 0){
                    Toast.makeText(MainActivity.this, "Vui long nhap link", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
                    new LoadHinh().execute(edtLink.getText().toString());
                }
            }
        });
    }
    private class LoadHinh extends AsyncTask<String, Integer, Bitmap> {

        Bitmap bmp = null;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL u = new URL(strings[0]);
                bmp = BitmapFactory.decodeStream(u.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgHinh.setImageBitmap(bitmap);
        }
    }
}

