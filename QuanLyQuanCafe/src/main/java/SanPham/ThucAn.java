/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;

import Main.CauHinh;

/**
 *
 * @author Quang Sang
 */
public class ThucAn extends SanPham {

    public int anChay;

    public ThucAn() {
    }

    public ThucAn(int anChay, String ten, double giaBan, int tinhTrang, String thoiDiemBan, int danhMuc) {
        super(ten, giaBan, tinhTrang, thoiDiemBan, danhMuc);
        this.anChay = anChay;
    }

    @Override
    public void nhapSanPham() {
        super.nhapSanPham();
        System.out.print("Nhap co an chay duoc khong (Co: 1: Khong: 0): ");
        this.anChay = Integer.parseInt(CauHinh.sc.nextLine());
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("%s\n", this.anChay == 1 ? "Co" : "Khong");
    }

    /**
     * @return the anChay
     */
    public int getAnChay() {
        return anChay;
    }

    /**
     * @param anChay the anChay to set
     */
    public void setAnChay(int anChay) {
        this.anChay = anChay;
    }

}
