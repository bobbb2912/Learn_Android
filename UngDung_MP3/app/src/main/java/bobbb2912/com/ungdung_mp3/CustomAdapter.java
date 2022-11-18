package bobbb2912.com.ungdung_mp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{

    ArrayList<MP3> list = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public CustomAdapter(ArrayList<MP3> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
            view = inflater.inflate(R.layout.activity_dong, viewGroup, false);
        }
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imgHinh);
        TextView txtBaiHat = (TextView) view.findViewById(R.id.txtBaiHat);
        TextView txtCaSi = (TextView) view.findViewById(R.id.txtCaSi);

        txtCaSi.setText(list.get(i).caSi);
        txtBaiHat.setText(list.get(i).baiHat);
        imgHinh.setImageResource(list.get(i).hinh);
//        Picasso.with(context).load(list.get(i).hinh).resize(100, 100).into(imgHinh);

        return view;
    }
}
