package bobbb2912.com.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSimple, btnCustom, btnLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        btnSimple = findViewById(R.id.btnSimple);
        btnCustom = findViewById(R.id.btnCustom);
        btnLayout = findViewById(R.id.btnLayout);

        btnSimple.setOnClickListener(this);
        btnCustom.setOnClickListener(this);
        btnLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnSimple:
                dialogSimple();
                break;
            case R.id.btnCustom:
                dialogCustom();
                break;
            case R.id.btnLayout:
                dialogLayout();
                break;
        }
    }

    private void dialogLayout() {
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        View customView = inflater.inflate(R.layout.activity_custom_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Thong bao")
                .setView(customView)
                .setPositiveButton("co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "chua xoa", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        builder.create().show();
    }

    private void dialogCustom() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Thong bao")
                .setMessage("Ban co chac muon xoa du lieu hay khong")
                .setPositiveButton("co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "chua xoa", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        builder.create().show();
    }

    private void dialogSimple() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Thong bao")
                .setMessage("Ban co chac muon xoa du lieu hay khong")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "chua xoa", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false);
        builder.create().show();
    }
}