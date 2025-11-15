/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlycuahang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author admin
 */
public class Ket_Noi_DB {
    private static final String URL = "jdbc:mysql://localhost:3306/cua_hang_tien_loi?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root"; // thay bằng username của bạn
    private static final String PASSWORD = "Hoangv1et2"; // thay bằng mật khẩu của bạn

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // nạp driver
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
