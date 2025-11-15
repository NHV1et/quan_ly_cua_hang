
package model;

import java.sql.Timestamp;
public class SanPham {
    private String prodId;
    private String prodName;
    private float price;
    private int quantity;
    private Timestamp exp_date;
    private boolean isSelected;

    public SanPham(String prodId, String prodName, float price, int quantity, Timestamp exp_date) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
        this.quantity = quantity;
        this.exp_date = exp_date;
        this.isSelected = false;
    }

    // Getters & Setters cho tất cả, bao gồm isSelected
    
    // Getters
    public String getProdId() { return prodId; }
    public String getProdName() { return prodName; }
    public float getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Timestamp getExpDate() { return exp_date; }

    // Setters
    public void setProdId(String prodId) { this.prodId = prodId; }
    public void setProdName(String prodName) { this.prodName = prodName; }
    public void setPrice(float price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setExpDate(Timestamp expDate) { this.exp_date = expDate; }
    
    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { isSelected = selected; }
}
