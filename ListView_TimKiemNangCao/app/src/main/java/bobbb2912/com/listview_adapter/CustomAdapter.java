package bobbb2912.com.listview_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater = null;
    ArrayList<HocSinh> hocSinhList = new ArrayList<>();
    ArrayList<HocSinh> temp = new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<HocSinh> hocSinhList) {
        this.context = context;
        this.hocSinhList = hocSinhList;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.temp.addAll(hocSinhList);
    }

    @Override
    public int getCount() {
        return hocSinhList.size();
    }

    @Override
    public Object getItem(int i) {
        return hocSinhList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
            view = inflater.inflate(R.layout.activity_dong, viewGroup,false);

        }
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imgHinh);
        TextView txtHoTen = (TextView) view.findViewById(R.id.txtHoTen);
        TextView txtTuoi = (TextView) view.findViewById(R.id.txtTuoi);

        txtHoTen.setText(hocSinhList.get(i).ten);
        txtTuoi.setText(String.valueOf(hocSinhList.get(i).tuoi));
        Picasso.with(context).load(hocSinhList.get(i).hinh).resize(100, 100).into(imgHinh);
//        imgHinh.setImageResource(hocSinhList.get(i).hinh);
        return view;
    }

    public void filter(String keys) {
        hocSinhList.clear();
        String charText = keys.toLowerCase(Locale.getDefault());

        if(charText.length() == 0) {
            hocSinhList.addAll(temp);

        } else {
            for(HocSinh hocSinh:temp) {
                if(hocSinh.getTen().toLowerCase(Locale.getDefault()).contains(charText)) {
                    hocSinhList.add(hocSinh);
                }
            }
        }
        notifyDataSetChanged();
    }
}




























