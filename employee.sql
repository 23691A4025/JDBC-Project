CREATE DATABASE IF NOT EXISTS employee;

USE employee;

CREATE TABLE IF NOT EXISTS Employee (
    id INT PRIMARY KEY,
    name VARCHAR(20),
    job_role VARCHAR(20),
    salary INT,
    hire_date DATE
);