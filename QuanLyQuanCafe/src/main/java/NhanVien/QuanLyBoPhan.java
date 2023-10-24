/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Quang Sang
 */
public class QuanLyBoPhan {
    
    private List<BoPhan> danhSachBoPhan = new ArrayList<>();
    
    public void themBoPhan(String tapTin) throws FileNotFoundException {        //đọc file từ BoPhan.txt
        File f = new File(tapTin);
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                BoPhan boPhan = new BoPhan();
                boPhan.setTenBoPhan(sc.nextLine());
                this.danhSachBoPhan.add(boPhan);
            }
        }
    }
    
    public void capNhatBoPhan(String tapTin, int n) throws IOException {   //ghi file vào BoPhan.txt
        File f = new File(tapTin);
        FileWriter w = new FileWriter(f, true);
        try (PrintWriter writer = new PrintWriter(w)) {
            for (int i = 0; i < n; i++) {
                System.out.printf("== Nhap bo phan thu %d\n", i + 1);
                BoPhan boPhan = new BoPhan();
                boPhan.nhapBoPhan();
                writer.println(boPhan.getTenBoPhan());
                this.danhSachBoPhan.add(boPhan);
            }
        }
    }
    
    public void hienThi() {
        this.danhSachBoPhan.forEach(BoPhan::hienThi);   //hiển thị danh sách Bọ Phận
    }

}
