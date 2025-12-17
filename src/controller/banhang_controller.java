/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.SQLException;
import model.Emp_DAO;
import model.hoa_don_DAO;
import model.khach_hang_DAO;
import model.sp_DAO;
import java.util.List;
import model.Employee;
import model.HoaDon;
import model.SanPham;
import model.khach_hang;
/**
 *
 * @author admin
 */

/*

Model: Quản lý dữ liệu và logic nghiệp vụ. Là cầu nối giữa View và Controller, thường kết nối cơ sở dữ liệu, xử lý và chuẩn bị dữ liệu để gửi cho các thành phần khác.
View: Giao diện hiển thị cho người dùng. Chỉ nhận dữ liệu từ Model, không trực tiếp lấy từ Controller.
Controller: Xử lý yêu cầu từ người dùng, cập nhật Model và trả kết quả cho View. Không chứa logic nghiệp vụ.

*/
public class banhang_controller {
    
    // Khai báo DAO (Trung gian lưu chuyển dữ liệu giữa Controller và DB)
    private final hoa_don_DAO hd_DAO = new hoa_don_DAO();
    private final Emp_DAO emp_DAO = new Emp_DAO();
    private final khach_hang_DAO kh_DAO = new khach_hang_DAO();
    private final sp_DAO sp_DAO = new sp_DAO();
    
    // Các phương thức thực hiện truy tìm các thực thể tương ứng trong DB
    public khach_hang tim_kh_ma(String ma_kh)
    {
        return kh_DAO.timkhach_hangTheoMa(ma_kh);
    }
    
    public Employee tim_nv_ma(String emp_ID)
    {
        return emp_DAO.find_emp(emp_ID);
    }
    
    public SanPham tim_sp_ma(String ma_sp)
    {
        return sp_DAO.timSanPhamTheoMa(ma_sp);
    }
    
    public boolean chen_hd(HoaDon hd)
    {
        return hd_DAO.insertHoaDon(hd);
    }
    
    public boolean them_kh(khach_hang kh)
    {
        return kh_DAO.themKhachHang(kh);
    }
    
}
