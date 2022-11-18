package bobbb2912.com.learn_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManHinh3 extends AppCompatActivity {

    Button btnMHinh2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh3);
        init();
    }
    public void init() {
        btnMHinh2 = findViewById(R.id.btnMHinh2);

        btnMHinh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinh3.this, ManHinh2.class);
                startActivity(intent);
            }
        });
    }
}