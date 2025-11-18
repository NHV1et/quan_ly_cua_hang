package model;

import java.sql.*;
import quanlycuahang.Ket_Noi_DB;
public class sp_DAO {
    public boolean insertSanPham(SanPham sp) {
        Connection conn = Ket_Noi_DB.getConnection();
        if (conn == null) return false;

        String sql = "INSERT INTO san_pham (PROD_ID, PROD_NAME, PRICE, QUANTITY, EXP_DATE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sp.getProdId());
            ps.setString(2, sp.getProdName());
            ps.setFloat(3, sp.getPrice());
            ps.setInt(4, sp.getQuantity());
            ps.setTimestamp(5, sp.getExpDate());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public SanPham timSanPhamTheoMa(String maSP) {
    Connection conn = Ket_Noi_DB.getConnection();
    String sql = "SELECT PROD_NAME, PRICE, QUANTITY, EXP_DATE, ton_kho FROM san_pham WHERE PROD_ID = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, maSP);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new SanPham(
                maSP,
                rs.getString("PROD_NAME"),
                rs.getFloat("PRICE"),
                rs.getInt("QUANTITY"),
                rs.getTimestamp("EXP_DATE"),
                rs.getInt("ton_kho")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
}
