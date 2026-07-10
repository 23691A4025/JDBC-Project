# Employee Management System

A Java-based **Employee Management System** developed using **JDBC** and **MySQL**. This project demonstrates CRUD (Create, Read, Update, Delete) operations through a menu-driven console application.

## Features

- Create Employee Table
- Insert Employee Records
- Display Employee Records
- Update Employee Salary
- Delete Employee Records
- Display Specific Column Data
- MySQL Database Connectivity using JDBC

## Tech Stack

- Java
- JDBC
- MySQL
- VS Code
- Git & GitHub

## Database

**Database:** `employee`

**Table:** `Employee`

| Column | Type |
|--------|------|
| id | INT (Primary Key) |
| name | VARCHAR(20) |
| job_role | VARCHAR(20) |
| salary | INT |
| hire_date | DATE |

## Project Structure

```
JDBC-Project
├── EmployeeManagementSystem.java
├── README.md
└── .gitignore
```

## Getting Started

1. Clone the repository

```bash
git clone https://github.com/23691A4025/JDBC-Project.git
```

2. Create a MySQL database

```sql
CREATE DATABASE employee;
```

3. Update your MySQL username and password in:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/employee",
    "root",
    "your_password"
);
```

4. Compile the program

```bash
javac EmployeeManagementSystem.java
```

5. Run the program

```bash
java EmployeeManagementSystem
```

## Sample Menu

```text
========== Employee Management System ==========

1. Create Table
2. Insert Record
3. Display Records
4. Update Salary
5. Delete Record
6. Display Column
7. Exit
```

## Learning Outcomes

- Java JDBC
- MySQL Database Connectivity
- CRUD Operations
- PreparedStatement
- ResultSet
- SQL Queries
- Exception Handling

## Author

**Emme Likhitha**

<<<<<<< HEAD
GitHub:https://github.com/emmelikhitha/Employee-Management-System
=======
GitHub: https://github.com/emmelikhitha/Employee-Management-System
>>>>>>> ac578c0f2ad4ff39c6f372f5ae95f34715f2a943
