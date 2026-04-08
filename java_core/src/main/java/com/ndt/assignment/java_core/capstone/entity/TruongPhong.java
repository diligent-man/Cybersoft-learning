package com.ndt.assignment.java_core.capstone.entity;

import java.util.*;


public class TruongPhong extends Human {
    private List<NhanVien> nhanVienLst;


    public TruongPhong() {
        super();
    }


    public TruongPhong(String maSo, String hoTen, String soDienThoai, double luongMotNgay, int soNgayLamViec) {
        this(maSo, hoTen, soDienThoai, luongMotNgay, soNgayLamViec, null);
    }


    public TruongPhong(String maSo, String hoTen, String soDienThoai, double luongMotNgay, int soNgayLamViec, List<NhanVien> nhanVienLst) {
        super(maSo, hoTen, soDienThoai, luongMotNgay, soNgayLamViec);
        this.nhanVienLst = Objects.requireNonNullElse(nhanVienLst, new ArrayList<>());
    }


    public int getSoLuongNhanVienQuanLy() {
        return nhanVienLst.size();
    }


    public List<NhanVien> getNhanVienLst() {
        return nhanVienLst;
    }


    @Override
    public double tinhLuongThang() {
        return luongMotNgay * soNgayLamViec + 100 * nhanVienLst.size();
    }


    @Override
    public String toString() {
        return "TP{" +
            super.toString() + ", " +
            "nhanVienLst=" + Arrays.toString(nhanVienLst.stream().map(Human::getMaSo).toArray(String[]::new)
        ) +
            '}';
    }


    @Override
    public void remove() {
        nhanVienLst.forEach(NhanVien::remove);
    }


    public void quanLy(NhanVien nv) {
        if (!nhanVienLst.contains(nv))
            nhanVienLst.add(nv);
        else
            System.out.println("Nhan vien nay da duoc quan ly");
    }
}
