package bobbb2912.com.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtHoTen,edtDienThoai;
    Button btnSave;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Load();
    }

    public void init() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtDienThoai = findViewById(R.id.edtDienThoai);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });
    }

    public void Save() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", edtHoTen.getText().toString().trim());
        editor.putInt("dienthoai", Integer.parseInt(edtDienThoai.getText().toString().trim()));
        editor.apply();
    }

    public void Load() {
        sp = getSharedPreferences("myShare", Context.MODE_PRIVATE);
        String ten = sp.getString("name", "khong co gia tri");
        int dienThoai = sp.getInt("dienthoai", 0);

        String kq = "Ho ten: " + ten + ", Dien thoai: " + dienThoai;
        Toast.makeText(this, kq, Toast.LENGTH_LONG).show();
    }
}