import java.sql.*;
import java.util.ArrayList;

/**
 * Created by ManDark on 25-May-17.
 */
public class DBConnection
{
    private static DBConnection ourInstance = new DBConnection();

    public static DBConnection getInstance()
    {
        return ourInstance;
    }

    private Connection connection;

    private DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/holidayplanner", "root", "root");

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void createHR(HR hr)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO holidayplanner.hrs(firstName,lastName,email,password) VALUES(?,?,?,?)");
            statement.setString(1, hr.firstName);
            statement.setString(2, hr.lastName);
            statement.setString(3, hr.email);
            statement.setString(4, hr.password);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e)
        {
            //System.out.println("duplicat");
            e.printStackTrace();
        }
    }

    public void createEmployee(Employee employee)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO holidayplanner.employees(firstName,lastName,email,password,vacantionDays) " +
                    "VALUES(?,?,?,?,?)");
            statement.setString(1, employee.firstName);
            statement.setString(2, employee.lastName);
            statement.setString(3, employee.email);
            statement.setString(4, employee.password);
            statement.setString(5, String.valueOf(employee.vacantionDays));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public HR loginHR(String email, String password)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM holidayplanner.hrs WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.wasNull())
                return null;
            if (rs.next())
            {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String pass = rs.getString("password");
                String em = rs.getString("email");
                return new HR(firstName, lastName, pass, email);
            }
            return null;
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Employee loginEmployee(String email, String password)
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM holidayplanner.employees WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.wasNull())
                return null;
            if (rs.next())
            {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String pass = rs.getString("password");
                String em = rs.getString("email");
                int vacantionDays = rs.getInt("vacantionDays");
                return new Employee(firstName, lastName, pass, email, vacantionDays);
            }
            return null;
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Employee> getEmployees()
    {
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM holidayplanner.employees");
            ArrayList<Employee> employees = new ArrayList<>();
            while (rs.next())
            {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int vacantionDays = rs.getInt("vacantionDays");
                employees.add(new Employee(firstName, lastName, password, email, vacantionDays));
            }
            return employees;
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args)
    {
        DBConnection connection = DBConnection.getInstance();
        connection.createEmployee(new Employee("Oana","Naspa","123","oana@wow.com",1));
        ArrayList<Employee> employees = connection.getEmployees();
        employees.forEach(a->System.out.print(a+" "));
        connection.close();
    }
}
