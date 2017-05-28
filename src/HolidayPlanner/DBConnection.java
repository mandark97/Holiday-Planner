package HolidayPlanner;

import java.sql.*;
import java.util.ArrayList;


public class DBConnection
{
    private Connection connection;
    private static DBConnection ourInstance = new DBConnection();


    public static Connection getConnection()
    {
        return ourInstance.connection;
    }

    private DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/holidayplanner?useSSL=false",
                    "root", "root");

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void close()
    {
        try
        {
            ourInstance.connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }




    public static void main(String[] args)
    {
        Employee em = new Employee("Test","Test","123456", "test@gmail.com",10);

        if(em.register()) {
            System.out.println("User registered successfully");
        } else {
            System.out.println("User registration failed");
        }

        ArrayList<Employee> employees = Employee.getAllEmployees();
        employees.forEach(System.out::println);

        DBConnection.close();
    }
}
