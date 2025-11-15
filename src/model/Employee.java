package model;

public class Employee {
    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private double empSalary;
    private java.sql.Date empSchedule;

    public Employee(String empId, String empName, String empPhone, String empEmail, double empSalary, java.sql.Date empSchedule) {
        this.empId = empId;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empSalary = empSalary;
        this.empSchedule = empSchedule;
    }

    // Getters
    public String getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getEmpPhone() { return empPhone; }
    public String getEmpEmail() { return empEmail; }
    public double getEmpSalary() { return empSalary; }
    public java.sql.Date getEmpSchedule() { return empSchedule; }

    // Setters
    public void setEmpId(String empId) { this.empId = empId; }
    public void setEmpName(String empName) { this.empName = empName; }
    public void setEmpPhone(String empPhone) { this.empPhone = empPhone; }
    public void setEmpEmail(String empEmail) { this.empEmail = empEmail; }
    public void setEmpSalary(double empSalary) { this.empSalary = empSalary; }
    public void setEmpSchedule(java.sql.Date empSchedule) { this.empSchedule = empSchedule; }
}
