package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quanlycuahang.Ket_Noi_DB;
public class Emp_DAO {
    public boolean insertEmployee(Employee emp) {
        Connection conn = Ket_Noi_DB.getConnection();
        if (conn == null) return false;

        String sql = "INSERT INTO employee (EMP_ID, EMP_NAME, EMP_SALARY, EMP_SCHEDULE, EMP_PHONE, EMP_EMAIL) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getEmpId());
            ps.setString(2, emp.getEmpName());
            ps.setDouble(3, emp.getEmpSalary());
            ps.setDate(4, emp.getEmpSchedule());
            ps.setString(5, emp.getEmpPhone());
            ps.setString(6, emp.getEmpEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Employee find_emp(String emp_ID) {
    Connection conn = Ket_Noi_DB.getConnection();
    if (conn == null) return null;

    String sql = "SELECT EMP_NAME, EMP_PHONE, EMP_EMAIL, EMP_SALARY, EMP_SCHEDULE FROM employee WHERE EMP_ID = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, emp_ID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String name = rs.getString("EMP_NAME");
            String phone = rs.getString("EMP_PHONE");
            String email = rs.getString("EMP_EMAIL");
            double salary = rs.getDouble("EMP_SALARY");
            java.sql.Date schedule = rs.getDate("EMP_SCHEDULE");

            return new Employee(emp_ID, name, phone, email, salary, schedule);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

}
