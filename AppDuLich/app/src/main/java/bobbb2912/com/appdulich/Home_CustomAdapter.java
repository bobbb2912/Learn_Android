package bobbb2912.com.appdulich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bobbb2912.com.appdulich.object.BaiViet;

public class Home_CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater = null;
    ArrayList<BaiViet> baiVietList = new ArrayList<>();

    public Home_CustomAdapter(Context context, ArrayList<BaiViet> baiVietList) {
        this.context = context;
        this.inflater = inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return baiVietList.size();
    }

    @Override
    public Object getItem(int position) {
        return baiVietList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_bai_viet, parent, false);

        }

        TextView txtTenNguoiDung  = convertView.findViewById(R.id.txtTenNguoiDung);
        TextView txtNoiDung = convertView.findViewById(R.id.txtNoiDung);
        ImageView imgHinhAnh = convertView.findViewById(R.id.imgHinhAnh);

        txtTenNguoiDung.setText(baiVietList.get(position).tenNguoiDung);
        txtNoiDung.setText(baiVietList.get(position).noiDung);
//        imgHinhAnh.setImageResource(baiVietList.get(position).hinhAnh);
//        Picasso.with(context).load(baiVietList.get(position).hinhAnh).resize(378, 355).into(imgHinhAnh);

        return convertView;
    }
}
