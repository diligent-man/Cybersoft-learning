package com.ndt.day_11_12;


public class Main {
    public static void playWithBaiViet() {
        BaiViet baiViet1 = new BaiViet();
        baiViet1.tieuDe = "Tieu de 1";
        baiViet1.noiDung = "Noi dung 1";

        BaiViet baiViet2 = new BaiViet();
        baiViet2.tieuDe = "Tieu de 2";
        baiViet2.noiDung = "Noi dung 2";

        System.out.println("Kiemtra " + baiViet1.tieuDe + " -- " + baiViet1.noiDung);
        System.out.println("Kiemtra " + baiViet2.tieuDe + " -- " + baiViet2.noiDung);
    }


    public static void playWithNhanVien() {
        NhanVien nhanVien1 = new NhanVien();
        NhanVien nhanVien2 = new NhanVien();

        nhanVien1.ten = "Nguyen Van A";
        nhanVien1.soDienThoai = "0987654321";
        nhanVien1.diaChi = "Ha Noi";
        nhanVien1.tuoi = 25;
        nhanVien1.gioiTinh = "Nam";

        nhanVien2.ten = "Tran Van B";
        nhanVien2.tuoi = 21;


        System.out.println(nhanVien1);
        System.out.println(nhanVien2);
        System.out.println();

        nhanVien1.xuatThongTin();
        System.out.println();
        nhanVien2.xuatThongTin();
    }


    public static void playWithInheritance() {
        GiamDoc giamDoc = new GiamDoc();

        giamDoc.ten = "Giam Doc A";
        giamDoc.gioiTinh = "Nu";
        giamDoc.heSoLuong = 6;
        giamDoc.tenThuKy = "Thảo đây";
        giamDoc.xuatThongTin();
        System.out.println();

        ChuTich chuTich = new ChuTich();

        chuTich.ten = "Chu Tich A";
        chuTich.gioiTinh = "Nam";
        chuTich.tuoi = 70;
        chuTich.heSoLuong = 10;
        chuTich.tenThuKy = "Thu ky cua chu tich";
        chuTich.coPhan = 50;

        chuTich.xuatThongTin();
    }


    static void main() {
        // playWithBaiViet();
        // playWithNhanVien();
        playWithInheritance();

        /*
            4 tính chất của hướng đối tượng:
                1/ Tính kế thừa:
                    Khi một class con mà kế thừa class cha thì class con sẽ có tất cả các thuộc tính và phương thức của class cha
                2/ Tính đóng gói
                3/ Tính trừ tượng
                4/ Tính đa hình

            Override:
                Hàm trùng tên nhưng khác nhau về số lượng tham số hoặc kiểu dữ liệu
            Override:
                ghi đè phương thức -> Bên class cha có phương thức này nhưng không đáp ứng được logic của class con
                nên cần viết mới lại logic
         */
    }
}
