package bobbb2912.com.learnbai13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtSoNhat, edtSoHai;
    TextView txtKetQua;
    Button btnCong, btnTru, btnNhan, btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        edtSoNhat = findViewById(R.id.edtSoNhat);
        edtSoHai = findViewById(R.id.edtSoHai);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCong:
                if(edtSoNhat.getText().toString().trim().length() <= 0 || edtSoHai.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    int tong = Integer.parseInt(edtSoNhat.getText().toString()) + Integer.parseInt(edtSoHai.getText().toString());
                    txtKetQua.setText(Integer.toString(tong));
                }
                break;
            case R.id.btnTru:
                if(edtSoNhat.getText().toString().trim().length() <= 0 || edtSoHai.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    int tong = Integer.parseInt(edtSoNhat.getText().toString()) - Integer.parseInt(edtSoHai.getText().toString());
                    txtKetQua.setText(Integer.toString(tong));
                }
                break;
            case R.id.btnNhan:
                if(edtSoNhat.getText().toString().trim().length() <= 0 || edtSoHai.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    int tong = Integer.parseInt(edtSoNhat.getText().toString()) * Integer.parseInt(edtSoHai.getText().toString());
                    txtKetQua.setText(Integer.toString(tong));
                }
                break;
            case R.id.btnChia:
                if(edtSoNhat.getText().toString().trim().length() <= 0 || edtSoHai.getText().toString().trim().length() <= 0) {
                    Toast.makeText(this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(Float.parseFloat(edtSoHai.getText().toString()) == 0) {
                        Toast.makeText(this, "So chia phai khac 0", Toast.LENGTH_SHORT).show();
                    } else {
                        float tong = Float.parseFloat(edtSoNhat.getText().toString()) / Float.parseFloat(edtSoHai.getText().toString());
                        txtKetQua.setText(Float.toString(tong));
                    }

                }

                break;
        }
    }


}