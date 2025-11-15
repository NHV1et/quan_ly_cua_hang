package model;
import quanlycuahang.Ket_Noi_DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class hoa_don_DAO {
    public boolean insertHoaDon(HoaDon hd) {
        Connection conn = Ket_Noi_DB.getConnection();
        String sql = "INSERT INTO hoa_don (INVOICE_ID, CUSTOMER_ID, EMP_ID, INVOICE_DATE, TOTAL, METHOD) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, hd.getInvoiceId());
            ps.setString(2, hd.getCustomerId());
            ps.setString(3, hd.getEmpId());
            ps.setDate(4, hd.getInvoiceDate());
            ps.setFloat(5, hd.getTotal());
            ps.setString(6, hd.getMethod());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
