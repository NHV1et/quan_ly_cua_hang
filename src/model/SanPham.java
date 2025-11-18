
package model;

import java.sql.*;
import quanlycuahang.Ket_Noi_DB;
import java.sql.Timestamp;
public class SanPham {
    private String prodId;
    private int ton_kho;
    private String prodName;
    private float price;
    private int quantity;
    private Timestamp exp_date;
    private boolean isSelected;
    private String promo_type = "Chưa có!";

    public SanPham(String prodId, String prodName, float price, int quantity, Timestamp exp_date, int x) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
        this.quantity = quantity;
        this.exp_date = exp_date;
        this.isSelected = false;
        this.ton_kho = x;
    }

    // Getters & Setters cho tất cả, bao gồm isSelected
    
    // Getters
    public String getProdId() { return prodId; }
    public String getProdName() { return prodName; }
    public float getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Timestamp getExpDate() { return exp_date; }
    public int get_ton_kho() { return ton_kho;}
    public String getPromoType() {return promo_type;}

    // Setters
    public void setProdId(String prodId) { this.prodId = prodId; }
    public void setProdName(String prodName) { this.prodName = prodName; }
    public void setPrice(float price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setExpDate(Timestamp expDate) { this.exp_date = expDate; }
    
    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { isSelected = selected; }
    
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
    

}
