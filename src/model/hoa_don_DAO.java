package model;

import quanlycuahang.Ket_Noi_DB;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class hoa_don_DAO {

    public boolean insertHoaDon(HoaDon hd) {
        String sql = "INSERT INTO hoa_don (INVOICE_ID, CUSTOMER_ID, EMP_ID, INVOICE_DATE, TOTAL, METHOD) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Ket_Noi_DB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            // đảm bảo autocommit bật nếu bạn không quản lý transaction thủ công
            if (!conn.getAutoCommit()) {
                conn.setAutoCommit(true);
            }

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

    public ArrayList<HoaDon> tim_hoadon(String ma_kh) {
        Connection conn = Ket_Noi_DB.getConnection();
        if (conn == null) {
            return null;
        }

        String sql = "SELECT * FROM cua_hang_tien_loi.hoa_don WHERE CUSTOMER_ID = ?";
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ma_kh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String iv_id = rs.getString("INVOICE_ID");
                String cus_id = rs.getString("CUSTOMER_ID");
                String EMP_ID = rs.getString("EMP_ID");
                java.sql.Date Date = rs.getDate("INVOICE_DATE");
                float total = rs.getFloat("TOTAL");
                String method = rs.getString("METHOD");

                dsHoaDon.add(new HoaDon(iv_id, cus_id, EMP_ID, Date, total, method));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

}
