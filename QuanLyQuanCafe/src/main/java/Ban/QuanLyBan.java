/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ban;

import Main.CauHinh;
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
public class QuanLyBan {

    private List<Ban> danhSachBan = new ArrayList<>();

    //==========================================================================
    //Hiển thị
    public void hienThi() {     //xem danh sách bàn trống
        this.danhSachBan.forEach(Ban::hienThi);
    }

    //==========================================================================
    //Thêm
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

    public void themBan(String tapTin, int soLuong) throws IOException {   //ghi file vào BanTrong.txt, nhập dữ liệu = tay
        File f = new File(tapTin);
        FileWriter w = new FileWriter(f, true);
        try (PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < soLuong; i++) {
                System.out.printf("== Nhap ban thu %d\n", i + 1);
                Ban ban = new Ban();
                ban.nhapBan();
                writer.println(ban.getSucChua());
                writer.println(ban.getTinhTrang());
                this.danhSachBan.add(ban);
                System.out.println("");
            }
        }
    }

    //==========================================================================
    //Cập nhật
    public void chinhSuaBan(String ma) {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachBan.size(); i++) {
            if (danhSachBan.get(i).getMaBan().equals(ma)) {
                System.out.print("Nhap suc chua: ");
                int sucChua = Integer.parseInt(CauHinh.sc.nextLine());
                System.out.print("Nhap tinh trang (Trong: 1, Khong: 0): ");
                int tinhTrang = Integer.parseInt(CauHinh.sc.nextLine());

                this.danhSachBan.get(i).setSucChua(sucChua);
                this.danhSachBan.get(i).setTinhTrang(tinhTrang);
                break;
            }
        }
    }

    public void chinhSuaSucChuaBan(String ma) {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachBan.size(); i++) {
            if (danhSachBan.get(i).getMaBan().equals(ma)) {
                System.out.print("Nhap suc chua: ");
                int sucChua = Integer.parseInt(CauHinh.sc.nextLine());

                this.danhSachBan.get(i).setSucChua(sucChua);
                break;
            }
        }
    }

    public void chinhSuaTinhTrangBan(String ma) {    //chỉnh sửa nhập = tay
        for (int i = 0; i < this.danhSachBan.size(); i++) {
            if (danhSachBan.get(i).getMaBan().equals(ma)) {
                System.out.print("Nhap tinh trang (Trong: 1, Khong: 0): ");
                int tinhTrang = Integer.parseInt(CauHinh.sc.nextLine());

                this.danhSachBan.get(i).setTinhTrang(tinhTrang);
                break;
            }
        }
    }

    //==========================================================================
    //Ghi vào file
    public void ghiBan(String tapTin) throws FileNotFoundException {     //cập nhật vào file txt
        File f = new File(tapTin);
        try (PrintWriter writer = new PrintWriter(f)) {
            for (Ban ban : this.danhSachBan) {
                writer.println(ban.getSucChua());
                writer.println(ban.getTinhTrang());
            }
        }
    }

    //==========================================================================
    //Tìm kiếm
    public List<Ban> timKiemBangMa(String ma) {  //tra cứu theo mã bàn
        return this.danhSachBan.stream().filter(h -> h.getMaBan().contains(ma)).collect(Collectors.toList());
    }

    public void timKiemBangSucChua(int sucChua) {   //tra cứu theo sức chứa
        for (Ban ban : this.danhSachBan) {
            if (sucChua == ban.getSucChua()) {
                ban.hienThi();
            }
        }
    }

    //==========================================================================
    //Xóa
    public void xoaBan(int ban) {  //xóa bàn
        this.danhSachBan.remove(--ban);
    }

    public void sapXepTheoSucChua() {      //sắp xếp giảm dần: everseOrder()
        this.danhSachBan.sort(Comparator.comparing(Ban::getSucChua));
    }

    public void sapXepTheoTinhTrang() {      //sắp xếp giảm dần: everseOrder()
        this.danhSachBan.sort(Comparator.comparing(Ban::getTinhTrang, Comparator.reverseOrder()));
    }

}
