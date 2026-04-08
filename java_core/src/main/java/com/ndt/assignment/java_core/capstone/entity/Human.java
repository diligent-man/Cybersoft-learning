package com.ndt.assignment.java_core.capstone.entity;

public abstract class Human implements ChamCong {
    protected String maSo;

    protected String hoTen;

    protected String soDienThoai;

    protected int soNgayLamViec;

    protected double luongMotNgay;


    public Human() {
    }


    public Human(String maSo, String hoTen, String soDienThoai, double luongMotNgay, int soNgayLamViec) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.luongMotNgay = luongMotNgay;
        this.soNgayLamViec = soNgayLamViec;
    }


    public String getHoTen() {
        return hoTen;
    }


    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }


    public double getLuongMotNgay() {
        return luongMotNgay;
    }


    public void setLuongMotNgay(double luongMotNgay) {
        this.luongMotNgay = luongMotNgay;
    }


    public String getMaSo() {
        return maSo;
    }


    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }


    public String getSoDienThoai() {
        return soDienThoai;
    }


    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }


    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }


    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }


    @Override
    public abstract double tinhLuongThang();


    @Override
    public String toString() {
        return String.format("""
                maSo='%s', hoTen='%s', phone='%s', soNgayLamViec=%d, luongMotNgay=%.2f""",
            maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay
        );
    }
}
