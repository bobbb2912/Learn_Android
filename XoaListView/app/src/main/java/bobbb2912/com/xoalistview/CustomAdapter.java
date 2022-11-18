package bobbb2912.com.xoalistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<MP3> mp3ArrayList = new ArrayList<>();
    LayoutInflater inflater = null;

    public CustomAdapter(Context context, ArrayList<MP3> mp3ArrayList) {
        this.context = context;
        this.mp3ArrayList = mp3ArrayList;

        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mp3ArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return mp3ArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
            view=inflater.inflate(R.layout.activity_dong, viewGroup, false);
        }

        ImageView imgHinh = (ImageView) view.findViewById(R.id.imgHinh);
        TextView txtBaiHat = (TextView) view.findViewById(R.id.txtBaiHat);
        TextView txtCaSi = (TextView) view.findViewById(R.id.txtCaSi);

        imgHinh.setImageResource(mp3ArrayList.get(i).hinh);
        txtBaiHat.setText(mp3ArrayList.get(i).baiHat);
        txtCaSi.setText(mp3ArrayList.get(i).caSi);

        return view;
    }
}
