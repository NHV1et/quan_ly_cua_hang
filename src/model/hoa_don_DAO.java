package model;
import quanlycuahang.Ket_Noi_DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class hoa_don_DAO {
    public boolean insertHoaDon(HoaDon hd) {
    String sql = "INSERT INTO hoa_don (INVOICE_ID, CUSTOMER_ID, EMP_ID, INVOICE_DATE, TOTAL, METHOD) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = Ket_Noi_DB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // đảm bảo autocommit bật nếu bạn không quản lý transaction thủ công
        if (!conn.getAutoCommit()) conn.setAutoCommit(true);

        ps.setString(1, hd.getInvoiceId());
        ps.setString(2, hd.getCustomerId());
        ps.setString(3, hd.getEmpId());
        ps.setDate(4, hd.getInvoiceDate());
        ps.setFloat(5, hd.getTotal());
        ps.setString(6, hd.getMethod());

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace(); // quan trọng: in lỗi để biết nguyên nhân
        return false;
    }
}
}
