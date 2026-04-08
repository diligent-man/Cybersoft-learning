package com.ndt.java_core.day_15;

import java.util.Scanner;


public class SinhVien {
    private String maSV;

    private String ten;

    private int tuoi;

    private String gioiTinh;


    public SinhVien() {
    }


    public SinhVien(String maSv, String gioiTinh, String ten, int tuoi) {
        this.maSV = maSv;
        this.gioiTinh = gioiTinh;
        this.ten = ten;
        this.tuoi = tuoi;
    }


    public String getMaSV() {
        return maSV;
    }


    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }


    public String getGioiTinh() {
        return gioiTinh;
    }


    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }


    public String getTen() {
        return ten;
    }


    public void setTen(String ten) {
        this.ten = ten;
    }


    public int getTuoi() {
        return tuoi;
    }


    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }


    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap Ten: ");
        this.ten = sc.nextLine();

        System.out.println("Nhap Tuoi: ");
        this.tuoi = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap Gioi Tinh: ");
        this.gioiTinh = sc.nextLine();
    }


    @Override
    public String toString() {
        return "SinhVien{" +
            "gioiTinh='" + gioiTinh + '\'' +
            ", ten='" + ten + '\'' +
            ", tuoi=" + tuoi +
            '}';
    }
}
