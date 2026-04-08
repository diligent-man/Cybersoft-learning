package com.ndt.java_core.day_11_12_13_14;


public class GiamDoc extends NhanVien implements TinhNang, HanhVi {
    String tenThuKy;

    double heSoLuong;


    public GiamDoc() {
    }


    public GiamDoc(String ten, String gioiTinh, String tenThuKy) {
        super(ten, gioiTinh);
        this.tenThuKy = tenThuKy;
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


    @Override
    public void tinhLuong() {
        System.out.println("Tinh luong giam doc");
    }


    @Override
    public void diHop() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
