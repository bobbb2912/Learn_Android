package bobbb2912.com.truyenthamsogiuahaimanhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ManHinh2 extends AppCompatActivity {

    TextView txtHoTen, txtTuoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        init();
    }

    public void init() {
        txtHoTen = findViewById(R.id.txtHoTen);
        txtTuoi = findViewById(R.id.txtTuoi);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            String hoTen = bundle.getString("ten");
            int tuoi = bundle.getInt("tuoi");

            String strTen = "Ho ten: " + hoTen;
            String strTuoi = "Tuoi: " + String.valueOf(tuoi);
            txtHoTen.setText(strTen);
            txtTuoi.setText(strTuoi);
        }
    }
}