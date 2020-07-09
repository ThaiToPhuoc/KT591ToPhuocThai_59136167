package vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.model;

public class info {
    String date;
    String tien;
    String mua;
    String ban;

    public info() {
    }

    public info(String date, String tien, String mua, String ban) {
        this.date = date;
        this.tien = tien;
        this.mua = mua;
        this.ban = ban;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }

    public String getMua() {
        return mua;
    }

    public void setMua(String mua) {
        this.mua = mua;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }
}
