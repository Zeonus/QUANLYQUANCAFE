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
public abstract class SanPham {

    protected String ten;
    protected double giaBan;
    protected int tinhTrang;
    protected String thoiDiemBan;
    protected int danhMuc;

    protected int soLuong;

    public SanPham() {
    }

    public SanPham(String ten, double giaBan, int tinhTrang, String thoiDiemBan, int danhMuc) {
        this.ten = ten;
        this.giaBan = giaBan;
        this.tinhTrang = tinhTrang;
        this.thoiDiemBan = thoiDiemBan;
        this.danhMuc = danhMuc;
    }

    public void nhapSanPham() {
        System.out.print("Nhap ten san pham: ");
        this.ten = CauHinh.sc.nextLine();
        System.out.print("Nhap gia ban: ");
        this.giaBan = Float.parseFloat(CauHinh.sc.nextLine());
        System.out.print("Nhap tinh trang (Con: 1, Het: 0): ");
        this.tinhTrang = Integer.parseInt(CauHinh.sc.nextLine());
        System.out.print("Nhap thoi diem ban (Sang, Trua, Toi): ");
        this.thoiDiemBan = CauHinh.sc.nextLine();
        System.out.print("Nhap danh muc (Thuc an: 1, Thuc uong: 0): ");
        this.danhMuc = Integer.parseInt(CauHinh.sc.nextLine());
    }

    public void hienThi() {
        System.out.printf("%-20s%,-20.1f%-20s%-20s%-20s",
                this.ten, this.giaBan, this.getTinhTrang() == 1 ? "Con" : "Het", this.thoiDiemBan,
                this.getDanhMuc() == 1 ? "Thuc an" : "Thuc uong");
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the giaBan
     */
    public double getGiaBan() {
        return giaBan;
    }

    /**
     * @param giaBan the giaBan to set
     */
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    /**
     * @return the thoiDiemBan
     */
    public String getThoiDiemBan() {
        return thoiDiemBan;
    }

    /**
     * @param thoiDiemBan the thoiDiemBan to set
     */
    public void setThoiDiemBan(String thoiDiemBan) {
        this.thoiDiemBan = thoiDiemBan;
    }

    /**
     * @return the tinhTrang
     */
    public int getTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang the tinhTrang to set
     */
    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    /**
     * @return the danhMuc
     */
    public int getDanhMuc() {
        return danhMuc;
    }

    /**
     * @param danhMuc the danhMuc to set
     */
    public void setDanhMuc(int danhMuc) {
        this.danhMuc = danhMuc;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
