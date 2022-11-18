package bobbb2912.com.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;

//https://www.androidhive.info/2014/05/android-working-with-volley-library-1/
public class MainActivity extends AppCompatActivity {
//https://openexchangerates.org/api/latest.json?app_id=3736be9819df496997ac3f2c766d1a3d
    private String urlString = "";
    private String urlJSONOJ = "https://openexchangerates.org/api/latest.json?app_id=3736be9819df496997ac3f2c766d1a3d";
    private String urlJSONARRAY = "";
    private String urlIMG = "https://scontent.fhan2-2.fna.fbcdn.net/v/t39.30808-6/280520553_5738073846222290_4627335936047473293_n.jpg?_nc_cat=1&ccb=1-6&_nc_sid=730e14&_nc_ohc=lOU69SS4GOYAX9868e0&_nc_ht=scontent.fhan2-2.fna&oh=00_AT9leZHGm3a70fNUNupj6L-YGaIU9x_34HBpDMKBy9Hjdw&oe=6289DF69";
    public ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        imgHinh = findViewById(R.id.imgHinh);

//        getString(urlString);
//        getJSONOJ(urlJSONOJ);
//        getJSONARRAY(urlJSONARRAY);
        getIMG(urlIMG);
    }

    public void getString(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Loi:", error.getMessage());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void getJSONOJ(String url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject rateObj = response.getJSONObject("rates");
                    String VND = rateObj.getString("USD");
                    Toast.makeText(MainActivity.this, VND, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
    public void getJSONARRAY(String url) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int  i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonArray = response.getJSONObject(i);
                        String title = jsonArray.getString("title");
                        Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
    public void getIMG(String url) {
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imgHinh.setImageBitmap(response);
            }
        }, 300, 300, ImageView.ScaleType.FIT_CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Loi", error.getMessage());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(imageRequest);
    }
}