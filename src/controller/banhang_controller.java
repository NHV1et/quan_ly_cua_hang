/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.khach_hang_DAO;
import javax.swing.JOptionPane;
import model.khach_hang;
import view.giaodienbanhang;
import model.sp_DAO;
import model.hoa_don_DAO;
import model.HoaDon;
import model.SanPham;
/**
 *
 * @author admin
 */
public class banhang_controller {
    private  giaodienbanhang view;
    private  khach_hang_DAO dao;
    private sp_DAO sp_dao;
    private hoa_don_DAO hd_dao;
    
    public banhang_controller(giaodienbanhang view) {
        this.view = view;
        this.dao = new khach_hang_DAO();
        this.sp_dao = new sp_DAO();
        this.hd_dao = new hoa_don_DAO();
        initController();
    }
    
    private void initController() {
        // Sự kiện Enter khi nhập khách hàng
        view.nhan_khach(e -> themKhachHang());

        // Sự kiện tìm kiếm sản phẩm
        view.btnTimKiem.addActionListener(e -> view.timKiemSanPham());

        // Sự kiện thanh toán
        view.btnThanhToan.addActionListener(e -> xuLyThanhToan());
    }
    
    private void themKhachHang() {
        try {
            String maKH   = view.getMaKH();
            String tenKH  = view.getTenKH();
            String diaChi = view.getDiaChi();
            String sdt    = view.getSDT();
            int diem      = Integer.parseInt(view.getDiem());

            khach_hang kh = new khach_hang(maKH, tenKH, sdt, "", diem); // Email để trống nếu chưa có
            boolean ok = dao.themKhachHang(kh);

            view.hienThiThongBao(ok ? "Thêm khách hàng thành công!" : "Thêm khách hàng thất bại!");
        } catch (NumberFormatException ex) {
            view.hienThiThongBao("Điểm phải là số nguyên.");
        }
    }
    
    private void xuLyThanhToan() {
        String[] options = { "Tiền mặt", "Thẻ" };
        int choice = JOptionPane.showOptionDialog(
            null,
            "Chọn phương thức thanh toán:",
            "Thanh toán",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == -1) return; // Người dùng đóng hộp thoại

        String method = options[choice];
        String invoiceId = "HD" + System.currentTimeMillis();
        String customerId = view.getMaKH();
        String empId = view.getMaNV();
        java.sql.Date invoiceDate = new java.sql.Date(System.currentTimeMillis());
        float total = Float.parseFloat(view.getBtnTong().getText());

        HoaDon hd = new HoaDon(invoiceId, customerId, empId, invoiceDate, total, method);
        boolean ok = hd_dao.insertHoaDon(hd);

        view.hienThiThongBao(ok ? "Thanh toán thành công!" : "Lưu hóa đơn thất bại!");
    }
}
