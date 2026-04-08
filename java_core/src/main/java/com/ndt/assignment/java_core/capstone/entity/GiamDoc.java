package com.ndt.assignment.java_core.capstone.entity;


public class GiamDoc extends Human {
    private double coPhan;


    public GiamDoc() {
        super();
    }


    public GiamDoc(String maSo, String hoTen, String soDienThoai, double luongMotNgay, int soNgayLamViec, double coPhan) {
        super(maSo, hoTen, soDienThoai, luongMotNgay, soNgayLamViec);
        this.coPhan = coPhan;
    }


    public double getCoPhan() {
        return coPhan;
    }


    public void setCoPhan(double coPhan) {
        this.coPhan = coPhan;
    }


    @Override
    public double tinhLuongThang() {
        return luongMotNgay * soNgayLamViec;
    }


    @Override
    public String toString() {
        return "GD{" +
            super.toString() + ", " +
            "coPhan=" + coPhan +
            '}';
    }

    public void remove() {}
}
