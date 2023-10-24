/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien;

import Main.CauHinh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Quang Sang
 */
public class QuanLyNhanVien {

    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    //==========================================================================
    //Hiển thị
    public void hienThi() { //xem danh sách nhân viên
        this.danhSachNhanVien.forEach(NhanVien::hienThi);
    }

    //==========================================================================
    //Tra cứu
    public List<NhanVien> traCuuBangTen(String tuKhoa) {  //tra cứu theo tên
        return this.danhSachNhanVien.stream().filter(t -> t.getHoTenNhanVien().contains(tuKhoa)).collect(Collectors.toList());
    }

    public List<NhanVien> traCuuBangGioiTinh(String tuKhoa) { //tra cứu theo giới tính
        return this.danhSachNhanVien.stream().filter(t -> t.getGioiTinhNhanVien().contains(tuKhoa)).collect(Collectors.toList());
    }

    public List<NhanVien> traCuuBangQueQuan(String tuKhoa) { //tra cứu theo quê quán
        return this.danhSachNhanVien.stream().filter(t -> t.getQueQuanNhanvien().contains(tuKhoa)).collect(Collectors.toList());
    }

    public List<NhanVien> traCuuBangNgaySinh(Date tuNgay, Date denNgay) { //tra cứu ngày theo khoảng
        return this.danhSachNhanVien.stream().filter(t -> t.getNgaySinhNhanVien().compareTo(tuNgay) >= 0 && t.getNgaySinhNhanVien().compareTo(denNgay) <= 0).collect(Collectors.toList());
    }

    public List<NhanVien> traCuuSinhNhatNhanVienTheoThang(int thangSinh) {    //tra cứu sinh nhật nhân viên
        List<NhanVien> ketQua = new ArrayList<>();
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getNgaySinhNhanVien().getMonth() == thangSinh) {
                ketQua.add(nv);
            }
        }
        return ketQua;
    }

    //==========================================================================
    //Thêm
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

    public void themNhanVien(String tapTin, int soLuong) throws IOException, ParseException {   //ghi file vào NhanVien.txt, nhập dữ liệu = tay
        File f = new File(tapTin);
        FileWriter w = new FileWriter(f, true);
        try (PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < soLuong; i++) {
                System.out.printf("== Nhap nhan vien thu %d\n", i + 1);
                NhanVien nhanVien = new NhanVien();
                nhanVien.nhapNhanVien();
                writer.println(nhanVien.getHoTenNhanVien());
                writer.println(nhanVien.getGioiTinhNhanVien());
                writer.println(nhanVien.getQueQuanNhanvien());
                writer.println(CauHinh.dinhDanh.format(nhanVien.getNgaySinhNhanVien()));
                writer.println(CauHinh.dinhDanh.format(nhanVien.getNgayVaoLam()));
                writer.println(nhanVien.getBoPhan());
                this.danhSachNhanVien.add(nhanVien);
                System.out.println("");
            }
        }
    }

    //==========================================================================
    //Cập nhật
    public void chinhSuaNhanVien(int ma) throws ParseException {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachNhanVien.size(); i++) {
            if (i == ma) {
                System.out.print("Nhap ho ten: ");
                String name = CauHinh.sc.nextLine();
                System.out.print("Nhap gioi tinh: ");
                String sex = CauHinh.sc.nextLine();
                System.out.print("Nhap que quan: ");
                String quequan = CauHinh.sc.nextLine();
                System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
                Date ngaySinh = CauHinh.dinhDanh.parse(CauHinh.sc.nextLine());
                System.out.print("Nhap ngay vao lam (dd/MM/yyyy): ");
                Date ngayvaolam = CauHinh.dinhDanh.parse(CauHinh.sc.nextLine());
                System.out.print("Nhap bo phan: ");
                String bophan = CauHinh.sc.nextLine();

                this.danhSachNhanVien.get(i).setHoTenNhanVien(name);
                this.danhSachNhanVien.get(i).setGioiTinhNhanVien(sex);
                this.danhSachNhanVien.get(i).setQueQuanNhanvien(quequan);
                this.danhSachNhanVien.get(i).setNgaySinhNhanVien(ngaySinh);
                this.danhSachNhanVien.get(i).setNgayVaoLam(ngayvaolam);
                this.danhSachNhanVien.get(i).setBoPhan(bophan);
                break;
            }
        }
    }

    public void chinhSuaHoTenNhanVien(int ma) {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachNhanVien.size(); i++) {
            if (i == ma) {
                System.out.print("Nhap ho ten: ");
                String name = CauHinh.sc.nextLine();
                this.danhSachNhanVien.get(i).setHoTenNhanVien(name);
                break;
            }
        }
    }

    public void chinhSuaGioiTinhNhanVien(int ma) {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachNhanVien.size(); i++) {
            if (i == ma) {
                System.out.print("Nhap gioi tinh: ");
                String sex = CauHinh.sc.nextLine();

                this.danhSachNhanVien.get(i).setGioiTinhNhanVien(sex);
                break;
            }
        }
    }

    public void chinhSuaQueQuanNhanVien(int ma) {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachNhanVien.size(); i++) {
            if (i == ma) {
                System.out.print("Nhap que quan: ");
                String quequan = CauHinh.sc.nextLine();

                this.danhSachNhanVien.get(i).setQueQuanNhanvien(quequan);
                break;
            }
        }
    }

    public void chinhSuaNgaySinhNhanVien(int ma) throws ParseException {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachNhanVien.size(); i++) {
            if (i == ma) {
                System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
                Date ngaySinh = CauHinh.dinhDanh.parse(CauHinh.sc.nextLine());

                this.danhSachNhanVien.get(i).setNgaySinhNhanVien(ngaySinh);
                break;
            }
        }
    }

    public void chinhSuaNgayVaoLamNhanVien(int ma) throws ParseException {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachNhanVien.size(); i++) {
            if (i == ma) {
                System.out.print("Nhap ngay vao lam (dd/MM/yyyy): ");
                Date ngayvaolam = CauHinh.dinhDanh.parse(CauHinh.sc.nextLine());

                this.danhSachNhanVien.get(i).setNgayVaoLam(ngayvaolam);
                break;
            }
        }
    }

    public void chinhSuaBoPhanNhanVien(int ma) {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachNhanVien.size(); i++) {
            if (i == ma) {
                System.out.print("Nhap bo phan: ");
                String bophan = CauHinh.sc.nextLine();

                this.danhSachNhanVien.get(i).setBoPhan(bophan);
                break;
            }
        }
    }

    //==========================================================================
    //Ghi vào file
    public void ghiNhanVien(String tapTin) throws FileNotFoundException {     //cập nhật vào file txt
        File f = new File(tapTin);
        try (PrintWriter writer = new PrintWriter(f)) {
            for (NhanVien nhanVien : this.danhSachNhanVien) {
                writer.println(nhanVien.getHoTenNhanVien());
                writer.println(nhanVien.getGioiTinhNhanVien());
                writer.println(nhanVien.getQueQuanNhanvien());
                writer.println(CauHinh.dinhDanh.format(nhanVien.getNgaySinhNhanVien()));
                writer.println(CauHinh.dinhDanh.format(nhanVien.getNgayVaoLam()));
                writer.println(nhanVien.getBoPhan());
            }
        }
    }

    //==========================================================================
    //Xóa
    public void xoaNhanVien(int ma) {  //xóa nhân viên
        this.danhSachNhanVien.remove(--ma);
    }
}
