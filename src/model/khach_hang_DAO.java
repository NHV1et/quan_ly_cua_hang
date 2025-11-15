package model;

import java.sql.*;
import quanlycuahang.Ket_Noi_DB;

public class khach_hang_DAO {
    public khach_hang timkhach_hangTheoMa(String maKH) {
        Connection conn = Ket_Noi_DB.getConnection();
        String sql = "SELECT * FROM khach_hang WHERE CUSTOMER_ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maKH);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new khach_hang(
                    rs.getString("CUSTOMER_ID"),
                    rs.getString("CUSTOMER_NAME"),
                    rs.getString("CUSTOMER_PHONE"),
                    rs.getString("CUSTOMER_EMAIL"),
                    rs.getInt("POINT")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean themKhachHang(khach_hang kh) {
    Connection conn = Ket_Noi_DB.getConnection(); // hoặc MyConnection nếu bạn đổi tên
    String sql = "INSERT INTO khach_hang (CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_PHONE, CUSTOMER_EMAIL, POINT) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, kh.getCustomerId());
        stmt.setString(2, kh.getCustomerName());
        stmt.setString(3, kh.getCustomerPhone());
        stmt.setString(4, kh.getCustomerEmail());
        stmt.setInt(5, kh.getPoint());
        int rows = stmt.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
