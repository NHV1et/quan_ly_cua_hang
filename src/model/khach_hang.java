package model;

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
}
