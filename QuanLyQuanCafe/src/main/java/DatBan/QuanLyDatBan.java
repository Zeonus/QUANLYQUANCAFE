/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatBan;

import SanPham.ThucUong;
import SanPham.ThucAn;
import SanPham.SanPham;
import Ban.Ban;
import Main.CauHinh;
import NhanVien.NhanVien;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Quang Sang
 */
public class QuanLyDatBan {

    private static int demMaHoaDon;
    private String maHoaDon = String.format("HD%05d", ++demMaHoaDon);
    private List<NhanVien> danhSachNhanVien = new ArrayList<>();
    private List<Ban> danhSachBan = new ArrayList<>();
    private List<SanPham> danhSachSanPham = new ArrayList<>();

//======================================================================================================================================================
//Chức năng đặt bàn
    public void themBan(String tapTin) throws FileNotFoundException {        //đọc file từ BanTrong.txt
        File f = new File(tapTin);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                Ban ban = new Ban();
                ban.setSucChua(Integer.parseInt(sc.nextLine()));
                ban.setTinhTrang(Integer.parseInt(sc.nextLine()));
                this.danhSachBan.add(ban);
            }
        }
    }

    public void soLuongBan(String ma) {
        for (int i = 0; i < this.danhSachBan.size(); i++) {
            if (this.danhSachBan.get(i).getMaBan().equals(ma)) {
                int soLuong = 1;

                this.danhSachBan.get(i).setSoLuong(soLuong);
                break;
            }
        }
    }

    public void hienThiBan() {
        this.danhSachBan.forEach(Ban::hienThiBan);
    }

    public void sapXepTheoSucChua() {      //sắp xếp giảm dần: everseOrder()
        this.danhSachBan.sort(Comparator.comparing(Ban::getSucChua));
    }

//======================================================================================================================================================
//Chức năng đặt món
    public void themSanPhamThucAn(String tapTin) throws FileNotFoundException {        //đọc file từ ThucAn.txt
        File f = new File(tapTin);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                ThucAn thucAn = new ThucAn();
                thucAn.setTen(sc.nextLine());
                thucAn.setGiaBan(Double.parseDouble(sc.nextLine()));
                thucAn.setTinhTrang(Integer.parseInt(sc.nextLine()));
                thucAn.setThoiDiemBan(sc.nextLine());
                thucAn.setDanhMuc(Integer.parseInt(sc.nextLine()));
                thucAn.setAnChay(Integer.parseInt(sc.nextLine()));
                this.danhSachSanPham.add(thucAn);
            }
        }
    }

    public void themSanPhamThucUong(String tapTin) throws FileNotFoundException {        //đọc file từ ThucAn.txt
        File f = new File(tapTin);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                ThucUong thucUong = new ThucUong();
                thucUong.setTen(sc.nextLine());
                thucUong.setGiaBan(Double.parseDouble(sc.nextLine()));
                thucUong.setTinhTrang(Integer.parseInt(sc.nextLine()));
                thucUong.setThoiDiemBan(sc.nextLine());
                thucUong.setDanhMuc(Integer.parseInt(sc.nextLine()));
                thucUong.setNuocDa(Integer.parseInt(sc.nextLine()));
                this.danhSachSanPham.add(thucUong);
            }
        }
    }

    public void soLuongMon(String ten) {
        for (int i = 0; i < this.danhSachSanPham.size(); i++) {
            if (this.danhSachSanPham.get(i).getTen().equals(ten)) {
                System.out.print("Nhap so luong mon: ");
                int soLuong = Integer.parseInt(CauHinh.sc.nextLine());

                this.danhSachSanPham.get(i).setSoLuong(soLuong);
                break;
            }
        }
    }

    public void hienThiMon() {
        this.danhSachSanPham.forEach(SanPham::hienThi);
        for (SanPham sanPham : this.danhSachSanPham) {
            System.out.printf("%-20d", sanPham.getSoLuong());
        }
    }

    public void sapXepTheoGia() {      //sắp xếp giảm dần: everseOrder()
        this.danhSachSanPham.sort(Comparator.comparing(SanPham::getGiaBan, Comparator.reverseOrder()));
    }

