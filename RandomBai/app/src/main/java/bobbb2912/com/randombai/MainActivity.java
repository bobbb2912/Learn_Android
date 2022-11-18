package bobbb2912.com.randombai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button btnPlay;
    TextView txtTotal;
    ImageView imgBai1, imgBai2, imgBai3;
    ArrayList<Integer>img = new ArrayList<>();
    ArrayList<Integer>point = new ArrayList<>();
    Integer[] hinh = {
      R.drawable.h1, R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5
    };
    Integer[] diem = {
            1, 2, 3, 4, 5,
            1, 2, 3, 4, 5,
            1, 2, 3, 4, 5,
            1, 2, 3, 4, 5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // Ẩn cả thanh tiêu đề đi
        init();
    }

    public void init() {
        btnPlay = findViewById(R.id.btnPlay);
        txtTotal = findViewById(R.id.txtTotal);
        imgBai1 = findViewById(R.id.imgBai1);
        imgBai2 = findViewById(R.id.imgBai2);
        imgBai3 = findViewById(R.id.imgBai3);

        dataArray();

        ImageSetup();


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLy();
            }
        });

    }

    private void ImageSetup() {
        imgBai1.setImageResource(R.drawable.anhlabai);
        imgBai2.setImageResource(R.drawable.anhlabai);
        imgBai3.setImageResource(R.drawable.anhlabai);
    }

    public int getRandom(int max){
        return (int) (Math.random()*max);
    }

    private void XuLy() {
        if(img.size()<3) {
            txtTotal.setText("Da het bai!");
            ImageSetup();

            img.clear();
            point.clear();
            dataArray();
        } else {
            int diem1 = getDiem(imgBai1);

            int diem2 = getDiem(imgBai2);

            int diem3 = getDiem(imgBai3);

            int tongDiem=diem1+diem2+diem3;
            txtTotal.setText(String.valueOf(tongDiem));
        }

    }

    private void dataArray() {
        Collections.addAll(img, hinh);
        Collections.addAll(point, diem);
    }

    private int getDiem(ImageView imgBai1) {
        int totalCard1 = img.size();
        int labai1 = getRandom(totalCard1);
        imgBai1.setImageResource(img.get(labai1));
        int diem1 = point.get(labai1);
        img.remove(labai1);
        point.remove(labai1);
        return diem1;
    }
}