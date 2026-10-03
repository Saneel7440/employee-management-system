# Employee Management System

A Java web application for managing employee records using JSP, Servlets, JDBC and MySQL.

## Features
- Add employee
- View all employees
- Edit employee
- Delete employee
- MySQL database integration
- PreparedStatement for database operations

## Tech Stack
Java 17, JSP, Servlets 4, JDBC, MySQL, JSTL, HTML, CSS, Apache Tomcat 9, Maven.

## Requirements
- JDK 17+
- Maven
- MySQL 8+
- Apache Tomcat 9

## Setup
1. Create the database by running `sql/employee_db.sql` in MySQL.
2. Open `src/main/java/com/employeems/util/DBConnection.java` and change the MySQL username/password.
3. Run `mvn clean package`.
4. Deploy `target/employee-management-system.war` to Tomcat 9.
5. Open `http://localhost:8080/employee-management-system/`.

## Resume Description
Developed a web-based Employee Management System with CRUD operations using JSP, Servlets, JDBC and MySQL. Implemented employee record management and secure database operations using PreparedStatement, applying OOP and MVC concepts.
