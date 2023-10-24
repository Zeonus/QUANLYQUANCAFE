/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang Sang
 */
public class QuanLyQuanCafe {

    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.menu();
        } catch (ParseException | IOException ex) {
            Logger.getLogger(QuanLyQuanCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
