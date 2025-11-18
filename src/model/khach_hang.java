package model;
import java.sql.*;
import quanlycuahang.Ket_Noi_DB;

public class khach_hang {
    // 🔐 Thuộc tính (private để đảm bảo đóng gói)
    private String customerId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private int point;

    // 🏗 Constructor mặc định
    public khach_hang() {}

    // 🏗 Constructor đầy đủ
    public khach_hang(String customerId, String customerName, String customerPhone, String customerEmail, int point) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        setPoint(point); // dùng setter để đảm bảo kiểm tra >= 0
    }

    // 📥 Getter và Setter
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        if (point >= 0) {
            this.point = point;
        } else {
            throw new IllegalArgumentException("Điểm tích lũy phải >= 0");
        }
    }

    // 🔍 Phương thức tiện ích (tùy chọn)
    @Override
    public String toString() {
        return "khach_hang{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", point=" + point +
                '}';
    }
    
    //=========CAC HAM THAO TAC VOI MySQL=========================
    
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
        return false;
    }
}
}
