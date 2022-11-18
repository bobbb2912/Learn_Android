package bobbb2912.com.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ChiTiet extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        init();
    }

    public void init() {
        webView = findViewById(R.id.WebView);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            String url = bundle.getString("link");
            webView.loadUrl(url);
        }

    }
}