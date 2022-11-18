package bobbb2912.com.docfilexml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<XMLItem> xmlItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        XMLParser xmlParser = new XMLParser(xmlItems);
        xmlParser.execute("http://mobile.qhonline.edu.vn/xml/example.xml");

//        String name = xmlItems.get(1).getLastName();
//        Log.d("last name", name);
    }
}