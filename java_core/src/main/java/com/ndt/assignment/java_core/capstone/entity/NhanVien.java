package com.ndt.assignment.java_core.capstone.entity;


public class NhanVien extends Human {
    private TruongPhong truongPhong;


    public NhanVien() {
        super();
    }


    public NhanVien(String maSo, String hoTen, String soDienThoai, double luongMotNgay, int soNgayLamViec) {
        this(maSo, hoTen, soDienThoai, luongMotNgay, soNgayLamViec, null);
    }


    public NhanVien(String maSo, String hoTen, String soDienThoai, double luongMotNgay, int soNgayLamViec, TruongPhong truongPhong) {
        super(maSo, hoTen, soDienThoai, luongMotNgay, soNgayLamViec);
        this.truongPhong = truongPhong;
    }


    public TruongPhong getTruongPhong() {
        return truongPhong;
    }


    public void setTruongPhong(TruongPhong truongPhong) {
        this.truongPhong = truongPhong;
    }


    @Override
    public double tinhLuongThang() {
        return luongMotNgay * soNgayLamViec;
    }


    @Override
    public String toString() {
        return "NV{" +
            super.toString() + ", " +
            "truongPhong=" + truongPhong +
            '}';
    }


    @Override
    public void remove() {
        truongPhong = null;
    }

    // @Override
    // public void PreRemove() {
    //     truongPhong.getNhanVienLst().remove(this);
    //     truongPhong = null;
    // }
}
