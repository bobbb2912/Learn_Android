package bobbb2912.com.spllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sua extends AppCompatActivity {
    EditText edtSuaHoTen, edtSuaDienThoai, edtSuaEmail;
    Button btnSua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);

        init();
    }

    public void init() {
        edtSuaHoTen = findViewById(R.id.edtThemHoTen);
        edtSuaDienThoai = findViewById(R.id.edtThemDienThoai);
        edtSuaEmail = findViewById(R.id.edtThemEmail);
        btnSua = findViewById(R.id.btnThem);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLySua();
            }
        });
    }

    public void XuLySua() {

    }
}