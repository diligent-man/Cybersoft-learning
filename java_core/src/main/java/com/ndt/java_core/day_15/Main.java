package com.ndt.java_core.day_15;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        TrungTam cybersoft = new TrungTam();

        cybersoft.setTen("CyberSoft");
        cybersoft.setMaSoThue("0999988888");
        cybersoft.setDoanhThuThang(100_000_000);

        cybersoft.HienThiThongTin();

        int chon = 0;
        AtomicInteger counter = new AtomicInteger();
        do {
            System.out.println("""
                Vui long chon chuc nang can thuc hien\
                
                 1) Them sinh vien\
                
                 2) Them Mentor\
                
                 3) Them Giang vien\
                
                 4) Phan bo sinh vien -> giang vien\
                
                 5) Hien Thi Danh Sach\
                
                 6) Tim Kiem\
                
                 7) Xoa\
                
                 8) Tinh diem tb\
                
                 0) Thoat""");
            System.out.println("Chon chuc nang: ");
            chon = sc.nextInt();
            switch (chon) {
                case 0:
                    break;
                case 1: {
                    SinhVien sv = new SinhVien();
                    sv.Nhap();

                    cybersoft.getNguoiDungLst().add(sv);
                    System.out.println("Them thanh cong sinh vien");

                    break;
                }
                case 2:
                    Mentor mentor = new Mentor();
                    mentor.Nhap();

                    cybersoft.getNguoiDungLst().add(mentor);
                    System.out.println("Them thanh cong mentor");
                    break;
                case 3:
                    GiangVien gv = new GiangVien();
                    gv.Nhap();

                    cybersoft.getNguoiDungLst().add(gv);
                    System.out.println("Them thanh cong giang vien");
                    break;
                case 4:
                    System.out.println("Danh sach giang vien:");
                    counter.set(0);
                    cybersoft
                        .getNguoiDungLst()
                        .stream().filter(usr -> usr instanceof GiangVien)
                        .forEach(usr -> System.out.printf("%d/ %s", counter.getAndIncrement(), usr));

                    System.out.println("Hay chon giang vien:");
                    GiangVien selectedGv = (GiangVien) cybersoft.getNguoiDungLst().get(Integer.parseInt(sc.nextLine()) - 1);

                    System.out.println("Danh sach sinh vien:");
                    counter.set(0);
                    cybersoft
                        .getNguoiDungLst()
                        .stream().filter(usr -> !(usr instanceof Mentor))
                        .forEach(usr -> System.out.printf("%d/ %s", counter.getAndIncrement(), usr));

                    System.out.println("Hay chon sinh vien");
                    SinhVien selectedSv = cybersoft.getNguoiDungLst().get(Integer.parseInt(sc.nextLine()) - 1);

                    selectedGv.getSinhVienLst().add(selectedSv);
                    System.out.println("Phan bo giang vien thanh cong");


                    System.out.printf("Ten GV: %s\n", selectedGv);
                    System.out.println("Danh sach sinh vien cua GV:");
                    selectedGv.getSinhVienLst().forEach(usr -> System.out.printf("%s\n", usr));
                    break;
                case 5:
                    System.out.println("Danh sach sinh vien:");
                    counter.set(0);
                    cybersoft.getNguoiDungLst().forEach(usr -> System.out.printf("%d/ %s - %s", counter.getAndIncrement(), usr, usr.getClass().getSimpleName()));
                    break;
                case 6:
                    System.out.println("Nhap ma sinh vien de tim kiem: ");
                    String maSinhVien = sc.nextLine();

                    for (SinhVien sv : cybersoft.getNguoiDungLst()) {
                        if (sv.getMaSV().equals(maSinhVien)) {
                            System.out.printf("Tim thay %s", sv);
                            break;
                        }
                    }

                    System.out.println("Khong tim thay sinh vien");
                    break;
                case 7:
                    System.out.println("Danh sach sinh vien:");
                    counter.set(0);
                    cybersoft.getNguoiDungLst().forEach(usr -> System.out.printf("%d/ %s - %s", counter.getAndIncrement(), usr, usr.getClass().getSimpleName()));

                    System.out.println("Nhap ma sinh vien de xoa: ");
                    String maSinhVienXoa = sc.nextLine();
                    cybersoft.getNguoiDungLst().removeIf(usr -> usr.getMaSV().equals(maSinhVienXoa));
                    break;
                default:
                    System.out.println("chuc nang khong ton tai");
                    break;
            }
        }
        while (chon != 0);
    }
}

