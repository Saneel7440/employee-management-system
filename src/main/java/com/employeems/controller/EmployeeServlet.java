package com.employeems.controller;

import com.employeems.dao.EmployeeDAO;
import com.employeems.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/employees/*")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO dao;
    public void init(){dao=new EmployeeDAO();}
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String path=req.getPathInfo();
        try{
            if("/new".equals(path)){req.getRequestDispatcher("/employee-form.jsp").forward(req,resp);}
            else if("/edit".equals(path)){req.setAttribute("employee",dao.getEmployee(Integer.parseInt(req.getParameter("id"))));req.getRequestDispatcher("/employee-form.jsp").forward(req,resp);}
            else if("/delete".equals(path)){dao.deleteEmployee(Integer.parseInt(req.getParameter("id")));resp.sendRedirect(req.getContextPath()+"/employees");}
            else {req.setAttribute("employees",dao.getAllEmployees());req.getRequestDispatcher("/employees.jsp").forward(req,resp);}
        }catch(Exception e){throw new ServletException(e);}
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        try{
            int id=Integer.parseInt(req.getParameter("id"));
            Employee e=new Employee(req.getParameter("name"),req.getParameter("email"),req.getParameter("department"),Double.parseDouble(req.getParameter("salary")));
            if(id==0) dao.addEmployee(e); else {e.setId(id);dao.updateEmployee(e);}
            resp.sendRedirect(req.getContextPath()+"/employees");
        }catch(Exception e){throw new ServletException(e);}
    }
}
