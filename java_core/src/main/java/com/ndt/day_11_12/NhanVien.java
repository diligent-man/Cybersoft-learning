package com.ndt.day_11_12;


public class NhanVien {
    String ten;

    String gioiTinh;

    short tuoi;

    String soDienThoai;

    String diaChi;


    public NhanVien() {
    }


    public NhanVien(String ten, String gioiTinh) {
        // 'this' đại diện cho chính đối tượng
        this.ten = ten;
        this.gioiTinh = gioiTinh;
    }


    public void xuatThongTin() {
        System.out.println("Ten nhanh vien: " + ten);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("Tuoi: " + tuoi);
    }


    @Override
    public String toString() {
        return "NhanVien{" +
            "ten='" + ten + '\'' +
            ", gioiTinh='" + gioiTinh + '\'' +
            ", tuoi=" + tuoi +
            ", soDienThoai='" + soDienThoai + '\'' +
            ", diaChi='" + diaChi + '\'' +
            '}';
    }
}
