package bobbb2912.com.learn_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManHinh2 extends AppCompatActivity {

    Button btnMH1, btnMH3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);

        init();
    }

    public void init() {
        btnMH1 = findViewById(R.id.btnMH1);
        btnMH3 = findViewById(R.id.btnMH3);

        btnMH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinh2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnMH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinh2.this, ManHinh3.class);
                startActivity(intent);
            }
        });
    }
}