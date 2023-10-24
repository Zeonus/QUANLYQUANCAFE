/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien;

import Main.CauHinh;

/**
 *
 * @author Quang Sang
 */
public class BoPhan {

    public static int demMaBoPhan;
    private int maBoPhan = ++demMaBoPhan;
    private String tenBoPhan;

    public BoPhan() {
    }

    public BoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public void nhapBoPhan() {
        System.out.print("Ten bo phan: ");
        this.tenBoPhan = CauHinh.sc.nextLine();
    }

    public void hienThi() {
        System.out.printf("Ma: %d\n", this.maBoPhan);
        System.out.printf("Ten bo phan: %s\n", this.tenBoPhan);
    }

    /**
     * @return the maBoPhan
     */
    public int getMaBoPhan() {
        return maBoPhan;
    }

    /**
     * @param maBoPhan the maBoPhan to set
     */
    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    /**
     * @return the tenBoPhan
     */
    public String getTenBoPhan() {
        return tenBoPhan;
    }

    /**
     * @param tenBoPhan the tenBoPhan to set
     */
    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
}
