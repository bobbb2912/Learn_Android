package bobbb2912.com.ontap1_gamecongso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    SeekBar skThoiGian;
    TextView txtKQ, txtS1, txtS2, txtDiem;
    ImageButton btnCheck, btnUnCheck;
    ConstraintLayout layout;
    int diem;
    int thoiGian;
    Timer timer;
    Boolean flag=false;

    ArrayList<Integer> bgColor = new ArrayList<>();
    Integer[]  mauNen = {
            Color.parseColor("#453A4A"),
            Color.parseColor("#D75300"),
            Color.parseColor("#F39C11"),
            Color.parseColor("#293C4E"),
            Color.parseColor("#F34546")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        skThoiGian=findViewById(R.id.skThoiGian);
        txtKQ=findViewById(R.id.txtKQ);
        txtS1=findViewById(R.id.txtS1);
        txtS2=findViewById(R.id.txtS2);
        txtDiem=findViewById(R.id.txtDiem);
        btnCheck=findViewById(R.id.btnCheck);
        btnUnCheck=findViewById(R.id.btnUnCheck);
        layout=findViewById(R.id.layout);
        PhepToan();
        diem=0;
        thoiGian=100;
        skThoiGian.setMax(thoiGian);
        skThoiGian.setProgress(thoiGian);
        txtDiem.setText(String.valueOf(diem));
        XuLyBg();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dung();
                runThoiGian();
            }
        });

        btnUnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sai();
                runThoiGian();

            }
        });
    }

    private void PhepToan() {
        int r1=getRandomMinMax(0, 21);
        txtS1.setText(String.valueOf(r1));
        int r2=getRandomMinMax(0, 21);
        txtS2.setText(String.valueOf(r2));

        int r3 = r1 + r2;
        int kq=getRandomMinMax(r3-2, r3+2);
        txtKQ.setText(String.valueOf(kq));
    }

    public int getRandomMinMax(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min))+min;
    }

    public void Dung() {
        int so1 = Integer.parseInt(txtS1.getText().toString());
        int so2 = Integer.parseInt(txtS2.getText().toString());
        int soKQ = Integer.parseInt(txtKQ.getText().toString());

        if(so1+so2==soKQ) {
            diem=diem+1;
            txtDiem.setText(String.valueOf(diem));
            PhepToan();
            thoiGian=100;
        } else {
            thua();
        }

    }
    public void Sai() {
        int so1 = Integer.parseInt(txtS1.getText().toString());
        int so2 = Integer.parseInt(txtS2.getText().toString());
        int soKQ = Integer.parseInt(txtKQ.getText().toString());

        if(so1+so2!=soKQ) {
            diem=diem+1;
            txtDiem.setText(String.valueOf(diem));
            PhepToan();
            thoiGian=100;
        } else {
            thua();
        }
    }


    public void thua() {
        timer.cancel();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Thong bao")
                .setMessage("Ban co muon choi tiep khong?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Choi tiep", Toast.LENGTH_SHORT).show();
                        init();
                        
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Bye~", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }

    public void XuLyBg() {
        Collections.addAll(bgColor, mauNen);
        int mauNen = getRandomMinMax(0, bgColor.size());
        layout.setBackgroundColor(bgColor.get(mauNen));
    }

    public void runThoiGian() {
        if(!flag) {
            timer = new Timer();
            RunRandomPhepToan runRandomPhepToan = new RunRandomPhepToan();
            timer.scheduleAtFixedRate(runRandomPhepToan, 100, 100);
            flag=true;
        }

    }
    class RunRandomPhepToan extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    thoiGian--;
                    skThoiGian.setProgress(thoiGian);
                }
            });
        }
    }


}