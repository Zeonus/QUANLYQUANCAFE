/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Quang Sang
 */
public class QuanLySanPham {
    private List<SanPham> danhSachSanPham = new ArrayList<>();

    //==========================================================================
    //Hiển thị
    public void hienThi() {
        this.danhSachSanPham.forEach(SanPham::hienThi);
    }

    //==========================================================================
    //Thêm
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

    public void themSanPhamThucUong(String tapTin) throws FileNotFoundException {        //đọc file từ ThucUong.txt
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

    public void themSanPhamThucAn(String tapTin, int soLuong) throws IOException {   //ghi file vào ThucAn.txt, nhập dữ liệu = tay
        File f = new File(tapTin);
        FileWriter w = new FileWriter(f, true);
        try (PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < soLuong; i++) {
                System.out.printf("== Nhap san pham thu %d\n", i + 1);
                ThucAn thucAn = new ThucAn();
                thucAn.nhapSanPham();
                writer.println(thucAn.getTen());
                writer.println(thucAn.getGiaBan());
                writer.println(thucAn.getTinhTrang());
                writer.println(thucAn.getThoiDiemBan());
                writer.println(thucAn.getDanhMuc());
                writer.println(thucAn.getAnChay());
                this.danhSachSanPham.add(thucAn);
                System.out.println("");
            }
        }
    }

    public void themSanPhamThucUong(String tapTin, int soLuong) throws IOException {   //ghi file vào ThucUong.txt, nhập dữ liệu = tay
        File f = new File(tapTin);
        FileWriter w = new FileWriter(f, true);
        try (PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < soLuong; i++) {
                System.out.printf("== Nhap san pham thu %d\n", i + 1);
                ThucUong thucUong = new ThucUong();
                thucUong.nhapSanPham();
                writer.println(thucUong.getTen());
                writer.println(thucUong.getGiaBan());
                writer.println(thucUong.getTinhTrang());
                writer.println(thucUong.getThoiDiemBan());
                writer.println(thucUong.getDanhMuc());
                writer.println(thucUong.getNuocDa());
                this.danhSachSanPham.add(thucUong);
                System.out.println("");
            }
        }
    }

    //==========================================================================
    //Ghi vào file
    public void ghiSanPham(String tapTin) throws FileNotFoundException {     //cập nhật vào file txt
        File f = new File(tapTin);
        try (PrintWriter writer = new PrintWriter(f)) {
            for (SanPham sanPham : this.danhSachSanPham) {
                writer.println(sanPham.getTen());
                writer.println(sanPham.getGiaBan());
                writer.println(sanPham.getTinhTrang());
                writer.println(sanPham.getThoiDiemBan());
                writer.println(sanPham.getDanhMuc());
            }
        }
    }

    //==========================================================================
    //Xóa
    public void xoaSanPham(String ten) {
        danhSachSanPham.removeIf(sanPham -> sanPham.getTen().equals(ten));
    }

    //==========================================================================
    //Tìm kiếm
    public List<SanPham> timKiemTheoTen(String tuKhoa) {  //tìm kiếm theo tên
        return this.danhSachSanPham.stream().filter(t -> t.getTen().contains(tuKhoa)).collect(Collectors.toList());
    }

    public List<SanPham> timKiemTheoGia(double tuGia, double denGia) {  //tìm kiếm theo giá
        return this.danhSachSanPham.stream().filter(t -> t.getGiaBan() >= tuGia && t.getGiaBan() <= denGia).collect(Collectors.toList());
    }

    public List<SanPham> timKiemTheoThoiDiemBan(String tuKhoa) {
        return this.danhSachSanPham.stream().filter(t -> t.getThoiDiemBan().contains(tuKhoa)).collect(Collectors.toList());
    }

    public void timKiemTheoTinhTrang(int tuKhoa) {   //tra cứu theo tình trạng
        for (SanPham sanPham : this.danhSachSanPham) {
            if (tuKhoa == sanPham.getTinhTrang()) {
                sanPham.hienThi();
            }
        }
    }

    //==========================================================================
    //Sắp xếp
    public void sapXepTheoGia() {      //sắp xếp giảm dần: everseOrder()
        this.danhSachSanPham.sort(Comparator.comparing(SanPham::getGiaBan, Comparator.reverseOrder()));
    }

    public void sapXepTheoTinhTrang() {      //sắp xếp giảm dần: everseOrder()
        this.danhSachSanPham.sort(Comparator.comparing(SanPham::getTinhTrang, Comparator.reverseOrder()));
    }

    public void sapXepTheoThoiDiemBan() {      //sắp xếp giảm dần: everseOrder()
        this.danhSachSanPham.sort(Comparator.comparing(SanPham::getThoiDiemBan));
    }
}
