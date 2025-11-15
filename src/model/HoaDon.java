package model;
import quanlycuahang.Ket_Noi_DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDon {
    private String invoiceId, customerId, empId, method;
    private java.sql.Date invoiceDate;
    private float total;

    public HoaDon(String invoiceId, String customerId, String empId, java.sql.Date invoiceDate, float total, String method) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.empId = empId;
        this.invoiceDate = invoiceDate;
        this.total = total;
        this.method = method;
    }

    // Getters
    public String getInvoiceId() {return invoiceId;}
    public String getCustomerId() {return customerId;}
    public String getEmpId() {return empId;}
    
    public java.sql.Date getInvoiceDate() {return invoiceDate;} // Getter cho invoiceDate
    public float getTotal() {return total;}                     // Getter cho total
    public String getMethod() {return method;}                   // Getter cho method
    
    //Setters
    public void setInvoiceId(String invoiceId) {this.invoiceId = invoiceId;}
    public void setCustomerId(String customerId) {this.customerId = customerId;}
    public void setEmpId(String empId) {this.empId = empId;}
    public void setInvoiceDate(java.sql.Date invoiceDate) {this.invoiceDate = invoiceDate;} // Setter cho invoiceDate
    public void setTotal(float total) {this.total = total;}                               // Setter cho total
    public void setMethod(String method) {this.method = method;}
    
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
            return false;
        }
    }
    
}
