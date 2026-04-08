package com.ndt.java_core.day_15;

import java.util.List;
import java.util.ArrayList;


public class GiangVien extends Mentor {
    private List<SinhVien> sinhVienLst = new ArrayList<SinhVien>();


    public GiangVien() {
    }


    public GiangVien(List<SinhVien> lstSinhVien) {
        this.sinhVienLst = lstSinhVien;
    }


    public GiangVien(String maSv, String gioiTinh, String ten, int tuoi, double luong) {
        super(maSv, gioiTinh, ten, tuoi, luong);
    }


    public GiangVien(double luong, List<SinhVien> lstSinhVien) {
        super(luong);
        this.sinhVienLst = lstSinhVien;
    }


    public List<SinhVien> getSinhVienLst() {
        return sinhVienLst;
    }


    public void setSinhVienLst(List<SinhVien> sinhVienLst) {
        this.sinhVienLst = sinhVienLst;
    }


    @Override
    public String toString() {
        return "GiangVien{" +
            "sinhVienLst=" + sinhVienLst +
            '}';
    }
}
