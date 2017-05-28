package HolidayPlanner;

import java.sql.*;
import java.util.ArrayList;


public class Employee extends User
{
    protected int vacantionDays;

    public Employee(String firstName, String lastName, String password, String email, int vacantionDays)
    {
        super(firstName, lastName, password, email);
        this.vacantionDays = vacantionDays;
    }

    static
    {
        dbSchema = "holidayplanner";
        dbTable = "employees";
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", vacantionDays=" + vacantionDays +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    protected PreparedStatement getInsertStatement() throws SQLException {
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO " + dbSchema + "." + dbTable
                        +"(firstName,lastName,email,password,vacantionDays) "
                        + "VALUES(?,?,?,?,?)");
        statement.setString(1, this.firstName);
        statement.setString(2, this.lastName);
        statement.setString(3, this.email);
        statement.setString(4, this.password);
        statement.setString(5, String.valueOf(this.vacantionDays));

        return statement;
    }

    protected static User createUser(ResultSet rs) {
        try {
            return new Employee(rs.getString("firstName"), rs.getString("lastName"),
                    rs.getString("password"), rs.getString("email"), rs.getInt("vacantionDays"));
        } catch(SQLException e) {
            return null;
        }
    }

    public static User login(String email, String password) {
        try {
            return loginUser(email, password, Employee::createUser);
        } catch (SQLException e) {
            return null;
        }
    }

    public static String[][] getAllEmployees()
    {
        try
        {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + dbSchema + "." + dbTable);
            ArrayList<String[]> employees = new ArrayList<>();

            while (rs.next())
            {	
                employees.add(new String[]{rs.getString("firstName"), 
                		rs.getString("lastName"), rs.getString("password"), 
                		rs.getString("email"), rs.getString("vacantionDays")});
            }
            
            
            String[][] employeesData = new String[employees.size()][];
            
            for(int i = 0; i < employees.size(); i++) {
            	employeesData[i] = employees.get(i);
            }
            
            return employeesData;
        } catch (SQLException e)
        {
            return null;
        }

    }
      
}
