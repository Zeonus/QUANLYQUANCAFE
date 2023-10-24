/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import DatBan.QuanLyDatBan;
import SanPham.QuanLySanPham;
import SanPham.SanPham;
import NhanVien.NhanVien;
import NhanVien.QuanLyNhanVien;
import Ban.QuanLyBan;
import Ban.Ban;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Quang Sang
 */
public class Menu {

//============================= Menu chính (Cao nhất - ông)
    public void menu() throws ParseException, IOException {
        boolean isMenu = true;
        do {
            menuChung();
            System.out.print("Moi ban chon: ");
            String chon = CauHinh.sc.nextLine();
            System.out.println("");
            switch (chon) {
                case "1" -> {
                    menuQuanLyNhanVien();
                }
                case "2" -> {
                    menuQuanLyBan();
                }
                case "3" -> {
                    menuQuanLySanPham();
                }
                case "4" -> {
                    menuQuanLyDatBan();
                }
                case "5" -> {
                    menuThongKeDoanhThu();
                }
                case "0" -> {
                    System.out.println("Chao Tam Biet!!!");
                    isMenu = false;
                }
                default -> {
                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                }
            }
        } while (isMenu == true);
    }

//===============================================================================================================================================================================================
//===============================================================================================================================================================================================
//============================= Menu cha: Giữa
//Chức năng 1: Quản lý nhân viên  
    public void menuQuanLyNhanVien() throws FileNotFoundException, ParseException, IOException {
        QuanLyNhanVien qLNhanVien = new QuanLyNhanVien();
        qLNhanVien.themNhanVien("src/main/resources/NhanVien.txt");
        boolean isNhanVien = true;
        do {
            menuNhanVien();
            System.out.print("Moi ban chon: ");
            String chon = CauHinh.sc.nextLine();
            System.out.println("");
            switch (chon) {
                case "1" -> {
                    System.out.printf("%-55s%s\n", "", "===== DANH SACH NHAN VIEN =====");
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "MA", "HO TEN", "GIOI TINH", "QUE QUAN", "NGAY SINH", "NGAY VAO LAM", "BO PHAN");
                    qLNhanVien.hienThi();
                    System.out.println("");
                }
                case "2" -> {
                    System.out.println("===== THEM NHAN VIEN =====");
                    System.out.print("Nhap so luong nhan vien: ");
                    int index = Integer.parseInt(CauHinh.sc.nextLine());
                    if (index <= 0) {
                        System.out.println("Loi!!! Moi Ban Nhap Lai");
                        System.out.println("");
                    } else {
                        qLNhanVien.themNhanVien("src/main/resources/NhanVien.txt", index);
                        System.out.println("Da Them Thanh Cong");
                        System.out.println("");
                    }
                }
                case "3" -> {
                    boolean isNV = true;
                    do {
                        menuCapNhatNhanVien();
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.println("===== CAP NHAT TAT CA =====");
                                System.out.print("Nhap ma nhan vien: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLNhanVien.chinhSuaNhanVien(index - 1);
                                    qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                                    System.out.println("Da Cap Nhat Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "2" -> {
                                System.out.println("===== CAP NHAT HO TEN =====");
                                System.out.print("Nhap ma nhan vien: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLNhanVien.chinhSuaHoTenNhanVien(index - 1);
                                    qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                                    System.out.println("Da Cap Nhat Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "3" -> {
                                System.out.println("===== CAP NHAT GIOI TINH =====");
                                System.out.print("Nhap ma nhan vien: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLNhanVien.chinhSuaGioiTinhNhanVien(index - 1);
                                    qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                                    System.out.println("Da Cap Nhat Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "4" -> {
                                System.out.println("===== CAP NHAT QUE QUAN =====");
                                System.out.print("Nhap ma nhan vien: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLNhanVien.chinhSuaQueQuanNhanVien(index - 1);
                                    qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                                    System.out.println("Da Cap Nhat Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "5" -> {
                                System.out.println("===== CAP NHAT NGAY SINH =====");
                                System.out.print("Nhap ma nhan vien: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLNhanVien.chinhSuaNgaySinhNhanVien(index - 1);
                                    qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                                    System.out.println("Da Cap Nhat Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "6" -> {
                                System.out.println("===== CAP NHAT NGAY VAO LAM =====");
                                System.out.print("Nhap ma nhan vien: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLNhanVien.chinhSuaNgayVaoLamNhanVien(index - 1);
                                    qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                                    System.out.println("Da Cap Nhat Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "7" -> {
                                System.out.println("===== CAP NHAT BO PHAN =====");
                                System.out.print("Nhap ma nhan vien: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLNhanVien.chinhSuaBoPhanNhanVien(index - 1);
                                    qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                                    System.out.println("Da Cap Nhat Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "0" ->
                                isNV = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }
                    } while (isNV == true);
                }
                case "4" -> {
                    System.out.println("===== XOA NHAN VIEN =====");
                    System.out.print("Nhap ma nhan vien: ");
                    int index = Integer.parseInt(CauHinh.sc.nextLine());
                    if (index <= 0) {
                        System.out.println("Loi!!! Moi Ban Nhap Lai");
                        System.out.println("");
                    } else {
                        qLNhanVien.xoaNhanVien(index);
                        qLNhanVien.ghiNhanVien("src/main/resources/NhanVien.txt");
                        System.out.println("Da Xoa Thanh Cong");
                        System.out.println("");
                    }
                }
                case "5" -> {
                    boolean isNV = true;
                    do {
                        menuTraCuuNhanVien();
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.print("Nhap ho ten can tra cuu: ");
                                String tuKhoa = CauHinh.sc.nextLine();
                                if (!"".equals(tuKhoa)) {
                                    List<NhanVien> ketQua = qLNhanVien.traCuuBangTen(tuKhoa);
                                    System.out.printf("%-55s%s\n", "", "===== TRA CUU THEO HO TEN =====");
                                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "MA", "HO TEN", "GIOI TINH", "QUE QUAN", "NGAY SINH", "NGAY VAO LAM", "BO PHAN");

                                    for (NhanVien nhanVien : ketQua) {
                                        nhanVien.hienThi();
                                    }
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "2" -> {
                                System.out.print("Nhap gioi tinh can tra cuu: ");
                                String tuKhoa = CauHinh.sc.nextLine();
                                if (!"".equals(tuKhoa)) {
                                    List<NhanVien> ketQua = qLNhanVien.traCuuBangGioiTinh(tuKhoa);
                                    System.out.printf("%-55s%s\n", "", "===== TRA CUU THEO GIOI TINH =====");
                                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "MA", "HO TEN", "GIOI TINH", "QUE QUAN", "NGAY SINH", "NGAY VAO LAM", "BO PHAN");

                                    for (NhanVien nhanVien : ketQua) {
                                        nhanVien.hienThi();
                                    }
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "3" -> {
                                System.out.print("Nhap tu ngay (dd/MM/yyyy): ");
                                Date tuNgay = CauHinh.dinhDanh.parse(CauHinh.sc.nextLine());
                                System.out.print("Nhap den ngay (dd/MM/yyyy): ");
                                Date denNgay = CauHinh.dinhDanh.parse(CauHinh.sc.nextLine());
                                List<NhanVien> ketQua = qLNhanVien.traCuuBangNgaySinh(tuNgay, denNgay);
                                System.out.printf("%-55s%s\n", "", "===== TRA CUU THEO NGAY SINH =====");
                                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "MA", "HO TEN", "GIOI TINH", "QUE QUAN", "NGAY SINH", "NGAY VAO LAM", "BO PHAN");
                                for (NhanVien nhanVien : ketQua) {
                                    nhanVien.hienThi();
                                }
                            }
                            case "4" -> {
                                System.out.print("Nhap que quan can tra cuu: ");
                                String tuKhoa = CauHinh.sc.nextLine();
                                if (!"".equals(tuKhoa)) {
                                    List<NhanVien> ketQua = qLNhanVien.traCuuBangQueQuan(tuKhoa);
                                    System.out.printf("%-55s%s\n", "", "===== TRA CUU THEO QUE QUAN =====");
                                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "MA", "HO TEN", "GIOI TINH", "QUE QUAN", "NGAY SINH", "NGAY VAO LAM", "BO PHAN");
                                    for (NhanVien nhanVien : ketQua) {
                                        nhanVien.hienThi();
                                    }
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "0" ->
                                isNV = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }
                    } while (isNV == true);
                }
                case "6" -> {
                    System.out.printf("%-55s%s\n", "", "===== SINH NHAT NHAN VIEN TRONG THANG =====");
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "MA", "HO TEN", "GIOI TINH", "QUE QUAN", "NGAY SINH", "NGAY VAO LAM", "BO PHAN");
                    List<NhanVien> ketQua = qLNhanVien.traCuuSinhNhatNhanVienTheoThang(CauHinh.c.get(Calendar.MONTH));
                    for (NhanVien nhanVien : ketQua) {
                        nhanVien.hienThi();
                    }
                }
                case "0" ->
                    isNhanVien = false;
                default ->
                    System.out.println("Loi!!! Moi Ban Nhap Lai");
            }
        } while (isNhanVien == true);
    }

//Chức năng 2: Quản lý bàn
    public void menuQuanLyBan() throws FileNotFoundException, IOException, ParseException {
        QuanLyBan qLBan = new QuanLyBan();
        qLBan.themBan("src/main/resources/BanTrong.txt");
        boolean isBan = true;
        do {
            menuBan();
            System.out.print("Moi ban chon: ");
            String chon = CauHinh.sc.nextLine();
            System.out.println("");
            switch (chon) {
                case "1" -> {
                    System.out.printf("%-11s%s\n", "", "===== DANH SACH BAN =====");
                    System.out.printf("%-20s%-20s%-20s\n", "MA", "SUC CHUA", "TINH TRANG");
                    qLBan.hienThi();
                    System.out.println("");
                }
                case "2" -> {
                    System.out.println("===== THEM BAN =====");
                    System.out.print("Nhap so luong ban: ");
                    int index = Integer.parseInt(CauHinh.sc.nextLine());
                    if (index <= 0) {
                        System.out.println("Loi!!! Moi Ban Nhap Lai");
                        System.out.println("");
                    } else {
                        qLBan.themBan("src/main/resources/BanTrong.txt", index);
                        System.out.println("Da Them Thanh Cong");
                        System.out.println("");
                    }
                }
                case "3" -> {
                    boolean isB = true;
                    do {
                        System.out.println("*= = = = = CAP NHAT BAN = = = = =*");
                        System.out.println("[   1. Cap Nhat Tat Ca           ]");
                        System.out.println("[   2. Cap Nhat Suc Chua         ]");
                        System.out.println("[   3. Cap Nhat Tinh Tran        ]");
                        System.out.println("[   0. Thoat                     ]");
                        System.out.println("*= = = = = = = = = = = = = = = = *");
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.println("===== CAP NHAT TAT CA =====");
                                System.out.print("Nhap ma ban: ");
                                String index = CauHinh.sc.nextLine();
                                if (!"".equals(index)) {
                                    qLBan.chinhSuaBan(index);
                                    qLBan.ghiBan("src/main/resources/BanTrong.txt");
                                    System.out.println("Thanh Cong");
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "2" -> {
                                System.out.println("===== CAP NHAT SUC CHUA =====");
                                System.out.print("Nhap ma ban: ");
                                String index = CauHinh.sc.nextLine();
                                if (!"".equals(index)) {
                                    qLBan.chinhSuaSucChuaBan(index);
                                    qLBan.ghiBan("src/main/resources/BanTrong.txt");
                                    System.out.println("Thanh Cong");
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "3" -> {
                                System.out.println("===== CAP NHAT TINH TRANG =====");
                                System.out.print("Nhap ma ban: ");
                                String index = CauHinh.sc.nextLine();
                                if (!"".equals(index)) {
                                    qLBan.chinhSuaTinhTrangBan(index);
                                    qLBan.ghiBan("src/main/resources/BanTrong.txt");
                                    System.out.println("Thanh Cong");
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "0" ->
                                isB = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }

                    } while (isB == true);
                }
                case "4" -> {
                    System.out.println("===== XOA BAN =====");
                    System.out.print("Nhap ma ban: ");
                    int index = Integer.parseInt(CauHinh.sc.nextLine());
                    if (index <= 0) {
                        System.out.println("Loi!!! Moi Ban Nhap Lai");
                        System.out.println("");
                    } else {
                        qLBan.xoaBan(index);
                        qLBan.ghiBan("src/main/resources/BanTrong.txt");
                        System.out.println("Da Xoa Thanh Cong");
                        System.out.println("");
                    }
                }
                case "5" -> {
                    boolean isB = true;
                    do {
                        System.out.println("*= = = = = TIM KIEM BAN = = = = =*");
                        System.out.println("[   1. Theo Ma Ban               ]");
                        System.out.println("[   2. Theo Suc Chua             ]");
                        System.out.println("[   0. Thoat                     ]");
                        System.out.println("*= = = = = = = = = = = = = = = = *");
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.print("Nhap ma ban can tim: ");
                                String index = CauHinh.sc.nextLine();
                                if (!"".equals(index)) {
                                    System.out.printf("%-11s%s\n", "", "===== TIM KIEM THEO MA BAN =====");
                                    System.out.printf("%-20s%-20s%-20s\n", "MA", "SUC CHUA", "TINH TRANG");
                                    List<Ban> ketQua = qLBan.timKiemBangMa(index);
                                    for (Ban ban : ketQua) {
                                        ban.hienThi();
                                    }
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "2" -> {
                                System.out.print("Nhap so luong nguoi di: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                System.out.printf("%-11s%s\n", "", "===== TIM KIEM THEO SUC CHUA =====");
                                System.out.printf("%-20s%-20s%-20s\n", "MA", "SUC CHUA", "TINH TRANG");
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLBan.timKiemBangSucChua(index);
                                    System.out.println("");
                                }
                            }
                            case "0" ->
                                isB = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }

                    } while (isB == true);
                }
                case "6" -> {
                    boolean isB = true;
                    do {
                        System.out.println("*========= SAP XEP BAN =========*");
                        System.out.println("|   1. Theo Suc Chua            |");
                        System.out.println("|   2. Theo Tinh Trang          |");
                        System.out.println("*===============================*");
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.printf("%-11s%s\n", "", "===== SAP XEP THEO SUC CHUA =====");
                                System.out.printf("%-20s%-20s%-20s\n", "MA", "SUC CHUA", "TINH TRANG");
                                qLBan.sapXepTheoSucChua();
                                qLBan.hienThi();
                            }

                            case "2" -> {
                                System.out.println(String.format("%-11s%s\n", "", "===== SAP XEP THEO TINH TRANG ====="));
                                System.out.println(String.format("%-20s%-20s%-20s", "MA", "SUC CHUA", "TINH TRANG"));
                                qLBan.sapXepTheoTinhTrang();
                                qLBan.hienThi();
                            }

                            case "0" ->
                                isB = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }
                    } while (isB == true);
                }
                case "0" ->
                    isBan = false;
                default ->
                    System.out.println(
                            "Loi!!! Moi ban nhap lai");
            }
        } while (isBan == true);
    }

//Chức năng 3: Quản lý sản phẩm
    public void menuQuanLySanPham() throws FileNotFoundException, IOException {
        QuanLySanPham qLSanPham = new QuanLySanPham();
        qLSanPham.themSanPhamThucAn("src/main/resources/ThucAn.txt");
        qLSanPham.themSanPhamThucUong("src/main/resources/ThucUong.txt");
        boolean isSanPham = true;
        do {
            menuSanPham();
            System.out.print("Moi ban chon: ");
            String chon = CauHinh.sc.nextLine();
            System.out.println("");
            switch (chon) {
                case "1" -> {
                    System.out.printf("%-45s%s\n", "", "===== DANH SACH SAN PHAM =====");
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                    qLSanPham.hienThi();
                    System.out.println("");
                }
                case "2" -> {
                    boolean isSP = true;
                    do {
                        menuThemSanPham();
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.println("===== THEM THUC AN =====");
                                System.out.print("Nhap so luong: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLSanPham.themSanPhamThucAn("src/main/resources/ThucAn.txt", index);
                                    System.out.println("Da Them Thuc An Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "2" -> {
                                System.out.println("===== THEM THUC UONG =====");
                                System.out.print("Nhap so luong: ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLSanPham.themSanPhamThucUong("src/main/resources/ThucUong.txt", index);
                                    System.out.println("Da Them Thuc Uong Thanh Cong");
                                    System.out.println("");
                                }
                            }
                            case "0" ->
                                isSP = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }
                    } while (isSP == true);
                }
                case "3" -> {
                    System.out.println("===== XOA SAN PHAM =====");
                    System.out.print("Nhap ten san pham: ");
                    String index = CauHinh.sc.nextLine();
                    if (!"".equals(index)) {
                        qLSanPham.xoaSanPham(index);
                        qLSanPham.ghiSanPham("src/main/resources/SanPhamSauChinhSua.txt");
                        System.out.println("Thanh Cong");
                        System.out.println("");
                    } else {
                        System.out.println("That Bai");
                        System.out.println("");
                    }
                }
                case "4" -> {
                    boolean isSP1 = true;
                    do {
                        menuTimKiemSanPham();
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.print("Nhap ten: ");
                                String tuKhoa = CauHinh.sc.nextLine();
                                if (!"".equals(tuKhoa)) {
                                    List<SanPham> ketQua = qLSanPham.timKiemTheoTen(tuKhoa);
                                    System.out.printf("%-45s%s\n", "", "===== TIM KIEM THEO TEN =====");
                                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                                    for (SanPham sanPham : ketQua) {
                                        sanPham.hienThi();
                                    }
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "2" -> {
                                System.out.print("Nhap tu gia: ");
                                double tuGia = Double.parseDouble(CauHinh.sc.nextLine());
                                System.out.print("Nhap den gia: ");
                                double denGia = Double.parseDouble(CauHinh.sc.nextLine());
                                List<SanPham> ketQua = qLSanPham.timKiemTheoGia(tuGia, denGia);
                                System.out.printf("%-45s%s\n", "", "===== TIM KIEM THEO GIA =====");
                                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                                for (SanPham sanPham : ketQua) {
                                    sanPham.hienThi();
                                }
                            }

                            case "3" -> {
                                System.out.print("Nhap tinh trang (Con: 1, Het: 0): ");
                                int index = Integer.parseInt(CauHinh.sc.nextLine());
                                System.out.printf("%-45s%s\n", "", "===== TIM KIEM THEO TINH TRANG =====");
                                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                                if (index <= 0) {
                                    System.out.println("Loi!!! Moi Ban Nhap Lai");
                                    System.out.println("");
                                } else {
                                    qLSanPham.timKiemTheoTinhTrang(index);
                                    System.out.println("");
                                }
                            }
                            case "4" -> {
                                System.out.print("Nhap thoi diem ban (Sang, Trua, Toi): ");
                                String tuKhoa = CauHinh.sc.nextLine();
                                if (!"".equals(tuKhoa)) {
                                    List<SanPham> ketQua = qLSanPham.timKiemTheoThoiDiemBan(tuKhoa);
                                    System.out.printf("%-45s%s\n", "", "===== TIM KIEM THEO THOI DIEM BAN =====");
                                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                                    for (SanPham sanPham : ketQua) {
                                        sanPham.hienThi();
                                    }
                                    System.out.println("");
                                } else {
                                    System.out.println("That Bai");
                                    System.out.println("");
                                }
                            }
                            case "0" ->
                                isSP1 = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }
                    } while (isSP1 == true);
                }

                case "5" -> {
                    boolean isSP = true;
                    do {
                        menuSapXepSanPham();
                        System.out.print("Moi ban chon: ");
                        String choice = CauHinh.sc.nextLine();
                        System.out.println("");
                        switch (choice) {
                            case "1" -> {
                                System.out.printf("%-45s%s\n", "", "===== SAP XEP THEO GIA BAN =====");
                                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                                qLSanPham.sapXepTheoGia();
                                qLSanPham.hienThi();
                            }
                            case "2" -> {
                                System.out.printf("%-45s%s\n", "", "===== SAP XEP THEO TINH TRANG =====");
                                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                                qLSanPham.sapXepTheoTinhTrang();
                                qLSanPham.hienThi();
                            }
                            case "3" -> {
                                System.out.printf("%-45s%s\n", "", "===== SAP XEP THEO THOI GIAN BAN =====");
                                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA");
                                qLSanPham.sapXepTheoThoiDiemBan();
                                qLSanPham.hienThi();
                            }
                            case "0" ->
                                isSP = false;
                            default ->
                                System.out.println("Loi!!! Moi Ban Nhap Lai");
                        }
                    } while (isSP == true);
                }
                case "0" ->
                    isSanPham = false;
                default ->
                    System.out.println("Loi!!! Moi ban nhap lai");
            }
        } while (isSanPham == true);
    }

//Chức năng 4: Đặt bàn
    public void menuQuanLyDatBan() throws FileNotFoundException, ParseException {
        QuanLyDatBan qLDatBan = new QuanLyDatBan();
        qLDatBan.themNhanVien("src/main/resources/NhanVien.txt");
        qLDatBan.themBan("src/main/resources/BanTrong.txt");
        qLDatBan.themSanPhamThucAn("src/main/resources/ThucAn.txt");
        qLDatBan.themSanPhamThucUong("src/main/resources/ThucUong.txt");
        boolean isDatBan = true;
        do {
            menuDatBan();
            System.out.print("Moi ban chon: ");
            String chon = CauHinh.sc.nextLine();
            System.out.println("");
            switch (chon) {
                case "1" -> {
                    System.out.printf("%-25s%s\n", "", "===== DANH SACH BAN =====");
                    System.out.printf("%-20s%-20s%-20s%-20s\n", "MA", "SUC CHUA", "TINH TRANG", "SO LUONG");
                    qLDatBan.hienThiBan();
                    System.out.println("");
                }

                case "2" -> {
                    System.out.printf("%-55s%s\n", "", "===== DANH SACH MON =====");
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA", "SO LUONG");
                    qLDatBan.hienThiMon();
                    System.out.println("");
                }

                case "3" -> {
                    System.out.println("===== CHON BAN =====");
                    System.out.print("Nhap ma de chon ban: ");
                    String index = CauHinh.sc.nextLine();
                    if (!"".equals(index)) {
                        qLDatBan.soLuongBan(index);
                        System.out.println("Thanh Cong");
                        System.out.println("");
                    } else {
                        System.out.println("That Bai");
                        System.out.println("");
                    }
                }

                case "4" -> {
                    System.out.println("===== CHON MON =====");
                    System.out.print("Nhap ten de chon mon: ");
                    String index = CauHinh.sc.nextLine();
                    if (!"".equals(index)) {
                        qLDatBan.soLuongMon(index);
                        System.out.println("Thanh Cong");
                        System.out.println("");
                    } else {
                        System.out.println("That Bai");
                        System.out.println("");
                    }
                }

                case "5" -> {
                    System.out.println("===== THANH TOAN HOA DON =====");
                    qLDatBan.hienThiBill();
                }

                case "6" -> {
                    System.out.println("===== SAP XEP BAN =====");
                    System.out.printf("%-20s%-20s%-20s%-20s\n", "MA", "SUC CHUA", "TINH TRANG", "SO LUONG");
                    qLDatBan.sapXepTheoSucChua();
                    qLDatBan.hienThiBan();
                    System.out.println("");
                }

                case "7" -> {
                    System.out.println("===== SAP XEP MON =====");
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY/NUOC DA", "SO LUONG");
                    qLDatBan.sapXepTheoGia();
                    qLDatBan.hienThiMon();
                    System.out.println("");
                }
                case "0" ->
                    isDatBan = false;
                default ->
                    System.out.println("Loi!!! Moi ban nhap lai");
            }
        } while (isDatBan == true);
    }
//Chức năng 5: Thống kê doanh thu theo tháng hoặc thời gian chỉ định
//===============================================================================================================================================================================================    
//===============================================================================================================================================================================================
//============================= Menu con: thấp nhất

    public void menuChung() {
        System.out.println("@=====================================@");
        System.out.println("@          QUAN LY QUAN CAFE          @");
        System.out.println("@=====================================@");
        System.out.println("@   1. Quan Ly Nhan Vien              @");
        System.out.println("@   2. Quan Ly Ban                    @");
        System.out.println("@   3. Quan Ly San Pham               @");
        System.out.println("@   4. Dat Ban                        @");
        System.out.println("@   5. Thong Ke Doanh Thu             @");
        System.out.println("@   0. Thoat Chuong Trinh             @");
        System.out.println("@=====================================@");
    }
//Menu của chức năng 1

    public void menuNhanVien() {
        System.out.println("*========= QUAN LY NHAN VIEN =========*");
        System.out.println("|   1. Danh Sach Nhan Vien            |");
        System.out.println("|   2. Them Nhan Vien                 |");
        System.out.println("|   3. Cap Nhat Nhan Vien             |");
        System.out.println("|   4. Xoa Nhan Vien                  |");
        System.out.println("|   5. Tra Cuu Nhan Vien              |");
        System.out.println("|   6. Sinh Nhat Nhan Vien Trong Thang|");
        System.out.println("|   0. Thoat                          |");
        System.out.println("*=====================================*");
    }

    public void menuCapNhatNhanVien() {
        System.out.println("*= = = = = CAP NHAT NHAN VIEN = = = = =*");
        System.out.println("[   1. Cap Nhat Tat Ca                 ]");
        System.out.println("[   2. Cap Nhat Ho Ten                 ]");
        System.out.println("[   3. Cap Nhat Gioi Tinh              ]");
        System.out.println("[   4. Cap Nhat Que Quan               ]");
        System.out.println("[   5. Cap Nhat Ngay Sinh              ]");
        System.out.println("[   6. Cap Nhat Ngay Vao Lam           ]");
        System.out.println("[   7. Cap Nhat Bo Phan                ]");
        System.out.println("[   0. Thoat                           ]");
        System.out.println("*= = = = = = = = = = = = = = = = = = = *");
    }

    public void menuTraCuuNhanVien() {
        System.out.println("*= = = = = TRA CUU NHAN VIEN = = = = =*");
        System.out.println("[   1. Tra Cuu Theo Ho Ten            ]");
        System.out.println("[   2. Tra Cuu Theo Gioi Tinh         ]");
        System.out.println("[   3. Tra Cuu Theo Ngay Sinh         ]");
        System.out.println("[   4. Tra Cuu Theo Que Quan          ]");
        System.out.println("[   0. Thoat                          ]");
        System.out.println("*= = = = = = = = = = = = = = = = = = =*");
    }

//Menu của chức năng 2
    public void menuBan() {
        System.out.println("*========= QUAN LY BAN =========*");
        System.out.println("|   1. Danh Sach Ban            |");
        System.out.println("|   2. Them Ban                 |");
        System.out.println("|   3. Cap Nhat Ban             |");
        System.out.println("|   4. Xoa Ban                  |");
        System.out.println("|   5. Tim Kiem Ban             |");
        System.out.println("|   6. Sap Xep Ban              |");
        System.out.println("|   0. Thoat                    |");
        System.out.println("*===============================*");
    }

//Menu của chức năng 3
    public void menuSanPham() {
        System.out.println("*========= QUAN LY SAN PHAM =========*");
        System.out.println("|   1. Danh Sach San Pham            |");
        System.out.println("|   2. Them San Pham                 |");
        System.out.println("|   3. Xoa San Pham                  |");
        System.out.println("|   4. Tim Kiem San Pham             |");
        System.out.println("|   5. Sap Xep San Pham              |");
        System.out.println("|   0. Thoat                         |");
        System.out.println("*====================================*");
    }

    public void menuThemSanPham() {
        System.out.println("*= = = = = THEM SAN PHAM = = = = =*");
        System.out.println("[   1. Them Thuc An               ]");
        System.out.println("[   2. Them Thuc Uong             ]");
        System.out.println("[   0. Thoat                      ]");
        System.out.println("*= = = = = = = = = = = = = = = = =*");
    }

    public void menuTimKiemSanPham() {
        System.out.println("*= = = = = TIM KIEM SAN PHAM = = = = =*");
        System.out.println("[   1. Tim Kiem Theo Ten              ]");
        System.out.println("[   2. Tim Kiem Theo Gia              ]");
        System.out.println("[   3. Tim Kiem Theo Tinh Trang       ]");
        System.out.println("[   4. Tim Kiem Theo Thoi Diem Ban    ]");
        System.out.println("[   0. Thoat                          ]");
        System.out.println("*= = = = = = = = = = = = = = = = = = =*");
    }

    public void menuSapXepSanPham() {
        System.out.println("*= = = = = SAP XEP SAN PHAM = = = = =*");
        System.out.println("[   1. Theo Gia Ban                  ]");
        System.out.println("[   2. Theo Tinh Trang               ]");
        System.out.println("[   3. Theo Thoi Gian Ban            ]");
        System.out.println("[   0. Thoat                         ]");
        System.out.println("*= = = = = = = = = = = = = = = = = = *");
    }

//Menu của chức năng 4
    public void menuDatBan() {
        System.out.println("*========= DAT BAN =========*");
        System.out.println("|   1. Xem Ban              |");
        System.out.println("|   2. Xem Mon              |");
        System.out.println("|   3. Chon Ban             |");
        System.out.println("|   4. Chon Mon             |");
        System.out.println("|   5. Thanh Toan Hoa Don   |");
        System.out.println("|   6. Sap Xep Ban          |");
        System.out.println("|   7. Sap Xep Mon          |");
        System.out.println("|   0. Thoat                |");
        System.out.println("*===========================*");
    }

    public void menuThongKeDoanhThu() {
        System.out.println("===== THONG KE DOANH THU =====");
    }
}
