package bobbb2912.com.random2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int itemOnArray;
    Button btnBocTham;
    TextView txtHienThi;
    Timer timer;
    int countTheFirst=0;
    int stop=0;
    String []list = {"Nguyen Thi Hien", "Bui Ngoc Linh","Nguyen To Uyen","Nguyen Huyen Trang"};
    ArrayList<String> danhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        btnBocTham = findViewById(R.id.btnBocTham);
        txtHienThi = findViewById(R.id.txtHienThi);

        danhSach=new ArrayList<>();
        Collections.addAll(danhSach, list);

        btnBocTham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLy();
            }
        });

    }

    private void XuLy() {
        timer = new Timer();
        RunRandom runRandom = new RunRandom();
        timer.scheduleAtFixedRate(runRandom, 100, 100);
        if(countTheFirst!=0) {
            if(!danhSach.isEmpty()) {
                danhSach.remove(itemOnArray);
            }
        }
        countTheFirst++;

    }

    public class RunRandom extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(!danhSach.isEmpty()) {
                        stop++;
                        if (stop>=20) {
                            timer.cancel();
                            stop=0;
                        } else {
                            int totalItem = danhSach.size();
                            itemOnArray = getRandom(totalItem);
                            txtHienThi.setText(danhSach.get(itemOnArray));
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Danh sach da het", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
        public int getRandom(int max){
            return (int) (Math.random()*max);
        }
    }
}