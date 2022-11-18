package bobbb2912.com.ungdungjson;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class JSONParser extends AsyncTask<String, Integer, ArrayList> {

    ArrayList<Weather> weathers;

    Context context;
    TextView txtToaDo, txtNhietDo, txtApSuat, txtGio, txtMay;
    ImageView imgIcon;

    public JSONParser(Context context, TextView txtToaDo, TextView txtNhietDo, TextView txtApSuat, TextView txtGio, TextView txtMay, ImageView imgIcon) {
        this.context = context;
        this.txtToaDo = txtToaDo;
        this.txtNhietDo = txtNhietDo;
        this.txtApSuat = txtApSuat;
        this.txtGio = txtGio;
        this.txtMay = txtMay;
        this.imgIcon = imgIcon;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        weathers = new ArrayList<>();
    }

    @Override
    protected ArrayList doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            InputStream is = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line+"\n");
            }
            Weather thoiTiet = new Weather();

            JSONObject object = new JSONObject(stringBuilder.toString());
            JSONObject coord = object.getJSONObject("coord");
            String kinhDo = coord.getString("lon");
            String viDo = coord.getString("lat");
            String toaDo = kinhDo + " - " + viDo;
            thoiTiet.setToaDo(toaDo);

            JSONObject main = object.getJSONObject("main");
            String nhietDo = main.getString("temp");
            thoiTiet.setNhietDo(nhietDo);
            String apSuat = main.getString("pressure");
            thoiTiet.setApSuat(apSuat);

            JSONObject wind = object.getJSONObject("wind");
            String tocDoGio = wind.getString("speed");
            thoiTiet.setGio(tocDoGio);
//
            JSONObject clouds = object.getJSONObject("clouds");
            String may = clouds.getString("all");
            thoiTiet.setMay(may);
//
            JSONArray weather = object.getJSONArray("weather");
            JSONObject iconObject = weather.getJSONObject(0);
            String icon = iconObject.getString("icon");
            thoiTiet.setHinh("https://openweathermap.org/img/w/"+icon+".png");

            weathers.add(thoiTiet);



        } catch (Exception e) {
            e.printStackTrace();
        }

        return weathers;
    }

    @Override
    protected void onPostExecute(ArrayList arrayList) {
        super.onPostExecute(arrayList);
        txtToaDo.setText(weathers.get(0).getToaDo());
        txtNhietDo.setText(weathers.get(0).getNhietDo());
        txtApSuat.setText(weathers.get(0).getApSuat());
        txtGio.setText(weathers.get(0).getGio());
        txtMay.setText(weathers.get(0).getMay());
        Picasso.with(context).load(weathers.get(0).getHinh()).resize(100, 100).into(imgIcon);



    }
}
