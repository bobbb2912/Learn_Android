package bobbb2912.com.learnswitchandlogguebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ToggleButton click;
    EditText edtLink;
    ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        click = findViewById(R.id.btnClick);
        edtLink = findViewById(R.id.edtLink);
        imgHinh = findViewById(R.id.imgHinh);

        click.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(click.isChecked()) {
                    if(edtLink.getText().toString().trim().length() <= 0) {
                        Toast.makeText(MainActivity.this, "Vui long nhap link", Toast.LENGTH_SHORT).show();
                    } else {
                        String group = edtLink.getText().toString().trim();
                        String fb = "https://graph.facebook.com/"+group+"/picture/?type=large";
                        Toast.makeText(MainActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
                        new LoadHinh().execute(fb);
                    }
                } else {
                    if(edtLink.getText().toString().trim().length() <= 0) {
                        Toast.makeText(MainActivity.this, "Vui long nhap link", Toast.LENGTH_SHORT).show();
                    } else {
                        String nick = edtLink.getText().toString().trim();
                        String yh = "https://img.msg.yahoo.com/v1/displayImage/yahoo" + nick;
                        Toast.makeText(MainActivity.this, "Yahoo", Toast.LENGTH_SHORT).show();
                        new LoadHinh().execute(nick);
                    }
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