/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import DatBan.QuanLyDatBan;
import NhanVien.QuanLyNhanVien;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Quang Sang
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
        Menu menu = new Menu();
        QuanLyDatBan qLDatBan = new QuanLyDatBan();
        qLDatBan.themNhanVien("src/main/resources/NhanVien.txt");
        qLDatBan.themBan("src/main/resources/BanTrong.txt");
        qLDatBan.themSanPhamThucAn("src/main/resources/ThucAn.txt");
        qLDatBan.themSanPhamThucUong("src/main/resources/ThucUong.txt");
        boolean isDatBan = true;
        do {
            menu.menuDatBan();
            System.out.print("Moi ban chon: ");
            String chon = CauHinh.sc.nextLine();
            System.out.println("");
            switch (chon) {
                case "1" -> {
                    System.out.println(String.format("%-25s%s", "", "===== DANH SACH BAN ====="));
                    System.out.println(String.format("%-20s%-20s%-20s%-20s", "MA", "SUC CHUA", "TINH TRANG", "SO LUONG"));
                    qLDatBan.hienThiBan();
                    System.out.println("");
                }

                case "2" -> {
                    System.out.println(String.format("%-55s%s", "", "===== DANH SACH MON ====="));
                    System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY", "NUOC DA", "SO LUONG"));
                    qLDatBan.hienThiMon();
                    System.out.println("");
                }

                case "3" -> {
                    System.out.println("===== CHON BAN =====");
                    System.out.print("Nhap ma de chon ban: ");
                    String index = CauHinh.sc.nextLine();
                    qLDatBan.soLuongBan(index);

                }

                case "4" -> {
                    System.out.println("===== CHON MON =====");
                    System.out.print("Nhap ten de chon mon: ");
                    String index = CauHinh.sc.nextLine();
                    qLDatBan.soLuongMon(index);
                }

                case "5" -> {
                    System.out.println("===== THANH TOAN HOA DON =====");
                    qLDatBan.hienThiBill();
                }

                case "6" -> {
                    System.out.println("===== SAP XEP BAN =====");
                    System.out.println(String.format("%-20s%-20s%-20s%-20s", "MA", "SUC CHUA", "TINH TRANG", "SO LUONG"));
                    qLDatBan.sapXepTheoSucChua();
                    qLDatBan.hienThiBan();
                    System.out.println("");
                }

                case "7" -> {
                    System.out.println("===== SAP XEP MON =====");
                    System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "TEN", "GIA BAN", "TINH TRANG", "THOI DIEM BAN", "DANH MUC", "AN CHAY", "NUOC DA", "SO LUONG"));
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

}
