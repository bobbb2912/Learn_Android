package bobbb2912.com.listview_adapter;

public class HocSinh {
    public Integer hinh;
    public String ten;
    public Integer tuoi;

    public Integer getHinh() {
        return hinh;
    }

    public void setHinh(Integer hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public HocSinh(Integer hinh, String ten, Integer tuoi) {
        this.hinh = hinh;
        this.ten = ten;
        this.tuoi = tuoi;
    }
}
