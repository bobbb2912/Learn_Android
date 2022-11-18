package bobbb2912.com.webview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<RSSItem> rssItems = new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<RSSItem> rssItems) {
        this.context = context;
        this.rssItems = rssItems;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return rssItems.size();
    }

    @Override
    public Object getItem(int i) {
        return rssItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            view = inflater.inflate(R.layout.activity_dong, viewGroup, false);

        }

        ImageView imgHinh = view.findViewById(R.id.imgHinh);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtMoTa = view.findViewById(R.id.txtMoTa);
        try {
//            String urlHinh = cutImage(rssItems.get(i).getDescription());
//            Picasso.with(context).load(urlHinh).resize(100, 100).centerCrop().into(imgHinh);
//            imgHinh.setImageResource(Integer.parseInt(cutImage(rssItems.get(1).getDescription())));
            txtTitle.setText(rssItems.get(i).getTitle());
            txtMoTa.setText(rssItems.get(i).getDescription());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return view;
    }

    public String cutImage(String s) {
//        <img src="(http?\\/\\/.*\\.(?:png|jpg))" >
        String pattern = "<img src=\"(http?:\\\\/\\\\/.*\\\\.(?:png|jpg))\" >";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);

        if(m.find()) {
            System.out.println("Found value: " + m.group(1));
            return m.group(1);
        } else {
            System.out.println("NO MATCH");
        }
        return "";
    }
}
