package com.employeems.dao;

import com.employeems.model.Employee;
import com.employeems.util.DBConnection;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    public void addEmployee(Employee e) throws SQLException {
        String sql="INSERT INTO employees(name,email,department,salary) VALUES(?,?,?,?)";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){p.setString(1,e.getName());p.setString(2,e.getEmail());p.setString(3,e.getDepartment());p.setDouble(4,e.getSalary());p.executeUpdate();}
    }
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list=new ArrayList<>(); String sql="SELECT * FROM employees ORDER BY id DESC";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql); ResultSet r=p.executeQuery()){while(r.next()) list.add(new Employee(r.getInt("id"),r.getString("name"),r.getString("email"),r.getString("department"),r.getDouble("salary")));}
        return list;
    }
    public Employee getEmployee(int id) throws SQLException {
        String sql="SELECT * FROM employees WHERE id=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){p.setInt(1,id);try(ResultSet r=p.executeQuery()){if(r.next()) return new Employee(r.getInt("id"),r.getString("name"),r.getString("email"),r.getString("department"),r.getDouble("salary"));}}
        return null;
    }
    public void updateEmployee(Employee e) throws SQLException {
        String sql="UPDATE employees SET name=?,email=?,department=?,salary=? WHERE id=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){p.setString(1,e.getName());p.setString(2,e.getEmail());p.setString(3,e.getDepartment());p.setDouble(4,e.getSalary());p.setInt(5,e.getId());p.executeUpdate();}
    }
    public void deleteEmployee(int id) throws SQLException {
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement("DELETE FROM employees WHERE id=?")){p.setInt(1,id);p.executeUpdate();}
    }
}
