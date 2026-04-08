package com.ndt.java_core.day_15;

import java.util.ArrayList;
import java.util.List;


public class TrungTam extends GiangVien {
    List<SinhVien> nguoiDungLst = new ArrayList<>();

    private String tenTrungTam;

    private String maSoThue;

    private double doanhThuThang;


    public TrungTam() {
    }


    public TrungTam(double doanhThuThang, String maSoThue, String tenCongTy) {
        this.doanhThuThang = doanhThuThang;
        this.maSoThue = maSoThue;
        this.tenTrungTam = tenCongTy;
    }


    public double getDoanhThuThang() {
        return doanhThuThang;
    }


    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }


    public String getMaSoThue() {
        return maSoThue;
    }


    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }


    public List<SinhVien> getNguoiDungLst() {
        return nguoiDungLst;
    }


    public void setNguoiDungLst(List<SinhVien> nguoiDungLst) {
        this.nguoiDungLst = nguoiDungLst;
    }


    public String getTenTrungTam() {
        return tenTrungTam;
    }


    public void setTenTrungTam(String tenTrungTam) {
        this.tenTrungTam = tenTrungTam;
    }


    public void HienThiThongTin() {
        System.out.println("THONG TIN TRUNG TAM - " + tenTrungTam);
        System.out.println("MST: 		" + this.maSoThue);
        System.out.println("Doanh Thu: 	" + this.doanhThuThang);
        System.out.println("So luong nd: " + nguoiDungLst.size());

    }
}
