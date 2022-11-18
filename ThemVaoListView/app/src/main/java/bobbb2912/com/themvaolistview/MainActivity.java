package bobbb2912.com.themvaolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText edtThem;
    ListView lvDanhSach;

    ArrayList<String> list = new ArrayList<>();
    String[] arr = {
            "Nguyen Hien", "Bob"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        edtThem=findViewById(R.id.edtThem);
        lvDanhSach=findViewById(R.id.lvDanhSach);

        Collections.addAll(list, arr);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lvDanhSach.setAdapter(adapter);
        edtThem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(textView.getText().toString().trim().length()==0) {
                    Toast.makeText(MainActivity.this, "Vui long nhap ho ten", Toast.LENGTH_SHORT).show();
                } else {
                    if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER) {
//                        textView.setText("");
                        list.add(textView.getText().toString().trim());
                        adapter.notifyDataSetChanged();
                        textView.setText("");
//                        edtThem.requestFocus();
                    }
                }

                return false;
            }
        });
    }
}