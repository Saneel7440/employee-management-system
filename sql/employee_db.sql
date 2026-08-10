CREATE DATABASE IF NOT EXISTS employee_db;
USE employee_db;
CREATE TABLE IF NOT EXISTS employees (
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 email VARCHAR(150) NOT NULL UNIQUE,
 department VARCHAR(100) NOT NULL,
 salary DECIMAL(10,2) NOT NULL
);
INSERT INTO employees(name,email,department,salary) VALUES
('Rahul Patil','rahul@example.com','IT',45000),
('Amit Sharma','amit@example.com','HR',40000);
