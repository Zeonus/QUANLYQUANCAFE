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
public class ThucUong extends SanPham {

    public int nuocDa;

    public ThucUong() {
    }

    public ThucUong(int nuocDa, String ten, double giaBan, int tinhTrang, String thoiDiemBan, int danhMuc) {
        super(ten, giaBan, tinhTrang, thoiDiemBan, danhMuc);
        this.nuocDa = nuocDa;
    }

    @Override
    public void nhapSanPham() {
        super.nhapSanPham();
        System.out.print("Nhap co da hay khong (Co: 1, Khong: 0): ");
        this.nuocDa = Integer.parseInt(CauHinh.sc.nextLine());
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("%s\n", this.nuocDa == 1 ? "Co" : "Khong");
    }

    /**
     * @return the nuocDa
     */
    public int getNuocDa() {
        return nuocDa;
    }

    /**
     * @param nuocDa the nuocDa to set
     */
    public void setNuocDa(int nuocDa) {
        this.nuocDa = nuocDa;
    }

}
