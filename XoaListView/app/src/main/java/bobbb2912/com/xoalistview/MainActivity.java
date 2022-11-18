package bobbb2912.com.xoalistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMp3;
    ArrayList<MP3> mp3ArrayList = new ArrayList<>();
    CustomAdapter customAdapter;
    MP3[] mp3 = {
            new MP3("Ba thuong con", "Quoc Teuan", R.drawable.s1),
            new MP3("Ba thuong con", "Quoc Tuan", R.drawable.s2),
            new MP3("Ba thuong con", "Quoc Tuan", R.drawable.s3),
            new MP3("Ba thuong con1", "Qeuoc3 Tuan", R.drawable.s4),
            new MP3("Ba thuong con1", "Quoc 3Tuan", R.drawable.s5),
            new MP3("Ba thuong con12", "Quoce wTuan", R.drawable.s1),
            new MP3("Ba thuong con2", "Queoc Tuan", R.drawable.s2),
            new MP3("Ba thuong co2n", "Quoc 3Tua2n", R.drawable.s3),
            new MP3("Ba thuong 3con", "Quoc Tuan", R.drawable.s4),
            new MP3("Ba thuong 3con", "Quoc Tuan", R.drawable.s5)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        lvMp3 = findViewById(R.id.lvMp3);

        Collections.addAll(mp3ArrayList, mp3);

        customAdapter = new CustomAdapter(MainActivity.this, mp3ArrayList);
        lvMp3.setAdapter(customAdapter);
        lvMp3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                xoa(i);
                return false;
            }
        });

    }

    public void xoa(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Thong bao")
                .setMessage("Ban co chac muon xoa du lieu hay khong")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mp3ArrayList.remove(position);
                        customAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "chua xoa", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
    }
}