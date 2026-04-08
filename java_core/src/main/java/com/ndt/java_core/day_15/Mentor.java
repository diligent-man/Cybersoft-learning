package com.ndt.java_core.day_15;

import java.util.Scanner;


public class Mentor extends SinhVien {
    private double luong;


    public Mentor() {

    }


    public Mentor(double luong) {
        this.luong = luong;
    }


    public Mentor(String maSv, String gioiTinh, String ten, int tuoi, double luong) {
        super(maSv, gioiTinh, ten, tuoi);
        this.luong = luong;
    }


    public double getLuong() {
        return luong;
    }


    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public void Nhap() {
        super.Nhap(); // goij nhap cua sv

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Luong: ");
        this.luong = sc.nextDouble();
    }


    @Override
    public String toString() {
        return "Mentor{" +
            "luong=" + luong +
            '}';
    }
}
