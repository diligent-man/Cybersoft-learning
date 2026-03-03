package com.ndt.day_11_12;


public class GiamDoc extends NhanVien {
    String tenThuKy;
    double heSoLuong;


    public GiamDoc() {
    }


    public GiamDoc(String ten, String gioiTinh, String tenThuKy, double heSoLuong) {
        super(ten, gioiTinh);
        this.tenThuKy = tenThuKy;
        this.heSoLuong = heSoLuong;
    }


    @Override
    public void xuatThongTin() {
        // 'super': đại diện cho class cha đang kế thừa
        super.xuatThongTin();
        System.out.println("Ten thu ky: " + tenThuKy);
        System.out.println("He so luong: " + heSoLuong);
    }
}
