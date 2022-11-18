package bobbb2912.com.spllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Them extends AppCompatActivity {

    EditText edtThemHoTen, edtThemDienThoai, edtThemEmail;
    Button btnThem;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);

        init();
    }

    public void init() {
        edtThemHoTen = findViewById(R.id.edtThemHoTen);
        edtThemDienThoai = findViewById(R.id.edtThemDienThoai);
        edtThemEmail = findViewById(R.id.edtThemEmail);
        btnThem = findViewById(R.id.btnThem);

        db = new DatabaseHelper(this);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyThem();
            }
        });
    }

    public void XuLyThem() {
        if (edtThemDienThoai.getText().toString().trim().length() <= 0
        || edtThemEmail.getText().toString().trim().length() <= 0
        || edtThemHoTen.getText().toString().trim().length() <= 0) {
            Toast.makeText(this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();

        } else {
            SinhVien sv = new SinhVien();
            sv.setSvname(edtThemHoTen.getText().toString().trim());
            sv.setSvphone(edtThemDienThoai.getText().toString().trim());
            sv.setSvemail(edtThemEmail.getText().toString().trim());
            sv.setSvname(edtThemHoTen.getText().toString().trim());

            db.CreateSinhVien(sv);

        }






















    }
}