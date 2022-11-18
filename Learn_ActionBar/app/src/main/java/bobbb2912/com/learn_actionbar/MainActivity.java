package bobbb2912.com.learn_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMH2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        btnMH2 = findViewById(R.id.btnMH2);

        btnMH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ManHinh2.class);
                startActivity(intent);
            }
        });
        actionBarSetUp();
    }

    public void actionBarSetUp() {
        try {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Man Hinh 1"); //thiet lap tieu de
//            String title = actionBar.getTitle(); // Lay tieu de
//            actionBar.hide(); // an acctitonBar
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}