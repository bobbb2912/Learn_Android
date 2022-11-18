package bobbb2912.com.learn_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ManHinh3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh3);
        actionBarSetUp();
    }

    public void actionBarSetUp() {
        try {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Man Hinh 3"); //thiet lap tieu de
//            String title = actionBar.getTitle(); // Lay tieu de
//            actionBar.hide(); // an acctitonBar
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}