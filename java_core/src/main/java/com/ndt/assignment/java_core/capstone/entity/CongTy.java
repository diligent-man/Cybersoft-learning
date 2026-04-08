package com.ndt.assignment.java_core.capstone.entity;


import com.ndt.utils.AnsiColor;


public class CongTy {
    private static CongTy instance;

    private String tenCongTy = "Cybersoft";

    private String maSoThue = "079-xxx-xxx-xxx";

    private Double doanhThuThang = 1_000_000_000.;


    private CongTy() {

    }


    public static CongTy getInstance() {
        if (instance == null) {
            return new CongTy();
        }
        return instance;
    }


    public Double getDoanhThuThang() {
        return doanhThuThang;
    }


    public void setDoanhThuThang(Double doanhThuThang) {
        if (doanhThuThang != null) {
            this.doanhThuThang = doanhThuThang;
        } else{
            System.out.printf("Doanh thu thang is set to default value: %s%s%s\n", AnsiColor.CYAN, this.maSoThue, AnsiColor.RESET);
        }
    }


    public String getMaSoThue() {
        return maSoThue;
    }


    public void setMaSoThue(String maSoThue) {
        if (!(maSoThue == null || maSoThue.isBlank())) {
            this.maSoThue = maSoThue;
        } else{
            System.out.printf("Ma so thue is set to default value: %s%s%s\n", AnsiColor.CYAN, this.maSoThue, AnsiColor.RESET);
        }
    }


    public String getTenCongTy() {
        return tenCongTy;
    }


    public void setTenCongTy(String tenCongTy) {
        if (!(tenCongTy == null || tenCongTy.isBlank())) {
            this.tenCongTy = tenCongTy;
        } else{
            System.out.printf("Ten cong ty is set to default value: %s%s%s\n", AnsiColor.CYAN, this.tenCongTy, AnsiColor.RESET);
        }
    }
}
