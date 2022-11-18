package bobbb2912.com.truyenthamsogiuahaimanhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtHoTen, edtTuoi;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtTuoi = findViewById(R.id.edtTuoi);
        btnGui = findViewById(R.id.btnGui);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtHoTen.getText().toString().trim().length()<=0 || edtTuoi.getText().toString().trim().length()<=0) {
                    Toast.makeText(MainActivity.this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, ManHinh2.class);
                    intent.putExtra("ten", edtHoTen.getText().toString().trim());
                    intent.putExtra("tuoi", Integer.parseInt(edtTuoi.getText().toString().trim()));

                    startActivity(intent);
                }

            }
        });

    }
}