/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ban;

import Main.CauHinh;

/**
 *
 * @author Quang Sang
 */
public class Ban {

    public static int demMaBan;
    private String maBan = String.format("B%03d", ++demMaBan);
    private int sucChua;
    private int tinhTrang;

    private int soLuong;

    public Ban() {
    }

    public Ban(int sucChua, int tinhTrang) {
        this.sucChua = sucChua;
        this.tinhTrang = tinhTrang;
    }

    public void nhapBan() {
        System.out.print("Nhap suc chua: ");
        this.sucChua = Integer.parseInt(CauHinh.sc.nextLine());
        System.out.print("Nhap tinh trang (Trong: 1, Khong: 0): ");
        this.setTinhTrang(Integer.parseInt(CauHinh.sc.nextLine()));
    }

    public void hienThi() {
        System.out.printf("%-20s%-20d%-20s\n", this.maBan, this.sucChua, this.getTinhTrang() == 1 ? "Trong" : "Khong");
    }

    public void hienThiBan() {
        System.out.printf("%-20s%-20d%-20s%-20d\n", this.maBan, this.sucChua,
                this.getTinhTrang() == 1 ? "Trong" : "Khong", this.soLuong);
    }

    /**
     * @return the maBan
     */
    public String getMaBan() {
        return maBan;
    }

    /**
     * @param maBan the maBan to set
     */
    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    /**
     * @return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
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