//======================================================================================================================================================
//Chức năng thanh toán hóa đơn
    public void themNhanVien(String tapTin) throws FileNotFoundException, ParseException {        //đọc file từ NhanVien.txt
        File f = new File(tapTin);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setHoTenNhanVien(sc.nextLine());
                nhanVien.setGioiTinhNhanVien(sc.nextLine());
                nhanVien.setQueQuanNhanvien(sc.nextLine());
                nhanVien.setNgaySinhNhanVien(CauHinh.dinhDanh.parse(sc.nextLine()));
                nhanVien.setNgayVaoLam(CauHinh.dinhDanh.parse(sc.nextLine()));
                nhanVien.setBoPhan(sc.nextLine());
                this.danhSachNhanVien.add(nhanVien);
            }
        }
    }

    public void hoaDonNhanVien(int ma) {
        for (NhanVien nhanVien : this.danhSachNhanVien) {
            if (nhanVien.getMaNhanVien() == ma && "Thu ngan".equals(nhanVien.getBoPhan())) {
                System.out.printf("%-40s%s", nhanVien.getHoTenNhanVien(), "|");
            }
        }
    }

    public void hoaDonBan() {    //lấy ra các bàn có số lượng = 1
        for (Ban ban : this.danhSachBan) {
            if (ban.getSoLuong() == 1) {
                System.out.printf("%s%s%s", " ", ban.getMaBan(), "                 |");
            }
        }
    }

    public void hoaDonMon() {    //lấy ra các món có số lượng từ 1 trở lên
        for (SanPham sanPham : this.danhSachSanPham) {
            if (sanPham.getSoLuong() >= 1) {
                System.out.printf("%-4s%-4s%-18s%-14d%,-10.1f%-3s%s\n", "|", "|", sanPham.getTen(), sanPham.getSoLuong(), sanPham.getGiaBan(), "|", "|");
            }
        }
    }

    public String ngayThangNam() {      //lấy ra ngày, tháng, năm
        int a = CauHinh.c.get(Calendar.DAY_OF_MONTH);
        int b = CauHinh.c.get(Calendar.MONTH) + 1;
        int c = CauHinh.c.get(Calendar.YEAR);
        String d = a + "/" + b + "/" + c;
        return d;
    }

    public void thanhToanHoaDon() {
        double tongTien = 0;
        for (SanPham sanPham : this.danhSachSanPham) {
            tongTien += (double) (sanPham.getGiaBan() * sanPham.getSoLuong());
        }
        System.out.printf("%,-13.1f%s\n", tongTien, "|");
    }

    public void hienThiBill() {     //chỉ là hiển thị bill tính tiền, java.time.LocalTime.now() lấy ra giờ, phút, giây, mili giây
        System.out.print("Nhap ma thu ngan: ");
        int ma = Integer.parseInt(CauHinh.sc.nextLine());
        System.out.println("------------------------------------------------------");
        System.out.println("|                   COFFEE OOP JAVA                  |");
        System.out.println("|              Nguyen Kiem, TP. Ho Chi Minh          |");
        System.out.println("|                      0987654321                    |");
        System.out.print("|                   HOA DON BAN");
        hoaDonBan();
        System.out.println("");
        System.out.printf("%s\n", "|  Ma hoa don:                             " + this.maHoaDon + "   |");
        System.out.printf("%s\n", "|  Ngay:              " + java.time.LocalTime.now() + " " + ngayThangNam() + "   |");
        System.out.print("|  Thu ngan: ");
        hoaDonNhanVien(ma);
        System.out.println("");
        System.out.println("|   |---------------------------------------------|  |");
        System.out.println("|   |     TEN          SO LUONG            GIA    |  |");
        hoaDonMon();
        System.out.println("|   |---------------------------------------------|  |");
        System.out.printf("%-2s%-37s", "|  ", "TONG TIEN:");
        thanhToanHoaDon();
        System.out.println("|                                                    |");
        System.out.println("|           Cam On Quy Khach - Hen Gap Lai!          |");
        System.out.println("------------------------------------------------------");
        System.out.println("");
    }
}
