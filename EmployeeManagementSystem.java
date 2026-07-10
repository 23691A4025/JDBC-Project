import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {

    public static void create(Statement st, Scanner sc) throws Exception {
        System.out.print("Enter table name: ");
        String tableName = sc.next();

        st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " + tableName + "(" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(20)," +
                "job_role VARCHAR(20)," +
                "salary INT," +
                "hire_date DATE)");

        System.out.println("Table created successfully");
    }

    public static void insert(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Job Role: ");
        String jobRole = sc.next();

        System.out.print("Enter Salary: ");
        int salary = sc.nextInt();

        System.out.print("Enter Hire Date (yyyy-mm-dd): ");
        String hireDate = sc.next();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Employee(id,name,job_role,salary,hire_date) VALUES(?,?,?,?,?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, jobRole);
        ps.setInt(4, salary);
        ps.setDate(5, java.sql.Date.valueOf(hireDate));

        ps.executeUpdate();

        System.out.println("Record inserted successfully");
    }

    public static void display(Statement st) throws Exception {

        ResultSet rs = st.executeQuery("SELECT * FROM Employee");

        System.out.println("----------------------------------------------");
        System.out.println("ID\tNAME\tROLE\tSALARY\tHIRE DATE");
        System.out.println("----------------------------------------------");

        while (rs.next()) {

            System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("job_role") + "\t" +
                    rs.getInt("salary") + "\t" +
                    rs.getDate("hire_date"));
        }
    }

    public static void update(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Salary: ");
        int salary = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE Employee SET salary=? WHERE id=?");

        ps.setInt(1, salary);
        ps.setInt(2, id);

        ps.executeUpdate();

        System.out.println("Updated successfully");
    }

    public static void delete(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Employee WHERE id=?");

        ps.setInt(1, id);

        ps.executeUpdate();

        System.out.println("Deleted successfully");
    }

    public static void columnDisplay(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter Column Name: ");
        String column = sc.next();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT " + column + " FROM Employee");

        while (rs.next()) {
            System.out.println(rs.getObject(column));
        }
    }

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee",
                "root",
                "Likhi@0124");

        Statement st = con.createStatement();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Create Table");
            System.out.println("2. Insert");
            System.out.println("3. Display");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Column Display");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    create(st, sc);
                    break;

                case 2:
                    insert(con, sc);
                    break;

                case 3:
                    display(st);
                    break;

                case 4:
                    update(con, sc);
                    break;

                case 5:
                    delete(con, sc);
                    break;

                case 6:
                    columnDisplay(con, sc);
                    break;

                case 7:
                    con.close();
                    sc.close();
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}