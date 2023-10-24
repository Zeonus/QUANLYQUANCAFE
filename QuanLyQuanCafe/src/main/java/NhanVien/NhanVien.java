/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien;

import Main.CauHinh;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Quang Sang
 */
public class NhanVien {

    public static int demMaNhanVien;

    private int maNhanVien;
    private String hoTenNhanVien;
    private String gioiTinhNhanVien;
    private String queQuanNhanvien;
    private Date ngaySinhNhanVien;
    private Date ngayVaoLam;
    private String boPhan;

    {
        this.setMaNhanVien(++demMaNhanVien);
        this.setNgayVaoLam(new Date());
    }

    public NhanVien() {
    }

    public NhanVien(String hoTenNhanVien, String gioiTinhNhanVien, String queQuanNhanvien, Date ngayVaoLam, String boPhan) {
        this.hoTenNhanVien = hoTenNhanVien;
        this.gioiTinhNhanVien = gioiTinhNhanVien;
        this.queQuanNhanvien = queQuanNhanvien;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhan = boPhan;
    }

    public void nhapNhanVien() throws ParseException {
        System.out.print("Nhap ho ten: ");
        this.hoTenNhanVien = CauHinh.sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        this.gioiTinhNhanVien = (CauHinh.sc.nextLine());
        System.out.print("Nhap que quan: ");
        this.queQuanNhanvien = (CauHinh.sc.nextLine());
        System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
        this.ngaySinhNhanVien = (CauHinh.dinhDanh.parse(CauHinh.sc.nextLine()));
        System.out.print("Nhap ngay vao lam (dd/MM/yyyy): ");
        this.ngayVaoLam = (CauHinh.dinhDanh.parse(CauHinh.sc.nextLine()));
        System.out.print("Nhap bo phan: ");
        this.boPhan = CauHinh.sc.nextLine();
    }

    public void hienThi() {
        System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20s%-20s\n",
                this.getMaNhanVien(), this.getHoTenNhanVien(), this.getGioiTinhNhanVien(), this.getQueQuanNhanvien(),
                CauHinh.dinhDanh.format(this.getNgaySinhNhanVien()), CauHinh.dinhDanh.format(this.getNgayVaoLam()), this.getBoPhan());
    }

    /**
     * @return the maNhanVien
     */
    public int getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    /**
     * @return the hoTenNhanVien
     */
    public String getHoTenNhanVien() {
        return hoTenNhanVien;
    }

    /**
     * @param hoTenNhanVien the hoTenNhanVien to set
     */
    public void setHoTenNhanVien(String hoTenNhanVien) {
        this.hoTenNhanVien = hoTenNhanVien;
    }

    /**
     * @return the gioiTinhNhanVien
     */
    public String getGioiTinhNhanVien() {
        return gioiTinhNhanVien;
    }

    /**
     * @param gioiTinhNhanVien the gioiTinhNhanVien to set
     */
    public void setGioiTinhNhanVien(String gioiTinhNhanVien) {
        this.gioiTinhNhanVien = gioiTinhNhanVien;
    }

    /**
     * @return the queQuanNhanvien
     */
    public String getQueQuanNhanvien() {
        return queQuanNhanvien;
    }

    /**
     * @param queQuanNhanvien the queQuanNhanvien to set
     */
    public void setQueQuanNhanvien(String queQuanNhanvien) {
        this.queQuanNhanvien = queQuanNhanvien;
    }

    /**
     * @return the ngaySinhNhanVien
     */
    public Date getNgaySinhNhanVien() {
        return ngaySinhNhanVien;
    }

    /**
     * @param ngaySinhNhanVien the ngaySinhNhanVien to set
     */
    public void setNgaySinhNhanVien(Date ngaySinhNhanVien) {
        this.ngaySinhNhanVien = ngaySinhNhanVien;
    }

    /**
     * @return the ngayVaoLam
     */
    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    /**
     * @param ngayVaoLam the ngayVaoLam to set
     */
    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * @return the boPhan
     */
    public String getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }
}
